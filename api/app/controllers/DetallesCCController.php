<?php

namespace app\controllers;

use app\models\DetallesCC;
use app\config\Entity;
use app\config\Error;

class DetallesCCController {
    private $detallesCC;
    private $entity;

    public function __construct() {
        $this->detallesCC = new DetallesCC();
        $this->entity = new Entity(get_class($this->detallesCC));
    }

    public function getDetallesCC(){
        return json_encode($this->entity->findAll());
    }
    
    public function getDetalleCCConId($id){
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Detalles del carrito no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createDetalleCC($entity){
        return json_encode($this->entity->save($entity));
    }

    public function updateDetalleCC($id, $entity){
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Detalles del carrito no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteDetalleCC($id){
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Detalles del carrito no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

?>
