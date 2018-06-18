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
  * Clase genérica para la construcción de árboles
  * @param level - define el nivel en el que se encuentre
  */
abstract class Node(level: Int) {

	private var this.level: Int = level

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = "[Node]"

}

/**
  * Clase hija de Node que contiene una lista con nodos por cada rama
  * @param nodes - Lista de nodos por cada rama
  * @param level - define el nivel en el que se encuentre
  */
class VarNode(nodes: List[Node], level: Int) extends Node(level) {

	private val this.nodes: List[Node] = nodes

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = "%s:[VarNode] -> Se muestran las distintas ramas %s".
		format(super.toString, this.nodes.toString)

}

/**
  * Clase hija de Node que contiene el nodo hoja con un valor
  * @param value - nodo hoja que tiene contiene el valor correspondiente
  * @param level - define el nivel en el que se encuentre
  */
class LeafNode(value: Int, level: Int) extends Node(level) {

	private val this.value: Int = value

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString: String = "%s:[LeafNode] -> Se muestra el valor del nodo".
		format(super.toString)

}