<?php

use app\config\Cors;
use app\config\Error;
use app\config\Router;
use app\routes\ProductosRoute;
use app\routes\ClientesRoute;
use app\routes\UsuariosRoute;
use app\routes\CarritoComprasRoute;
use app\routes\DetallesCCRoute;
use app\routes\OrdenesRoute;
use app\routes\DetallesORoute;
use app\routes\RolesRoute;
use app\routes\SessionRoute;

$url = $_SERVER['REQUEST_URI'];
$router = new Router();
$pattern = "#/(\w+)/(\w+)#";
preg_match($pattern, $url, $matches);
$urlToValidate = isset($matches[2]) ? $matches[2] : null;

$cors = new Cors();
$cors->success();

switch ($urlToValidate) {
	case 'productos':
		$router->addRoute(new ProductosRoute());
		break;
	case 'clientes':
		$router->addRoute(new ClientesRoute());
		break;
	case 'usuarios':
		$router->addRoute(new UsuariosRoute());
		break;
	case 'carritocompras':
		$router->addRoute(new CarritoComprasRoute());
		break;
	case 'detallescc':
		$router->addRoute(new DetallesCCRoute());
		break;
	case 'ordenes':
		$router->addRoute(new OrdenesRoute());
		break;
	case 'detallesordenes':
		$router->addRoute(new DetallesORoute());
		break;
	case 'roles':
		$router->addRoute(new RolesRoute());
		break;
	case 'session':
		$router->addRoute(new SessionRoute());
		break;
	default:
		$error = new Error(404, "Not Found");
		break;
}

$router->handleRoutes();

