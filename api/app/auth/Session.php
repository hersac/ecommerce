<?php

namespace app\auth;

use app\auth\AuthJWT;
use app\controllers\UsuariosController;

class Session {
    private $authJWT;
    private $userController;

    public function loginValidate($body) {
        $requestData = [];

        foreach($body as $key => $value) {
            $requestData[] = $value;
        }

        $auth = $this->authJWT = new AuthJWT("ACCESS");
        $this->userController = new UsuariosController();

        $data = json_decode($this->userController->getUsuarioConCorreo($requestData[0]), true);

        if(empty($data)) {
            return false;
        }

        if($data[0]['password'] === $requestData[1]) {
            $expiration = time() + (24 * 3600);
            $token = $auth->tokenGenerate($data, $expiration);

            $response = [
            	'message'=>'Ok',
            	'status'=>200,
            	'token'=>$token,
            ];

            return json_encode($response);
        } else {
            return false;
        }
    }
}
