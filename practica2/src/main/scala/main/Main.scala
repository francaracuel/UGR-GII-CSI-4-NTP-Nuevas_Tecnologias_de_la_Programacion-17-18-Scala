///////////////////////////////////////////////////////////////////////////////
//
// Francisco Javier Caracuel Beltrán
//
// Nuevas Tecnologías de la Programación (NTP) - CSI - UGR - ETSIIT
//
// Curso 2017/2018
//
// Práctica 2. Programación funcional en Scala. Recursivdad
//
// Main.scala
//
///////////////////////////////////////////////////////////////////////////////

package main

import pascalsTriangle.PascalsTriangle

/**
  * Se encarga de ejecutar los distintos ejercicios.
  * 1. Triángulo de Pascal
  * 2.
  * 3.
  * 4.
  */
object Main extends App {

	///////////////////////////////////////////////////////////////////////////
	// 1. Triángulo de Pascal
	//

	val pascalsTriangle: PascalsTriangle = new PascalsTriangle

	// Se muestra el triángulo de Pascal de 10 filas
	pascalsTriangle.showTriangle(10)

	// Se muestra el valor que ocupa la fila 15 y columna 10
	println(pascalsTriangle.getValue(15, 10))

	//
	///////////////////////////////////////////////////////////////////////////

}
