<?php

namespace app\routes;

use app\auth\Session;
use app\config\Error;

use app\interfaces\RouterInterface;

class SessionRoute implements RouterInterface {
    private $session;

    public function __construct() {
        $this->session = new Session();
    }

    public function handlerRoutes(){

        $url = $_SERVER['REQUEST_URI'];
        $method = $_SERVER["REQUEST_METHOD"];

        $pattern = "#/(\w+)/(\w+)#";
        preg_match($pattern, $url, $matches);

        $id = isset($matches[3]) ? $matches[3] : null;
        $base = isset($matches[3]) ? $matches[2] : null;

        $postData = file_get_contents("php://input");
        $body = json_decode($postData, true);

        if ($url === "/api/session") {
            header('Content-Type: application/json');
            switch($method){
                case 'POST':
                    echo $this->session->loginValidate($body);
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
