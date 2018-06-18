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
  * Clase principal de la aplicación, padre de las dos que utilizan cada tipo de dato
  * @param domain - Dominio que se utiliza para hacer los cálculos
  * @param values - Almacén de datos
  */
abstract class Potential(domain: Domain, values: Values) {

	private val this.domain: Domain = domain
	private val this.values: Values = values

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = "[Potential] %s; %s".format(domain, values)

}

/**
  * Clase hija que tiene el almacén de datos como un array de valores
  * @param domain - Dominio que se utiliza para hacer los cálculos
  * @param values - Almacén de datos
  */
class ArrayPotential(domain: Domain, values: ArrayValues) extends Potential(domain, values) {

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = "[ArrayPotential] -> %s".format(super.toString)

}

class TreePotential(domain: Domain, values: TreeValues) extends Potential(domain, values) {

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = "[TreePotential] -> %s".format(super.toString)

}