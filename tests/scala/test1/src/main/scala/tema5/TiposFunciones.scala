package tema5

import javax.print.DocFlavor.BYTE_ARRAY

object TiposFunciones extends App{

	def duplicar(x: Int) = x * 2

	val resultado = duplicar(20)

	val funcion: (Int) => Int = duplicar

	val otro = funcion

	println(otro(1))

	// Equivalente a: val funcion: (Int) => Int = duplicar
	val funcion2 = duplicar _

	def calcularMaximo(a: Int, b: Int) = if(a > b) a else b

	val funcion3 = calcularMaximo _

	val funcion4: (Int, Int) => Int = calcularMaximo



}
