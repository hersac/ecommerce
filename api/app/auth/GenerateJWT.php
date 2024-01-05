<?php

namespace app\auth;

use app\auth\AuthJWT;

class GenerateJWT {

	private $secret;
	private $authJWT;

	public function __construct(){
		$this->secret = 'HERSAC';
		$this->authJWT = new AuthJWT($this->secret);
	}

	public function validateToken($token) {
		$jwt = $this->authJWT;
		return $jwt->tokenValidate($token);
	}
}