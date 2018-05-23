class Racional(n: Int, d: Int) {

	private val mcd = maximoComunDivisor(n, d)

	val numerador: Int = n/mcd
	val denominador: Int = d/mcd

	// Evitar que d sea 0
	require(d != 0)

	/**
	  * Constructor auxiliar para valores enteros
	  * @param n
	  * @return
	  */
	def this(n: Int) = this(n, 1)

	override def toString = numerador + "/" + denominador

	/**
	  * Comprobación de valor respecto a otro objeto
	  * @param otro
	  * @return
	  */
	def menorQue(otro: Racional): Boolean = {

		numerador*otro.denominador < otro.numerador*denominador

	}

	/**
	  * Obtiene el máximo de dos objetos
	  * @param otro
	  * @return
	  */
	def max(otro: Racional) = if(menorQue(otro)) otro else this

	/**
	  * Calcula el máximo común divisor
	  * @param a
	  * @param b
	  * @return
	  */
	private def maximoComunDivisor(a: Int, b: Int): Int = if(b == 0) a else maximoComunDivisor(b, a/b)

	/**
	  * Método para sumar racionales
	  * @param otro
	  * @return
	  */
	def sumar(otro: Racional): Racional = {

		new Racional(numerador*otro.denominador + otro.numerador*denominador,
			denominador*otro.denominador)

	}

	/**
	  * Sobrecarga del operador +
	  * @param otro
	  * @return
	  */
	/*def + (otro: Racional) = new Racional(numerador*otro.denominador + otro.numerador*denominador,
		denominador*otro.denominador)*/
	def + (otro: Racional) = sumar(otro)

	/**
	  * Sobrecarga del operador + con un entero
	  * @param valor
	  * @return
	  */
	def + (valor: Int): Racional = new Racional(numerador+valor*denominador, denominador)

}

object Racional extends App{

	val obj1 = new Racional(1, 2)
	println(obj1)

	// No se puede por el require
	//val obj2 = new Racional(1, 0)

	val obj3 = new Racional(7)
	println(obj3)

	val obj4 = new Racional(4, 8)
	println(obj4)

	val suma = obj4 + obj1
	println(suma)

	val suma2 = obj4 + 3
	println(suma2)

}