<?php

namespace app\config;

class Routes {

    private $baseRoute;

    public function __construct() {
        $this->baseRoute = '/api';
    }

    public function get($route, $controller) {

        $routeFinal = $this->baseRoute . $route;

        if ($_SERVER['REQUEST_URI'] === $routeFinal) {
            if ($_SERVER["REQUEST_METHOD"] === 'GET') {
                header('Content-Type: application/json');
                echo $controller;
                exit();
            } 
        } else {
            echo $this->errorHttp();
        }
    }

    public function post($route, $controller) {

        $routeFinal = $this->baseRoute . $route;

        if ($_SERVER['REQUEST_URI'] === $routeFinal) {
            if ($_SERVER["REQUEST_METHOD"] === 'POST') {
                header('Content-Type: application/json');

                echo $controller;

                exit();
            }
        } else {
            echo $this->errorHttp();
        }
    }

    public function put($route, $controller) {
        $routeFinal = $this->baseRoute . $route;

        if ($_SERVER['REQUEST_URI'] === $routeFinal) {
            if ($_SERVER["REQUEST_METHOD"] === 'PUT') {
                header('Content-Type: application/json');

                echo $controller;

                exit();
            }
        } else {
            echo $this->errorHttp();
        }
    }

    public function delete($route, $controller) {
        $routeFinal = $this->baseRoute . $route;

        if ($_SERVER['REQUEST_URI'] === $routeFinal) {
            if ($_SERVER["REQUEST_METHOD"] === 'POST') {
                header('Content-Type: application/json');

                //echo $controller;

                exit();
            } 
        } else {
            echo $this->errorHttp();
        }
    }

    private function errorHttp() {
        header('HTTP/1.1 404 Not Found');
        echo '404 Not Found';
        exit();
    }
}
