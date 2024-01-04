<?php

namespace app\models;

use app\models\Productos;

class DetallesOrdenes {
	private int $detalleId;
	private int $ordenId;
	private Productos $prodId;
	private int $cantidad;
	private int $subtotal;
}