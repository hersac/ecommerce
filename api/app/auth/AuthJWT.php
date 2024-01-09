<?php

namespace app\auth;

class AuthJWT {
	private $secretKey;
	private $algorithm;

	public function __construct($secretKey, $algorithm = 'sha256'){
		$this->secretKey = $secretKey;
		$this->algorithm = $algorithm;
	}

	public function tokenGenerate($data, $expiration){
		$header = base64_encode(json_encode([
			'alg'=>$this->algorithm,
			'typ'=>'JWT'
		]));

		$payload = base64_encode(json_encode([
			'data'=>$data,
			'exp'=>$expiration
		]));

		$signature = hash_hmac($this->algorithm, "$header.$payload", $this->secretKey, true);
		$encodedSignature = base64_encode($signature);

		return "$header.$payload.$encodedSignature";
	}

    public function tokenValidate($token){

    	if(empty($token)){
    		return false;
    	}

		list($header, $payload, $signature) = explode(".", $token);
		$headerWithoutBearer = substr($header, 7);
		//$decodeHeader = json_decode(base64_decode($headerWithoutBearer), true);
		$decodePayload = json_decode(base64_decode($payload), true);
        $expectedSignature = base64_encode(hash_hmac($this->algorithm, "$headerWithoutBearer.$payload", $this->secretKey, true));

        return hash_equals($signature, $expectedSignature) && time() <= $decodePayload['exp'];
	}

	public function getDataFromToken($token){
		list($header, $payload, $signature) = explode(".", $token);
		$decodedPayload = json_decode(base64_decode($payload), true);

		return $decodedPayload['data'];
	}
}
