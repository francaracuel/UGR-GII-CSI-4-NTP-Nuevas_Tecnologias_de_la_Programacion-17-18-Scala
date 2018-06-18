///////////////////////////////////////////////////////////////////////////////
//
// Francisco Javier Caracuel Beltrán
//
// Nuevas Tecnologías de la Programación - NTP
//
// Curso 2017/2018
//
// Computación y Sistemas Inteligentes - CSI
//
// Práctica final - Árboles de probabilidad
//
///////////////////////////////////////////////////////////////////////////////

/**
  * Clase padre que controla los hijos ArrayValues y TreeValues
  * @param domain - Dominio que caracteriza a los valores
  */
abstract class Values(domain: Domain) {

	private val this.domain: Domain = domain

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = "[Values] -> Domain: %s".format(this.domain)

}

/**
  * Clase hija de Values que controla los valores como una lista
  * @param domain - Dominio que caracteriza a los valores
  * @param values - valores en forma de lista
  */
class ArrayValues(domain: Domain, values: List[Int]) extends Values(domain) {

	private val this.values = values

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = {
		"%s; [ArrayValues]: Se muestran los valores como una lista".format(super.toString)
	}

}

/**
  * Clase hija de Values que controla los valores como un árbol
  * @param domain - Dominio que caracteriza a los valores
  * @param values - valores en forma de árbol
  */
class TreeValues(domain: Domain, values: List[Node]) extends Values(domain) {

	private val this.values = values

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */

	override def toString: String = {
		"%s; [TreeValues]: %s".format(super.toString, values.toString)
	}

}
