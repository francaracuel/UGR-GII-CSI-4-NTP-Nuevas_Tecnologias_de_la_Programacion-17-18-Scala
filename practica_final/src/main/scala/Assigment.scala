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
  * Representa la asignación de un dominio con los valores que tiene cada una
  * de sus variables
  * @param domain - Dominio que contiene las variables y los pesos
  * @param vals - Valores que tiene cada variable del dominio
  */
class Assigment(domain: Domain, vals: List[Int]) {

	val this.domain: Domain = domain
	private var values = checkValues(vals)

	/**
	  * Crea una asignación a partir de un dominio, asignando el valor 0 a todas
	  * las variables
	  * @param domain Dominio que se quiere asignar
	  */
	def this(domain: Domain) {
		this(domain, List.fill(domain.getVariables.size)(0))
	}

	/**
	  * Crea una asignación a partir de un dominio y de un valor de índice
	  * @param domain dominio que se quiere utilizar
	  * @param index índice utilizado para crear los valores
	  */
	def this(domain: Domain, index: Int) {
		this(domain)
		this.values = calculateValues(index)
	}

	/**
	  * Comprueba si los valores que se reciben están en el rago [0, S-1].
	  * @param values Lista de enteros con los valores
	  * @return Lista con los valores si son correctos o vacía si no lo son
	  */
	private[this] def checkValues(values: List[Int]): List[Int] = {
		if(values.zipWithIndex.forall{ case(value, index) => domain.apply(index).state > value})
			return values
		List()
	}

	/**
	  * Comprueba si la asignación está definida sobre un dominio vacío o no
	  * @return true si está vacío, false si no lo está
	  */
	def isEmpty: Boolean = this.domain.isEmpty

	/**
	  * Número de variables que componen el dominio
	  * @return Entero con el número de variables
	  */
	def getNumVar: Int = this.domain.length

	/**
	  * Devuelve el valor de una variable que ocupa cierta posición
	  * @param pos - Posición de la que se quiere saber su valor
	  * @return valor que ocupa cierta posición
	  */
	def getValueVar(pos: Int): Int = this.values(pos)

	/**
	  * Calcula los valores correspondientes en la asignación teniendo
	  * en cuenta el dominio y el índice
	  * @param index Índice que se quiere utilizar
	  * @return lista con los valores
	  */
	def calculateValues(index: Int): List[Int] = {
		(this.domain.getWeights zip this.domain.getVariables).map(tuple =>
			(index/tuple._1.toInt)%(tuple._2.state))
	}

	/**
	  * Sobrecarga del método + para añadir un par variable/valor a la
	  * asignación
	  * @param variable
	  * @param value
	  * @return nueva asignación con el nuevo par recibido
	  */
	def +(variable: Variable, value: Int): Assigment = {
		new Assigment(this.domain + variable, this.values :+ value)
	}

	/**
	  * Calcula el índice del dominio con el conjunto de valores
	  * @return índice calculado
	  */
	def calculateIndex(): Int = this.domain.calculateIndex(this.values)

	/**
	  * Crea una asignación donde se encuentran únicamente las variables del
	  * dominio que se recibe
	  * @param domain Dominio que contiene las variables que se reciben
	  * @return nueva asignación
	  */
	def throwAssigment(domain: Domain): Assigment = {
		val indexes = this.domain.getVariables.zipWithIndex.collect{ case (variable, index) =>
			if(domain.exist(variable)) index
		}.filter(_ != ()).map(_.toString.toInt)
		new Assigment(new Domain(indexes.map(this.domain.getVariables)), indexes.map(this.values))
	}

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString() = {
		"Domain: %s, Values: %s".format(this.domain, this.values.mkString(", "))
	}

}
