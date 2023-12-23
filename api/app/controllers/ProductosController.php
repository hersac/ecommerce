<?php

namespace app\controllers;

use app\models\Productos;
use app\config\Entity;

class ProductosController {
    private $productos;
    private $entity;

    public function __construct() {
        $this->productos = new Productos();
        $this->entity = new Entity(get_class($this->productos));
    }

    public function getProductos(){
        return $this->entity->findAll();
    }
    
    public function getProductoConId($id){
        return $this->entity->findById($id);
    }

    public function createProducto($entity){
        return $this->entity->save($entity);
    }

    public function updateProducto($id, $entity){
        return $this->entity->update($id, $entity);
    }

    public function deleteProducto($id){
        return $this->entity->delete($id);
    }

}

?>
