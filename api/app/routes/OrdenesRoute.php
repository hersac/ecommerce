<?php

namespace app\routes;

use app\config\Error;
use app\controllers\OrdenesController;
use app\interfaces\RouterInterface;

class OrdenesRoute implements RouterInterface
{
    private $ordController;

    public function __construct()
    {
        $this->ordController = new OrdenesController();
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

        if ($url === "/api/ordenes") {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->ordController->getOrdenes($token);
                    exit();
                case 'POST':
                    if (empty($body))
                        $error = new Error(400, "Unrecognized error");
                    echo $this->ordController->createOrden($body, $token);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }
        } elseif ("/$base" === "/ordenes" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->ordController->getOrdenConId($id, $token);
                    exit();
                case 'PUT':
                    if (empty($body) || empty($id))
                        $error = new Error(400, "Unrecognized error");
                    echo $this->ordController->updateOrden($id, $body, $token);
                    exit();
                case 'DELETE':
                    echo $this->ordController->deleteOrden($id, $token);
                    exit();
                default:
                    $error = new Error(40, "Method Not Allowed");
                    break;
            }
        } else {
            $error = new Error(404, "Not Found");
        }
    }
}
