<?php

namespace app\controllers;

use app\models\Clientes;
use app\config\Entity;
use app\config\Error;

class ClientesController {
    private $clientes;
    private $entity;

    public function __construct() {
        $this->clientes = new Clientes();
        $this->entity = new Entity(get_class($this->clientes));
    }

    public function getClientes(){
        return json_encode($this->entity->findAll());
    }
    
    public function getClienteConId($id){
        $data = $this->entity->findById($id);
        if (empty($data)) {
            $error = new Error(400, "Cliente no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function createCliente($entity){
        return json_encode($this->entity->save($entity));
    }

    public function updateCliente($id, $entity){
        $data = $this->entity->update($id, $entity);
        if (empty($data)) {
            $error = new Error(400, "Cliente no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

    public function deleteCliente($id){
        $data = $this->entity->delete($id);
        if (empty($data)) {
            $error = new Error(400, "Cliente no se encuentra");
            return null;
        } else {
            return json_encode($data);
        }
    }

}

?>
