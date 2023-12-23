<?php

namespace app\controllers;

use app\models\Clientes;
use app\config\Entity;

class ClientesController {
    private $clientes;
    private $entity;

    public function __construct() {
        $this->clientes = new Clientes();
        $this->entity = new Entity(get_class($this->clientes));
    }

    public function getClientes(){
        return $this->entity->findAll();
    }
    
    public function getClienteConId($id){
        return $this->entity->findById($id);
    }

    public function createCliente($entity){
        return $this->entity->save($entity);
    }

    public function updateCliente($id, $entity){
        return $this->entity->update($id, $entity);
    }

    public function deleteCliente($id){
        return $this->entity->delete($id);
    }

}

?>
