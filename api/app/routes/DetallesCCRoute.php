<?php

namespace app\routes;

use app\config\Error;
use app\controllers\DetallesCCController;
use app\interfaces\RouterInterface;

class DetallesCCRoute implements RouterInterface
{
    private $detallesCCController;

    public function __construct()
    {
        $this->detallesCCController = new DetallesCCController();
    }

    public function handlerRoutes()
    {
        $url = $_SERVER['REQUEST_URI'];
        $method = $_SERVER["REQUEST_METHOD"];
        $headers = getallheaders();
        $token = isset($headers['Authorization']) ? $headers['Authorization'] : null;
        $pattern = "#/(\w+)/(\w+)/(\d+)#";
        preg_match($pattern, $url, $matches);
        $id = isset($matches[3]) ? $matches[3] : null;
        $base = isset($matches[3]) ? $matches[2] : null;

        $postData = file_get_contents("php://input");
        $body = json_decode($postData, true);

        if ($url === "/api/detallescc") {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->detallesCCController->getDetallesCC($token);
                    exit();
                case 'POST':
                    echo $this->detallesCCController->createDetalleCC($body, $token);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }
        } elseif ("/$base" === "/detallescc" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->detallesCCController->getDetalleCCConId($id, $token);
                    exit();
                case 'PUT':
                    echo $this->detallesCCController->updateDetalleCC($id, $body, $token);
                    exit();
                case 'DELETE':
                    echo $this->detallesCCController->deleteDetalleCC($id, $token);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }
        } else {
            $error = new Error(404, "Not Found");
        }
    }
}
