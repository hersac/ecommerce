<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\DetallesCC;
use app\config\Entity;
use app\config\Error;

class DetallesCCController
{
    private $detallesCC;
    private $entity;
    private $validationToken;

    public function __construct()
    {
        $this->detallesCC = new DetallesCC();
        $this->entity = new Entity(get_class($this->detallesCC));
        $this->validationToken = new GenerateJWT();
    }

    public function getDetallesCC($token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll());
    }

    public function getDetalleCCConId($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Detalles del carrito no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createDetalleCC($entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateDetalleCC($id, $entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Detalles del carrito no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteDetalleCC($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Detalles del carrito no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
