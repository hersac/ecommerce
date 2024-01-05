<?php

namespace app\controllers;

use app\models\Roles;
use app\config\Entity;
use app\config\Error;

class RolesController
{
    private $roles;
    private $entity;

    public function __construct()
    {
        $this->roles = new Roles();
        $this->entity = new Entity(get_class($this->roles));
    }

    public function getRoles()
    {
        return json_encode($this->entity->findAll());
    }

    public function getRolConId($id)
    {
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Rol no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createRol($entity)
    {
        return json_encode($this->entity->save($entity));
    }

    public function updateRol($id, $entity)
    {
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Rol no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteRol($id)
    {
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Rol no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
