<?php

namespace app\routes;

use app\config\Error;
use app\controllers\ClientesController;
use app\interfaces\RouterInterface;

class ClientesRoute implements RouterInterface {
    private $clientController;

    public function __construct() {
        $this->clientController = new ClientesController();
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

        if ($url === "/api/clientes") {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->clientController->getClientes();
                    exit();
                case 'POST':
                    echo $this->clientController->createCliente($body);
                    exit();
                default:
                    $error = new Error(405, "Method Not Allowed");
                    break;
            }

        } elseif ("/$base" === "/clientes" && is_numeric($id)) {
            header('Content-Type: application/json');
            switch($method){
                case 'GET':
                    echo $this->clientController->getClienteConId($id);
                    exit();
                case 'PUT':
                    echo $this->clientController->updateCliente($id, $body);
                    exit();
                case 'DELETE':
                    echo $this->clientController->deleteCliente($id);
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
