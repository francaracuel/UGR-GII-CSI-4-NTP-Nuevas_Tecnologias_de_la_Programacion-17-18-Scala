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

import binarySearch.BinarySearch
import coins.Coins
import lista.Lista
import parenthesis.Parenthesis
import pascalsTriangle.PascalsTriangle

/**
  * Se encarga de ejecutar los distintos ejercicios.
  * 1. Triángulo de Pascal
  * 2. Balanceo de paréntesis
  * 3. Contador de posibles cambios de monedas
  * 4.
  */
object Main extends App {

	///////////////////////////////////////////////////////////////////////////
	// 1. Triángulo de Pascal
	//

	println("Ejercicio 1. Triángulo de Pascal")
	println()

	val pascalsTriangle: PascalsTriangle = new PascalsTriangle

	// Se muestra el triángulo de Pascal de 10 filas
	pascalsTriangle.showTriangle(10)

	// Se muestra el valor que ocupa la fila 15 y columna 10
	println(pascalsTriangle.getValue(15, 10))

	println()

	//
	///////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////
	// 2. Balanceo de paréntesis
	//

	println("Ejercicio 2. Paréntesis balanceados")
	println()

	val parenthesis: Parenthesis = new Parenthesis

	// Sí
	val list21: List[Char] = List('(', '1', ')')
	val list22: List[Char] = List('(', '(', '(', '(', '2', ')', ')', ')', ')')

	// No
	val list23: List[Char] = List('(', '(', ')', ')', ')', '(', ')', ')', ')')
	val list24: List[Char] = List('(', '1', '(', '2', ')', ')', '(', '3', ')', '(')

	if(parenthesis.isBalanced(list21))
		println("La cadena " + list21.mkString + " está balanceada")
	else
		println("La cadena " + list21.mkString + " no está balanceada")

	if(parenthesis.isBalanced(list22))
		println("La cadena " + list22.mkString + " está balanceada")
	else
		println("La cadena " + list22.mkString + " no está balanceada")

	if(parenthesis.isBalanced(list23))
		println("La cadena " + list23.mkString + " está balanceada")
	else
		println("La cadena " + list23.mkString + " no está balanceada")

	if(parenthesis.isBalanced(list24))
		println("La cadena " + list24.mkString + " está balanceada")
	else
		println("La cadena " + list24.mkString + " no está balanceada")

	println()

	//
	///////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////
	// 3. Contador de posibles cambios de monedas
	//

	println("Ejercicio 3. Contador de posibles cambios de monedas")
	println()

	val coins: Coins = new Coins

	val amount = 0
	val typeCoins: List[Int] = List(1, 2, 5, 10, 20, 50)

	// Se muestra el número de cambios posibles que se puede dar para una
	// cantidad
	println(coins.getNumberChanges(amount, typeCoins))

	println()

	//
	///////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////
	// 4. Búsqueda binaria genérica
	//

	println("Ejercicio 4. Búsqueda binaria genérica")
	println()

	val binarySearch: BinarySearch = new BinarySearch

	val list41: Array[Char] = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')
	val search1: Char = 'e'

	// Se realiza la búsqueda binaria
	val result = binarySearch.busquedaBinaria[Char](list41, search1, _ < _)

	println(result)
	println()

	//
	///////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////
	// Funciones sobre clase Lista propia
	//

	println("Funciones sobre la clase propia Lista")
	println()

	val list1 = Lista(1, 2, 3, 4)
	val list2 = Lista(1, 2, 3)
	val list3 = Lista(1, 2)

	println(Lista.sumaEnteros(list1))

	println(Lista.productoEnteros(list1))

	println(Lista.sumaEnteros(Lista.concatenar(list3, list2)))

	println(Lista.sumaFoldRight(Lista.concatenar(list3, list2)))

	println(Lista.asignarCabeza(list1, 10))

	println(Lista.eliminar(list1, 3))

	println(Lista.eliminarMientras(list1, (a:Int) => a < 3))

	println(Lista.eliminarUltimo(list1))

	//
	///////////////////////////////////////////////////////////////////////////

}
