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

import parenthesis.Parenthesis

/**
  * Se encarga de ejecutar los distintos ejercicios.
  * 1. Triángulo de Pascal
  * 2. Balanceo de paréntesis
  * 3.
  * 4.
  */
object Main extends App {

	///////////////////////////////////////////////////////////////////////////
	// 1. Triángulo de Pascal
	//

	/*println("Ejercicio 1. Triángulo de Pascal")
	println()

	val pascalsTriangle: PascalsTriangle = new PascalsTriangle

	// Se muestra el triángulo de Pascal de 10 filas
	pascalsTriangle.showTriangle(10)

	// Se muestra el valor que ocupa la fila 15 y columna 10
	println(pascalsTriangle.getValue(15, 10))

	println()*/

	//
	///////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////
	// 2. Balanceo de paréntesis
	//

	println("Ejercicio 2. Paréntesis balanceados")
	println()

	val parenthesis: Parenthesis = new Parenthesis

	// Sí
	val list1: List[Char] = List('(', '1', ')')
	val list2: List[Char] = List('(', '(', '(', '(', '2', ')', ')', ')', ')')

	// No
	val list3: List[Char] = List('(', '(', ')', ')', ')', '(', ')', ')', ')')
	val list4: List[Char] = List('(', '1', '(', '2', ')', ')', '(', '3', ')', '(')

	if(parenthesis.isBalanced(list1))
		println("La cadena " + list1.mkString + " está balanceada")
	else
		println("La cadena " + list1.mkString + " no está balanceada")

	if(parenthesis.isBalanced(list2))
		println("La cadena " + list2.mkString + " está balanceada")
	else
		println("La cadena " + list2.mkString + " no está balanceada")

	if(parenthesis.isBalanced(list3))
		println("La cadena " + list3.mkString + " está balanceada")
	else
		println("La cadena " + list3.mkString + " no está balanceada")

	if(parenthesis.isBalanced(list4))
		println("La cadena " + list4.mkString + " está balanceada")
	else
		println("La cadena " + list4.mkString + " no está balanceada")

	println()

	//
	///////////////////////////////////////////////////////////////////////////

}
