package tema5

object MarcadorPosicion extends App{

	// Es posible crear literales tipo función edjando argumentos libres
	val multiplicarPor2: Int => Int = _ * 2

	val multiplicarPor2Extendido = (x: Int) => x*2

	// La variable multiplicarPor2 puede usarse asignando el valor al argumento
	val resultado1 = multiplicarPor2(3)
	println("Resultado1: " + resultado1)

	// Tenemos función para operación con cadenas
	def operacionCadenas(cadena: String, operacion: String => String): String = {
		if(cadena != null) operacion(cadena)
		else cadena
	}

	val resultado2 = operacionCadenas("Hola, mundo!", x => x.reverse)
	val resultado3 = operacionCadenas("Hola, mundo!", _.reverse)

	// El marcador también puede usarse en funciones de varios argumentos
	def aplicacionFuncion(x: Int, y: Int, funcion: (Int, Int) => Int): Unit =
		funcion(x, y)

	// Se usa mediante el marcador de posición
	val resultado4 = aplicacionFuncion(12, 3, (x: Int, y: Int) => x*y)
	val resultado5 = aplicacionFuncion(12, 3, _*_)

	println("Resultado4: " + resultado4)
	println("Resultado5: " + resultado5)

}
