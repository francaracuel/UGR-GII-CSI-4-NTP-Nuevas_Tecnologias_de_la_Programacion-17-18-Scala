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

object Main extends App{

	val x1 = new Variable("X1", 5)
	val x2 = new Variable("X2", 4)
	val x3 = new Variable("X3", 3)
	val x4 = new Variable("X4", 1)

	//println(x1)

	//println(x1.name)

	val domain1 = new Domain(List(x1, x2, x3))

	println(domain1.isEmpty)
	println(domain1.length)
	println(domain1.getWeights)
	println(domain1.maxIndex)
	println(domain1.apply(0))
	println(domain1.apply(1))
	println(domain1.apply(2))
	println(domain1)
	println(domain1 + x3)
	println(domain1 + x4)
	println(domain1 - x4)
	println(domain1 - x3)

}
