package tema5

object AplicacionParcial extends App{

	// Se define una función para determinar divisibildad
	def divisible(x: Int, y: Int): Boolean = x%y == 0

	// Se puede definir una variable sin indicar argumentos
	val f: (Int, Int) => Boolean = divisible _

	// Aplicación parcial: crear una función para comprobar divisibilidad por 3
	val divisiblePor3: Int => Boolean = divisible(_: Int, 3)

	val resultado1 = divisiblePor3(27)

	println("resultado1: " + resultado1)

	// Más claro con varias listas de argumentos
	def divisiblePor(x: Int)(y: Int): Boolean = x%y == 0

	val divisiblePor3V2 = divisiblePor(_: Int)(3)

	val divisibilidad100 = divisiblePor(100)(_: Int)

	val resultado2 = divisiblePor3V2(27)
	val resultado3 = divisibilidad100(8)

}
