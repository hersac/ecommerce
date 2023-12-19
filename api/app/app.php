<?php

use app\controllers\PruebaController;

$prueba = new PruebaController();

echo $prueba->getPruebas() . "<br>";
echo $prueba->getPruebasById(1);
