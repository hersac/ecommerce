<?php

namespace app\controllers;

use app\models\Usuarios;
use app\config\Entity;
use app\config\Error;

class UsuariosController
{
    private $usuarios;
    private $entity;

    public function __construct()
    {
        $this->usuarios = new Usuarios();
        $this->entity = new Entity(get_class($this->usuarios));
    }

    public function getUsuarios()
    {
        return json_encode($this->entity->findAll());
    }

    public function getUsuarioConId($id)
    {
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createUsuario($entity)
    {
        return json_encode($this->entity->save($entity));
    }

    public function updateUsuario($id, $entity)
    {
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteUsuario($id)
    {
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function getUsuarioConCorreo($username){
        $data = $this->entity->findByParameter('username', $username);

        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
