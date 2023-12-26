<?php

use app\routes\ProductosRoute;

$baseURL = $_SERVER['REQUEST_URI'];
$method = $_SERVER['REQUEST_METHOD'];
$prodRoute = null;

// Define el patrón de URL esperado
$urlPattern = '/^\/api\/productos\/?$/';

// Verifica si la URL coincide con el patrón
if (preg_match($urlPattern, $baseURL)) {
    // La URL coincide con el patrón, crea la instancia de ProductosRoute
    $prodRoute = new ProductosRoute();
}

if ($prodRoute) {
    // La instancia de ProductosRoute se creó correctamente, realiza acciones según el método HTTP
    switch ($method) {
        case 'GET':
            echo $prodRoute->getProducts();
            break;
        
        case 'POST':
            // Código para el método POST
            break;
        
        case 'PUT':
            // Código para el método PUT
            break;
        
        case 'DELETE':
            // Código para el método DELETE
            break;
        
        default:
            // Código para otros métodos
            break;
    }
} else {
    // La URL no coincide con el patrón, puedes manejar esto de acuerdo a tus necesidades
    echo "URL no válida";
}
