<?php

namespace app\controllers;

use app\auth\GenerateJWT;
use app\models\Productos;
use app\config\Entity;
use app\config\Error;

class ProductosController
{
    private $productos;
    private $entity;
    private $validationToken;

    public function __construct()
    {
        $this->productos = new Productos();
        $this->entity = new Entity(get_class($this->productos));
        $this->validationToken = new GenerateJWT();
    }

    public function getProductos($token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->findAll());
    }

    public function getProductoConId($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Producto no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createProducto($entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        return json_encode($this->entity->save($entity));
    }

    public function updateProducto($id, $entity, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Producto no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteProducto($id, $token)
    {
        if (!$this->validationToken->validateToken($token))
            throw new Error(401, "Unauthorized request");
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Producto no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }
}
