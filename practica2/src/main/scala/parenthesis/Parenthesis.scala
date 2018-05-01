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
// Parenthesis.scala
//
///////////////////////////////////////////////////////////////////////////////

package parenthesis

/**
  * Clase que se encarga de gestionar el balanceo de cadenas con paréntesis
  */
class Parenthesis {

	/**
	  * Comprueba si una cadena está balanceada
	  * @param list - Lista de caracteres que contiene la cadena
	  * @return true si está balanceada. False si no lo está
	  */
	def isBalanced(list: List[Char]): Boolean = {
		chequearBalance(list)
	}

	/**
	  * Comprueba recursivamente si los paréntesis están balanceados
	  * @param cadena - Lista de caracteres que contiene la cadena
	  * @return true si está balanceada. False si no lo está
	  */
	private def chequearBalance(cadena: List[Char]): Boolean = {

		/**
		  * Realiza el proceso recursivo para comprobar el balanceo
		  * @param list - Lista de caracteres que contiene la cadena
		  * @param accum - Valor utilizado para comprobar el orden de los
		  *                paréntesis
		  * @return true si está balanceada. False si no lo está
		  */
		@annotation.tailrec
		def go(list: List[Char], accum: Int = 0): Boolean = {

			// Se tienen dos puntos de salida.
			// El primer punto de salida se produce cuando la cadena está
			// vacía. Esto puede ocurrir por dos motivos: o bien la cadena
			// originalmente no tiene ningún elemento; o bien el proceso
			// recursivo ha llevado a que se haya comprobado toda la cadena y
			// no quede ningún carácter más por comprobar.
			// Cuando la cadena está vacía se debe comprobar que el valor
			// acumulado sea 0, ya que si es mayor que 0, hay más paréntesis
			// abiertos que cerrados.
			if(list.isEmpty) accum == 0
			// El segundo punto de salida se produce si el valor acumulado
			// es negativo, lo que indica que ha aparecido un paréntesis
			// cerrado antes de que aparezca el paréntesis abierto.
			else if(accum < 0) false
			// En el resto de casos se procesan los siguientes caracteres de la
			// cadena
			else{
				// Se comprueba el primer elemento del trozo de cadena actual
				list.head match{
					// Si es paréntesis abierto se debe sumar 1 al contador
					case '(' => go(list.tail, accum + 1)
					// Si es paréntesis cerrado se debe restar 1 al contador
					case ')' => go(list.tail, accum - 1)
					// En el resto de casos el contador se mantiene igual
					case _ => go(list.tail, accum)
				}
			}

		}

		// Se inicia y se devuelve el resultado de la función
		go(cadena)

	}

}
