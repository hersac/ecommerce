<?php

namespace app\controllers;

use app\models\CarritoCompras;
use app\config\Entity;
use app\config\Error;

class CarritoComprasController {
    private $carritoCompras;
    private $entity;

    public function __construct() {
        $this->carritoCompras = new CarritoCompras();
        $this->entity = new Entity(get_class($this->carritoCompras));
    }

    public function getCarritosCompras(){
        return json_encode($this->entity->findAll());
    }
    
    public function getCarritoComprasConId($id){
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Carro de compras no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createCarritoCompras($entity){
        return json_encode($this->entity->save($entity));
    }

    public function updateCarritoCompras($id, $entity){
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Carro de compras no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteCarritoCompras($id){
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Carro de compras no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

?>
