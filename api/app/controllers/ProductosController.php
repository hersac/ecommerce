<?php

namespace app\controllers;

use app\models\Productos;
use app\config\Entity;
use app\config\Error;

class ProductosController {
    private $productos;
    private $entity;

    public function __construct() {
        $this->productos = new Productos();
        $this->entity = new Entity(get_class($this->productos));
    }

    public function getProductos(){
        return json_encode($this->entity->findAll());
    }
    
    public function getProductoConId($id){
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Producto no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createProducto($entity){
        return json_encode($this->entity->save($entity));
    }

    public function updateProducto($id, $entity){
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Producto no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteProducto($id){
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Producto no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

?>
