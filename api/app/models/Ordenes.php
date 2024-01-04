<?php

namespace app\models;

class Ordenes {
	private int $ordenId;
	private int $UserId;
	private string $fechaOrden;
	private string $DireccionEnvio;
	private bool $estadoOrden;
}