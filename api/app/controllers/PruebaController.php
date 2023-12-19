<?php

namespace app\controllers;

use app\models\Prueba;
use app\config\Entity;

class PruebaController {
	private $entity;

	public function __construct() {
		$this->entity = new Entity(get_class(new Prueba()));
	}

	public function getPruebas(){
		return $this->entity->findAll();
	}

	public function getPruebasById($id){
		return $this->entity->findById($id);
	}

	public function createPrueba($request){
		return $this->entity->save($request);
	}

}