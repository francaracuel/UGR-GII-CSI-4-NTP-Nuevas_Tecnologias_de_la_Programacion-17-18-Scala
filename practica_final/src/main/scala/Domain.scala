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

import scala.collection.breakOut

/**
  * Clase Domain que contiene una lista con las variables y calcula los pesos
  * que le corresponde a cada una
  * @param variables - Lista de valores de tipo Variable
  */
class Domain(variables: List[Variable]) {

	private val this.variables: List[Variable] = variables
	private val weights: List[Int] = calculateWeights

	/**
	  * Segundo constructor que permite no recibir parámetros
	  */
	def this() {
		this(List[Variable]())
	}

	/**
	  * Devuelve una lista con las variables que componen el dominio
	  * @return lista con las variables del dominio
	  */
	def getVariables: List[Variable] = this.variables

	/**
	  * Calcula los pesos correspondientes a cada variable
	  * @return - Lista con los pesos que debe tener cada variable
	  */
	private[this] def calculateWeights: List[Int] = {
		if(isEmpty) return List()
		variables.reverse.map(_.state).dropRight(1).
			scanLeft(1){(element, accum) => element * accum}.reverse
	}

	/**
	  * Calcula el índice que le corresponde dependiendo del valor
	  * de cada variable
	  * @param indices - valor que le corresponde a cada variable
	  * @return Número con el índice calculado
	  */
	def calculateIndex(indices: List[Int]): Int = {
		if(isEmpty) return 0
		((indices zip weights)(breakOut): Map[Int, Int]).
			foldLeft(0){ case (accum, (key, value)) => accum + key * value}
	}

	/**
	  * Sobrecarga que permite asignar un mismo valor a todas las variables
	  * @param index - Número entero
	  * @return - Número con el índice calculado
	  */
	def calculateIndex(index: Int): Int = {
		calculateIndex(List.fill(this.variables.size)(index))
	}

	/**
	  * Comprueba si existe una variable en el dominio
	  * @param variable - Variable sobre la que se hace la consulta
	  * @return true si existe la variable, false si no existe
	  */
	def exist(variable: Variable): Boolean = {
		variables.filter(_.name == variable.name).size > 0
	}

	/**
	  * Comprueba si el dominio está vacío o no
	  * @return true si está vacío, false si no lo está
	  */
	def isEmpty: Boolean = this.variables.isEmpty

	/**
	  * Número de variables que componen el dominio
	  * @return número de variables del dominio
	  */
	def length: Int = variables.length

	/**
	  * Devuelve la lista de pesos calculados de cada variable
	  * @return lista de pesos
	  */
	def getWeights: List[Int] = weights

	/**
	  * Máximo índice que se puede obtener con estas variables
	  * @return Máximo índice
	  */
	def maxIndex: Int = {
		if(isEmpty) return 0
		calculateIndex(variables.map(_.state-1)) + 1
	}

	/**
	  * Devuelve la variable que ocupa una cierta posición en el dominio
	  * @param position sobre la que se quiere obtener la variable
	  * @return variable que se busca
	  */
	def apply(position: Int): Variable = variables(position)

	/**
	  * Sobrecarga del método + para añadir una variable al dominio
	  * @return Dominio con la nueva variable
	  */
	def +(variable: Variable): Domain = {
		if(exist(variable)) return this
		new Domain(variables :+ variable)
	}

	/**
	  * Sobrecarga del método + para concatena dos dominios
	  * @return Dominio con la unión de los dominios
	  */
	def +(domain: Domain): Domain = new Domain(variables ::: domain.getVariables)

	/**
	  * Sobrecarga del método - para eliminar una variable al dominio
	  * @return Dominio con la nueva variable
	  */
	def -(variable: Variable): Domain = {
		if(!exist(variable)) return this
		new Domain(variables.filterNot(_ == variable))
	}

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString = {
		((variables zip weights)(breakOut): Map[Variable, Int]).mkString("; ")
	}

}
