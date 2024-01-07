<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\Ordenes;
use app\config\Entity;
use app\config\Error;

class OrdenesController
{
    private $ordenes;
    private $entity;
    private $validationToken;

    public function __construct()
    {
        $this->ordenes = new Ordenes();
        $this->entity = new Entity(get_class($this->ordenes));
        $this->validationToken = new GenerateJWT();
    }

    public function getOrdenes($token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll());
    }

    public function getOrdenConId($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createOrden($entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateOrden($id, $entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteOrden($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
