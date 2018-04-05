package tema5

object FuncionesOrdenSuperior extends App{

	def operacionSeguraString(cadena: String, operacion: String => String) = {

		if(cadena != null) operacion(cadena)

		else cadena

	}

	def invertir(cadena: String) = cadena.reverse

	def aMayuscula(cadena: String) = cadena.toUpperCase

	val res1 = operacionSeguraString("Hola, Pepe", invertir)

	val res2 = operacionSeguraString("Hola, Pepe", aMayuscula)

	println(res1)

	println(res2)

	// Composición de funciones
	def componer(f: Double => Double, g: Double => Double): Double => Double = {

		x => f(g(x))

	}

	def mas5(x: Double) = x+5

	def cuadrado(x: Double) = x*x

	val fg = componer(mas5, cuadrado)

	val valor = fg(5)

	println(valor)

}
