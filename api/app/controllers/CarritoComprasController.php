<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\CarritoCompras;
use app\config\Entity;
use app\config\Error;

class CarritoComprasController {
    private $carritoCompras;
    private $entity;
    private $validationToken;

    public function __construct() {
        $this->carritoCompras = new CarritoCompras();
        $this->entity = new Entity(get_class($this->carritoCompras));
        $this->validationToken = new GenerateJWT();
    }

    public function getCarritosCompras($token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll()); 
    }
    
    public function getCarritoComprasConId($id, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Carro de compras no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createCarritoCompras($entity, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateCarritoCompras($id, $entity, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Carro de compras no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteCarritoCompras($id, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Carro de compras no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

