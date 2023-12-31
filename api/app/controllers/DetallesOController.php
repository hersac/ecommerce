<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\DetallesOrdenes;
use app\config\Entity;
use app\config\Error;

class DetallesOController
{
    private $detallesO;
    private $entity;
    private $validationToken;

    public function __construct()
    {
        $this->detallesO = new DetallesOrdenes();
        $this->entity = new Entity(get_class($this->detallesO));
        $this->validationToken = new GenerateJWT();
    }

    public function getDetallesO($token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll());
    }

    public function getDetalleOConId($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Detalle de orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createDetalleO($entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateDetalleO($id, $entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Detalle de orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteDetalleO($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Detalle de orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
