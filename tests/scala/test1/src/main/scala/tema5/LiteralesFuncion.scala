package tema5

object LiteralesFuncion {

	val multiplicarPor2 = (x: Int) => x*2

	val variableFuncion = multiplicarPor2

	val res1 = multiplicarPor2(3)
	val res2 = variableFuncion(3)

	println("res1: " + res1 + "res2 " + res2)

	// Se define una función por el mecanismo clásico
	def calcularMaximo(a: Int, b: Int): Int = if(a > b) a else b

	// Esta función también puede asignarse a una variable, pero no como si fuera un literal:
	// uso subrayado, especificando el tipo de la función
	val variableFuncion2: (Int, Int) => Int = calcularMaximo

	val variableFuncion3 = calcularMaximo _

	// Las dos variables son perfectamente usables
	println("El máximo e 3 y 5 con variableFuncion2: " + variableFuncion2(3, 5))
	println("El máximo e 3 y 5 con variableFuncion3: " + variableFuncion3(3, 5))

	// Creación de literales tipo función sin argumentos
	val saludo = () => "Hola, mundo!"

	println(saludo())

}
