<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\Roles;
use app\config\Entity;
use app\config\Error;

class RolesController
{
    private $roles;
    private $entity;
    private $validationToken;

    public function __construct()
    {
        $this->roles = new Roles();
        $this->entity = new Entity(get_class($this->roles));
        $this->validationToken = new GenerateJWT();
    }

    public function getRoles($token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll());
    }

    public function getRolConId($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Rol no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createRol($entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateRol($id, $entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Rol no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteRol($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Rol no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
