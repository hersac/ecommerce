<?php

namespace app\controllers;

use app\models\DetallesOrdenes;
use app\config\Entity;
use app\config\Error;

class DetallesOController {
    private $detallesO;
    private $entity;

    public function __construct() {
        $this->detallesO = new DetallesOrdenes();
        $this->entity = new Entity(get_class($this->detallesO));
    }

    public function getDetallesO(){
        return json_encode($this->entity->findAll());
    }
    
    public function getDetalleOConId($id){
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Detalle de orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createDetalleO($entity){
        return json_encode($this->entity->save($entity));
    }

    public function updateDetalleO($id, $entity){
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Detalle de orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteDetalleO($id){
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Detalle de orden no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

?>
