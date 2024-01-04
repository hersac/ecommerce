<?php

namespace app\config;

class Error {

	public function __construct ($status, $message) {
        //header("HTTP/1.1 $status $message");

        $response = [
            'message'=>"$status $message",
            'status'=>$status
        ];

        $json =json_encode($response);
        echo $json;
        exit();
    }
}