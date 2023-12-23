<?php

use app\controllers\ProductosController;

$baseURL = $_SERVER['REQUEST_URI'];
$method = $_SERVER['REQUEST_METHOD'];

$controller = new ProductosController();

if(parse_url($baseURL, PHP_URL_PATH)){
    switch ($method) {
        case 'GET':
            echo $controller->getProductos(); 
            break;
        
        case 'POST':
            # code...
            break;
        
        case 'PUT':
            # code...
            break;
        
        case 'DELETE':
            # code...
            break;
        
        default:
            # code...
            break;
    }
}
