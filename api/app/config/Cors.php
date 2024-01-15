<?php

namespace app\config;

class Cors
{
    public function success()
    {
        // Permitir solicitudes desde cualquier origen
        header("Access-Control-Allow-Origin: *");

        // Permitir los métodos y encabezados que necesitas
        header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
        header("Access-Control-Allow-Headers: Content-Type, Authorization");

        // Si la solicitud es OPTIONS, responde con éxito y termina
        if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
            header('HTTP/1.1 200 OK');
            exit();
        }

        // Resto del código del servidor aquí

    }
}
