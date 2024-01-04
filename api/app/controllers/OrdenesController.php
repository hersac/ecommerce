<?php

namespace app\controllers;

use app\models\Ordenes;
use app\config\Entity;
use app\config\Error;

class OrdenesController {
    private $ordenes;
    private $entity;

    public function __construct() {
        $this->ordenes = new Ordenes();
        $this->entity = new Entity(get_class($this->ordenes));
    }

    public function getOrdenes(){
        return json_encode($this->entity->findAll());
    }
    
    public function getOrdenConId($id){
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createOrden($entity){
        return json_encode($this->entity->save($entity));
    }

    public function updateOrden($id, $entity){
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteOrden($id){
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

?>
