<?php

namespace app\auth;

use app\auth\AuthJWT;
use app\controllers\UsuariosController;

class Session {
	private $authJWT;
	private $userController;

	public function loginValidate($body){

		$user = '';
		$password = '';

		foreach($body as $key => $value){
			if($key === 'username'){
				$user = $value;
			} if($key === 'password'){
				$password = $value;
			} else {
				return null;
			}
		}

		$auth = $this->authJWT = new AuthJWT("ACCESS");
		$this->userController = new UsuariosController();
		$data = $this->userController->getUsuarioConCorreo($user);

		if(empty($data)){
			return false;
		} elseif($data['password'] === $password) {
			$expiration = $expiration = time() + (24 * 3600);
			$token = $auth->tokenGenerate($data, $expiration);
			return $token;
		}
	}
}