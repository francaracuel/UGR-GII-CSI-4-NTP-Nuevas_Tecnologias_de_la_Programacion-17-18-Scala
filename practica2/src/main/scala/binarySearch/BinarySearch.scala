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
// BinarySearch.scala
//
///////////////////////////////////////////////////////////////////////////////

package binarySearch

/**
  * Clase que se encarga de gestionar el proceso para realizar la búsqueda
  * binaria
  */
class BinarySearch {

	/**
	  * Realiza de manera recursiva la búsqueda de un elemento en una colección
	  * @param coleccion - Array de elementos que se quieren buscar
	  * @param aBuscar - elemento que se quiere buscar
	  * @param criterio - criterio utilizado para comparar dos elementos
	  * @tparam A - tipo de dato general
	  * @return -1 si no se encuentra, [0 - oo] posición donde se encuentra
	  */
	def busquedaBinaria[A](coleccion: Array[A], aBuscar: A,
						   criterio: (A, A) => Boolean): Int = {

		/**
		  * Realiza de manera recursiva la búsqueda de un elemento en una
		  * colección
		  * @param coleccion - Array de elementos que se quieren buscar
		  * @param accum - Valor que se utiliza para llevar la cuenta de la
		  *              posición del elemento a encontrar
		  * @return Posición que ocupa el elemento a buscar
		  */
		@annotation.tailrec
		def go(coleccion: Array[A], accum: Int = 0): Int = {

			// Si la colección está vacía se devuelve -1
			if(coleccion.length == 0) return -1

			// Se calcula la posición del elemento que se encuentra en el
			// centro
			val separator = coleccion.size / 2

			// Se obtiene el elemento que ocupa esa posición central
			val element = coleccion(separator)

			// Si el elemento se ha encontrado, se devuelve la posición que
			// ocupa en la colección más las posiciones que hubiera
			// anteriormente
			if(element == aBuscar) return separator + accum

			// Si se ha llegado a este punto y la colección tiene tamaño 1,
			// el valor no está y se devuelve -1
			if(coleccion.length == 1) return -1

			// Dependiendo del criterio utilizado, si se cumple se coge la
			// parte derecha y se aumenta 1 a la suma entre la nueva
			// subcolección y lo que haya a la izquierda hasta ahora
			if(criterio(element, aBuscar)){

				go(coleccion.slice(separator + 1, coleccion.length),
					separator + accum + 1)

			// Si no se cumple se coge la parte izquierda de la colección y no
			// aumenta el valor acumulado
			} else go(coleccion.slice(0, separator), accum)


		}

		go(coleccion)

	}

}
