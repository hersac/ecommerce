<?php

use app\routes\ProductosRoute;

$prodRoute = new ProductosRoute();

if ($_SERVER['REQUEST_URI'] === '/api/products') {

    header('Content-Type: application/json');

    echo $prodRoute->getProducts();

    exit();
}
