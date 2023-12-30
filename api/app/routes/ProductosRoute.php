<?php

namespace app\routes;

use app\config\Routes;
use app\controllers\ProductosController;


class ProductosRoute {
    private $prodController;
    private $routes;

    public function __construct() {
        $this->prodController = new ProductosController();
        $this->routes = new Routes();
    }

    public function handlerRoutes(){

        $url = $_SERVER['REQUEST_URI'];

        preg_match("/\/productos\/(\d+)/", $url, $matches);
        $id = isset($matches[1]) ? $matches[1] : null;

        echo $id;

        $postData = file_get_contents("php://input");
        $body = json_decode($postData, true);

        $this->routes->get("/productos", $this->prodController->getProductos());
        //$this->routes->get("/productos", $this->prodController->getProductoConId($id));
        $this->routes->post("/productos", $this->prodController->createProducto($body));
        //$this->routes->put("/productos", $this->prodController->updateProducto($id, $body));
        //$this->routes->delete("/productos", $this->prodController->deleteProducto($id));
    }
}
