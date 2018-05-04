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
// Coins.scala
//
///////////////////////////////////////////////////////////////////////////////

package coins

/**
  * Clase que se encarga de gestionar el número de formas que se puede devolver
  * una cantidad
  */
class Coins {

	/**
	  * Devuelve el número posible de cambios que se pueden dar
	  * @param amount - Cantidad que se da
	  * @param coins - Tipos de monedas de que se dispone
	  * @return Entero con el número de formas posibles de devolver el cambio
	  */
	def getNumberChanges(amount: Int, coins: List[Int]): Int = {
		contarCambiosPosibles(amount, coins)
	}

	/**
	  * Devuelve el número posible de cambios que se pueden dar
	  * @param amount - Cantidad que se da
	  * @param coins - Tipos de monedas de que se dispone
	  * @return Entero con el número de formas posibles de devolver el cambio
	  */
	private def contarCambiosPosibles(amount: Int, coins: List[Int]): Int = {

		// Los puntos de salida son dos:
		// El primero es cuando no quede cantidad que devolver, que se
		// contabiliza como 1 forma de devolver
		if(amount == 0) 1
		// El segundo es cuando no queden monedas o la cantidad sea negativa.
		// En este caso se devuelve 0
		else if(amount < 0 || coins.isEmpty) 0
		// El siguiente punto a tener en cuenta es la manera en la que se
		// bifurca la cantidad de entrada y el tipo de monedas de las que se
		// dispone.
		// La primera a tener en cuenta es la devolución de una parte del
		// cambio. Esto se haría restanto a la cantidad actual la mayor moneda
		// de las que se dispone.
		// La otra forma es mantener la cantidad actual a devolver, pero
		// eliminando un tipo de moneda que se puede utilizar. En este caso
		// puede ocurrir que no existan monedas disponibles para dar el cambio,
		// pero está controlado en el punto de salida que devuelve 0
		else contarCambiosPosibles(amount - coins.head, coins) +
				contarCambiosPosibles(amount, coins.tail)

	}

}
