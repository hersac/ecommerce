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
        $this->routes->get("/productos", $this->prodController->getProductos());
        $this->routes->get("/productos/:id", $this->prodController->getProductoConId());
        $this->routes->post("/productos", $this->prodController->createProducto());
        $this->routes->put("/productos", $this->prodController->updateProducto());
        $this->routes->delete("/productos", $this->prodController->deleteProducto());
    }
}
