<?php

namespace app\routes;

use app\config\Error;
use app\controllers\UsuariosController;
use app\interfaces\RouterInterface;

class UsuariosRoute implements RouterInterface
{
    private $userController;

    public function __construct()
    {
        $this->userController = new UsuariosController();
    }

    public function handlerRoutes()
    {

        $url = $_SERVER['REQUEST_URI'];
        $method = $_SERVER["REQUEST_METHOD"];
        $headers = getallheaders();
        $token = isset($headers['Authorization']) ? $headers['Authorization'] : null;
        $pattern = "#/(\w+)/(\w+)/(\d+)#";
        preg_match($pattern, $url, $matches);

        $id = isset($matches[3]) ? $matches[3] : null;
        $base = isset($matches[3]) ? $matches[2] : null;

        $postData = file_get_contents("php://input");
        $body = json_decode($postData, true);

        if ($url === "/api/usuarios") {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->userController->getUsuarios($token);
                    exit();
                case 'POST':
                    if (empty($body))
                        $error = new Error(400, "Unrecognized error");
                    echo $this->userController->createUsuario($body, $token);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }
        } elseif ("/$base" === "/usuarios" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->userController->getUsuarioConId($id, $token);
                    exit();
                case 'PUT':
                    if (empty($body) || empty($id))
                        $error = new Error(400, "Unrecognized error");
                    echo $this->userController->updateUsuario($id, $body, $token);
                    exit();
                case 'DELETE':
                    echo $this->userController->deleteUsuario($id, $token);
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
