<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\Usuarios;
use app\config\Entity;
use app\config\Error;

class UsuariosController
{
    private $usuarios;
    private $entity;
    private $validationToken;

    public function __construct()
    {
        $this->usuarios = new Usuarios();
        $this->entity = new Entity(get_class($this->usuarios));
        $this->validationToken = new GenerateJWT();
    }

    public function getUsuarios($token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll());
    }

    public function getUsuarioConId($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createUsuario($entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateUsuario($id, $entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteUsuario($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function getUsuarioConCorreo($username)
    {
        $data = $this->entity->findByParameter('username', $username);

        if (empty($data)) {
            $error = new Error(400, "Usuario no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
