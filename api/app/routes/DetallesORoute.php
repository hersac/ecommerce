<?php

namespace app\routes;

use app\config\Error;
use app\controllers\DetallesOController;
use app\interfaces\RouterInterface;

class DetallesORoute implements RouterInterface {
    private $detallesOController;

    public function __construct() {
        $this->detallesOController = new DetallesOController();
    }

    public function handlerRoutes(){

        $url = $_SERVER['REQUEST_URI'];
        $method = $_SERVER["REQUEST_METHOD"];

        $pattern = "#/(\w+)/(\w+)/(\d+)#";
        preg_match($pattern, $url, $matches);

        $id = isset($matches[3]) ? $matches[3] : null;
        $base = isset($matches[3]) ? $matches[2] : null;

        $postData = file_get_contents("php://input");
        $body = json_decode($postData, true);

        if ($url === "/api/detallesordenes") {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->detallesOController->getDetallesO();
                    exit();
                case 'POST':
                    echo $this->detallesOController->createDetalleO($body);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }

        } elseif ("/$base" === "/detallesordenes" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->detallesOController->getDetalleOConId($id);
                    exit();
                case 'PUT':
                    echo $this->detallesOController->updateDetalleO($id, $body);
                    exit();
                case 'DELETE':
                    echo $this->detallesOController->deleteDetalleO($id);
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
