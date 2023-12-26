<?php

namespace app\routes;

use app\controllers\ProductosController;

class ProductosRoute {
    private $prodController;

    public function __construct() {
        $this->prodController = new ProductosController();;
    }

    public function getProducts() {
        echo $this->prodController->getProductos();
    }

    public function getProduct($id) {
        echo $this->prodController->getProductoConId($id);
    }

    public function createProduct($entity) {
        echo $this->prodController->createProducto($entity);
    }

    public function updateProduct($id, $entity) {
        echo $this->prodController->updateProducto($id, $entity);
    }

    public function deleteProduct($id) {
        echo $this->prodController->deleteProducto($id);
    }
}
