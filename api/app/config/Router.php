<?php

namespace app\config;

class Router {
	private $routes = [];

	public function addRoute($route) {
		$this->routes[] = $route;
	}

	public function handleRoutes(){
		foreach($this->routes as $route){
			$route->handlerRoutes();
		}
	}
}