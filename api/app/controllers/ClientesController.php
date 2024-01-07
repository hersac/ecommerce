<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\Clientes;
use app\config\Entity;
use app\config\Error;

class ClientesController {
    private $clientes;
    private $entity;
    private $validationToken;

    public function __construct() {
        $this->clientes = new Clientes();
        $this->entity = new Entity(get_class($this->clientes));
        $this->validationToken = new GenerateJWT();
    }

    public function getClientes($token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll());
    }
    
    public function getClienteConId($id, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Cliente no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createCliente($entity, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateCliente($id, $entity, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Cliente no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteCliente($id, $token){
        if(!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Cliente no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

?>
