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

class Domain(variables: List[Variable]) {

	private val this.variables: List[Variable] = variables
	private val weights: List[Int] = calculateWeights

	def this() {
		this(List[Variable]())
	}

	private def getVariables: List[Variable] = this.variables

	private[this] def calculateWeights: List[Int] = {
		if(isEmpty) return List()
		variables.reverse.map(_.state).dropRight(1).
			scanLeft(1){(element, accum) => element * accum}.reverse
	}

	private def calculateIndex(indices: List[Int]): Int = {
		if(isEmpty) return 0
		((indices zip weights)(breakOut): Map[Int, Int]).
			foldLeft(0){ case (accum, (key, value)) => accum + key * value}
	}

	private def calculateIndex(index: Int): Int = {
		calculateIndex(List.fill(this.variables.size)(index))
	}

	private[this] def exist(variable: Variable): Boolean = {
		variables.filter(_.name == variable.name).size > 0
	}

	def isEmpty: Boolean = this.variables.isEmpty

	def length: Int = variables.length

	def getWeights: List[Int] = weights

	def maxIndex: Int = {
		if(isEmpty) return 0
		calculateIndex(variables.map(_.state-1)) + 1
	}

	def apply(position: Int): Variable = variables(position)

	override def toString = {
		((variables zip weights)(breakOut): Map[Variable, Int]).mkString("; ")
	}

	def +(variable: Variable): Domain = {
		if(exist(variable)) return this
		new Domain(variables :+ variable)
	}

	def +(domain: Domain): Domain = new Domain(variables ::: domain.getVariables)

	def -(variable: Variable): Domain = {
		if(!exist(variable)) return this
		new Domain(variables.filterNot(_ == variable))
	}

}
