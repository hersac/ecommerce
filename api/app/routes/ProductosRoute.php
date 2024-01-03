<?php

namespace app\routes;

use app\controllers\ProductosController;


class ProductosRoute {
    private $prodController;

    public function __construct() {
        $this->prodController = new ProductosController();
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

        if ($url === "/api/productos") {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->prodController->getProductos();
                    exit();
                case 'POST':
                    echo $this->prodController->createProducto($body);
                    exit();
                default:
                    echo $this->errorHttp();
                    break;
            }

        } elseif ("/$base" === "/productos" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->prodController->getProductoConId($id);
                    exit();
                case 'PUT':
                    echo $this->prodController->updateProducto($id, $body);
                    exit();
                case 'DELETE':
                    echo $this->prodController->deleteProducto($id);
                    exit();
                default:
                    echo $this->errorHttp();
                    break;
            }
        } else {
            echo $this->errorHttp();
        }
    }

    private function errorHttp()
    {
        header('HTTP/1.1 404 Not Found');

        $response = [
            'message'=>'404 Not Found',
            'status'=>'404'
        ];

        $json =json_encode($response);
        echo $json;
        exit();
    }
}
