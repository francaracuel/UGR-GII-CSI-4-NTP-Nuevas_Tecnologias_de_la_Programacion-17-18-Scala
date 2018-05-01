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
// PascalsTriangle.scala
//
///////////////////////////////////////////////////////////////////////////////

package pascalsTriangle

/**
  * Clase que se encarga de gestionar el proceso para calcular y mostrar el
  * triángulo de Pascal
  */
class PascalsTriangle {

	/**
	  * Calcula el valor que ocupa un elemento en una posición dada
	  * @param row - Fila donde se encuentra el valor
	  * @param col - Columna donde se encuentra el valor
	  * @return entero que contiene el valor buscado en el triángulo de Pascal
	  */
	def getValue(row: Int, col: Int): Int = {
		calcularValorTrianguloPascal(row, col)
	}

	/**
	  * Muestra por pantalla el triángulo de Pascal de un tamaño concreto
	  * @param rows - Número de filas que se quiere que tenga el triángulo
	  */
	def showTriangle(rows: Int): Unit = {

		// Se recorren las filas del triángulo
		for(row <- 0 to rows){

			// Se reocrren las columnas
			for(col <- 0 to row){
				// Se muestra el valor
				print(calcularValorTrianguloPascal(row, col) + " ")
			}

			// Se añade un salto de línea para separar las filas
			println()

		}

	}

	/**
	  * Calcula el valor que ocupa un elemento en una posición dada
	  * @param fila - Fila donde se encuentra el valor
	  * @param columna - Columna donde se encuentra el valor
	  * @return entero que contiene el valor buscado en el triángulo de Pascal
	  */
	private def calcularValorTrianguloPascal(fila: Int, columna: Int): Int = {

		// El inicio del triángulo es 1, por lo que si la columna es 0, se
		// devuelve 1.
		// Se sabe si se está al final de la fila si el número de fila y
		// columna es igual, en este caso también se devuelve 1
		if(columna == 0 || fila == columna) 1
		else
			calcularValorTrianguloPascal(fila - 1, columna) +
				calcularValorTrianguloPascal(fila - 1, columna - 1)

	}

}
