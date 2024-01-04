<?php

namespace app\routes;

use app\config\Error;
use app\controllers\CarritoComprasController;
use app\interfaces\RouterInterface;

class CarritoComprasRoute implements RouterInterface {
    private $carritoComprasController;

    public function __construct() {
        $this->carritoComprasController = new CarritoComprasController();
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

        if ($url === "/api/carritocompras") {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->carritoComprasController->getCarritosCompras();
                    exit();
                case 'POST':
                    echo $this->carritoComprasController->createCarritoCompras($body);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }

        } elseif ("/$base" === "/carritocompras" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->carritoComprasController->getCarritoComprasConId($id);
                    exit();
                case 'PUT':
                    echo $this->carritoComprasController->updateCarritoCompras($id, $body);
                    exit();
                case 'DELETE':
                    echo $this->carritoComprasController->deleteCarritoCompras($id);
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
