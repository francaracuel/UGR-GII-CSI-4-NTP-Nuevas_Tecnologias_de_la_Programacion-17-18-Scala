package tema5

object ListaArgumentosVariables extends App{

	def sumar(numeros: Int *): Int = {

		var total = 0

		for(i <- numeros) total+= i

		total

	}

	println("Suma de un valor: " + sumar(1))

	println("Suma de dos valores: " + sumar(1, 2))

	// Funciones con varias listas de argumentos
	// Currying
	def multiplicar(x: Int)(y: Int) = x * y

	val multiplicarPor3 = multiplicar(3)_

	val resultado = multiplicarPor3(4)

	println("Resultado: " + resultado)

}
