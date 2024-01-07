<?php

namespace app\routes;

use app\config\Error;
use app\controllers\RolesController;
use app\interfaces\RouterInterface;

class RolesRoute implements RouterInterface
{
    private $rolesController;

    public function __construct()
    {
        $this->rolesController = new RolesController();
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

        if ($url === "/api/roles") {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->rolesController->getRoles($token);
                    exit();
                case 'POST':
                    echo $this->rolesController->createRol($body, $token);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }
        } elseif ("/$base" === "/roles" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch ($method) {
                case 'GET':
                    echo $this->rolesController->getRolConId($id, $token);
                    exit();
                case 'PUT':
                    echo $this->rolesController->updateRol($id, $body, $token);
                    exit();
                case 'DELETE':
                    echo $this->rolesController->deleteRol($id, $token);
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
