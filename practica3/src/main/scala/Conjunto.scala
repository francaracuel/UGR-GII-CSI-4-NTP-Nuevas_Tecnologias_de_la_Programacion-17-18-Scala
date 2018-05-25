///////////////////////////////////////////////////////////////////////////////
//
// Francisco Javier Caracuel Beltrán
//
// Nuevas Tecnologías de la Programación - NTP
//
// Grado en Ingeniería Informática - CSI
//
// Curso 2017/2018
//
// Práctica 3. Programación funcional en Scala. Clases y objetos
//
// Conjunto.scala
//
///////////////////////////////////////////////////////////////////////////////

/**
  * Clase para representar conjuntos definidos mediante una funcion
  * caracteristica (un predicado). De esta forma, se declara el tipo
  * conjunto como un predicado que recibe un entero (elemento) como
  * argumento y dvuelve un valor booleano que indica si pertenece o no
  * al conjunto
  *
  * @param funcionCaracteristica
  */
class Conjunto(val funcionCaracteristica: Int => Boolean) {
	/**
	  * Crea una cadena con el contenido completo del conjunto
	  *
	  * @return
	  */
	override def toString(): String = {
		// El uso de this(i) implica la el uso del metodo apply
		val elementos = for (i <- -Conjunto.LIMITE to Conjunto.LIMITE
							 if this(i)) yield i
		elementos.mkString("{", ",", "}")
	}

	/**
	  * Metodo para determinar la pertenencia de un elemento al
	  * conjunto
	  * @param elemento
	  * @return valor booleano indicando si elemento cumple
	  *         la funcion caracteristica o no
	  */
	def apply(elemento: Int): Boolean = funcionCaracteristica(elemento)
}



/**
  * Objeto companion que ofrece metodos para trabajar con
  * conjuntos
  */
object Conjunto {
	/**
	  * Limite para la iteracion necesaria algunas operaciones,
	  * entre -1000 y 1000
	  */
	private final val LIMITE = 1000

	/**
	  * Metodo que permite crear objetos de la clase Conjunto
	  * de forma sencilla
	  * @param f
	  * @return
	  */
	def apply(f: Int => Boolean): Conjunto = {
		new Conjunto(f)
	}

	///////////////////////////////////
	// Funciones básicas
	//

	/**
	  * Crea un conjunto de un elemento
	  * @param elemento que formará parte del conjunto
	  * @return Conjunto con el elemento que se recibe
	  */
	def conjuntoUnElemento(elemento : Int) : Conjunto = new Conjunto((x: Int) => x == elemento)

	/**
	  * Crea la unión de dos conjuntos
	  * @param c1. Primer conjunto
	  * @param c2. Segundo conjunto
	  * @return conjunto con la unión
	  */
	def union(c1 : Conjunto, c2 : Conjunto) : Conjunto = {
		new Conjunto((x: Int) => c1.apply(x) || c2.apply(x))
	}

	/**
	  * Crea la intersección de dos conjuntos
	  * @param c1. Primer conjunto
	  * @param c2. Segundo conjunto
	  * @return conjunto con la intersección
	  */
	def interseccion(c1 : Conjunto, c2 : Conjunto) : Conjunto = {
		new Conjunto((x: Int) => c1.apply(x) && c2.apply(x))
	}

	/**
	  * Crea el conjunto diferencia de dos conjuntos
	  * @param c1. Primer conjunto
	  * @param c2. Segundo conjunto
	  * @return el conjunto diferencia de dos conjuntos
	  */
	def diferencia(c1 : Conjunto, c2 : Conjunto) : Conjunto = {
		new Conjunto((x: Int) => c1.apply(x) && !c2.apply(x))
	}

	/**
	  * Filtra los valores del conjunto de una expresión que se recibe
	  * @param c. Conjunto que contiene todos los valores
	  * @param predicado. Expresión que comprueba si un valor debe mantenerse
	  * @return el conjunto con los datos que cumplen el predicado
	  */
	def filtrar(c : Conjunto, predicado : Int => Boolean) : Conjunto = {
		new Conjunto((x: Int) => c.apply(x) && predicado(x))
	}

	//
	///////////////////////////////////

	///////////////////////////////////
	// Funciones avanzadas
	//

	/**
	  * Comprueba que todos los elementos del conjunto cumplan una condicion
	  * @param conjunto. Conjunto con todos los elementos
	  * @param predicado. Condición que deben cumplir los elementos
	  * @return true si todos los elementos cumplen la condición, false si no
	  */
	def paraTodo(conjunto : Conjunto, predicado : Int => Boolean) : Boolean = {

		def iterar(elemento : Int) : Boolean = {
			// Se llegará al punto de parada, devolviendo true, si el valor del
			// elemento que se está recorriendo ha superado el límite. Esto
			// significa que todos los elementos desde -LIMITE han cumplido
			// la condición
			if(elemento == LIMITE + 1) true

			// Si un elemento no pertenece al conjunto, no se tiene en cuenta y
			// para que pueda continuar se utiliza el siguiente elemento
			else if (!conjunto.apply(elemento)) iterar(elemento + 1)

			// Solo si se cumple la condición definida en "predicado", se
			// hará la llamada recursiva con el siguiente elemento.
			// Si se cumple devolverá lo que devuelva la condición con
			// el siguiente elemento. Si no se cumple devuelve false y
			// termina el algoritmo
			else predicado(elemento) && iterar(elemento + 1)
		}

		// El algoritmo comienza desde -LIMITE hasta como máximo LIMITE
		iterar(-LIMITE)

	}

	/**
	  * Comprueba si algún elemento del conjunto cumple la condición
	  * @param c. Conjunto sobre el que se itera
	  * @param predicado. Condición que debe cumplir
	  * @return true si algún elemento cumple la condición. false si no la
	  *         cumple ninguno
	  */
	def existe(c : Conjunto, predicado : Int => Boolean) : Boolean = {

		// Se utiliza el método "paraTodo" creado anteriormente para comprobar
		// si existe algún elemento que cumpla la condición
		!paraTodo(c, !predicado(_))

	}

	/**
	  * Crea un nuevo conjunto aplicando la función que se recibe a cada elemento
	  * @param c. Conjunto sobre el que se aplica la función
	  * @param funcion. Función que se aplica a cada elemento
	  * @return
	  */
	def map(c : Conjunto, funcion : Int => Int) : Conjunto = {
		new Conjunto((x: Int) => existe(c, elemento => x == funcion(elemento)))
	}

	//
	///////////////////////////////////

}