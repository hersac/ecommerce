<?php

namespace app\config;

use app\config\DBConfig;

use PDO;
use PDOException;
use ReflectionClass;
use ReflectionProperty;

class Entity {

	private $db;
	private $className;
	private $columnNameId;

	public function __construct($class) {
		try {

			$this->className = basename(str_replace("\\", "/", $class));

			$reflection = new ReflectionClass($class);
			$properties = $reflection->getProperties(ReflectionProperty::IS_PRIVATE);
			$columnsData = [];

			foreach($properties as $props){
				$propName = $this->camelToSnakeCase($props->getName());

				if(strpos($propName, '_id') !== false){
					$this->columnNameId = $propName;
					$columnDefined = "$propName SERIAL PRIMARY KEY";
				} else {
					$columnDefined = "$propName VARCHAR(255)";
				}
				
				$columnsData[] = $columnDefined;
			}

			

			$columns = implode(", ", $columnsData);

			$this->db = new DBConfig();
			$query = $this->db->getConnection()->prepare("CREATE TABLE IF NOT EXISTS $this->className ($columns)");
			$query->execute();
		} catch(PDOException $e) {
			die('Error in Connection of Entity: ' . $e->getMessage());
		}
	}

	private function camelToSnakeCase($input){
		$snakeCase = preg_replace_callback('/[A-Z]/', function($match){
			return '_' . strtolower($match[0]);
		}, $input);

		return ltrim($snakeCase);
	}

	public function findAll(){
		$query = $this->db->getConnection()->prepare("SELECT * FROM $this->className");
		$query->execute();
		$data = $query->fetchAll(PDO::FETCH_ASSOC);
		return $data;
	}

	public function findById($id){
		$query = $this->db->getConnection()->prepare("SELECT * FROM $this->className WHERE $this->columnNameId = $id");
		$query->execute();
		$data = $query->fetchAll(PDO::FETCH_ASSOC);
		return $data;
	}

	public function save($request){

		//Tratamiento del Request

		$valuesData = [];
		$keysData = [];

		foreach($request as $key => $value){
			$valuesData[] = "'$value'";
			$keysData[] = $key;
		}

		$values = implode(', ', $valuesData);
		$keys = implode(', ', $keysData);

		//Creación del registro
		$query = $this->db->getConnection()->prepare("INSERT INTO $this->className ($keys) VALUES ($values);");
		$query->execute();

		//Respuesta de la creacion reciente
		$response = $this->db->getConnection()->prepare("SELECT * FROM $this->className WHERE $keysData[0] = $valuesData[0];");
		$response->execute();
		$data = $response->fetchAll(PDO::FETCH_ASSOC);
		return $data;
	}

	public function update($id, $request){

		//Tratamiento del Request

		$updateData = [];

		foreach($request as $key => $value){
			$updateData[] = "$key = '$value'";
		}

		$values = implode(', ', $updateData);

		//Busqueda y actualizacion del registro
		$query = $this->db->getConnection()->prepare("UPDATE $this->className SET $values WHERE $this->columnNameId = $id");
		$query->execute();

		//Respuesta de la creacion reciente
		$response = $this->db->getConnection()->prepare("SELECT * FROM $this->className WHERE $this->columnNameId = $id");
		$response->execute();
		$data = $response->fetchAll(PDO::FETCH_ASSOC);
		return $data;
	}

	public function delete($id){
		$query = $this->db->getConnection()->prepare("DELETE FROM $this->className WHERE $this->columnNameId = $id");
		$query->execute();
		$data = ['message'=>'Eliminado correctamente'];
		return $data;
	}

}