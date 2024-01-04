<?php

namespace app\routes;

use app\config\Error;
use app\controllers\UsuariosController;
use app\interfaces\RouterInterface;

class UsuariosRoute implements RouterInterface {
    private $userController;

    public function __construct() {
        $this->userController = new UsuariosController();
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

        if ($url === "/api/usuarios") {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->userController->getUsuarios();
                    exit();
                case 'POST':
                    echo $this->userController->createUsuario($body);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }

        } elseif ("/$base" === "/usuarios" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->userController->getUsuarioConId($id);
                    exit();
                case 'PUT':
                    echo $this->userController->updateUsuario($id, $body);
                    exit();
                case 'DELETE':
                    echo $this->userController->deleteUsuario($id);
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
