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
	val x4 = new Variable("X4", 6)

	//println(x1)

	//println(x1.name)

	val domain1 = new Domain(List(x1, x2, x3))
	val domain2 = new Domain()
	val domain3 = new Domain(List())
	val domain4 = new Domain(List(x4))

	println("Domain1 is empty: " + domain1.isEmpty)
	println("Length domain1: " + domain1.length)
	println("Weights domain1: " + domain1.getWeights)
	println("Domain1 max index: " + domain1.maxIndex)
	println("Domain1 Var0: " + domain1.apply(0))
	println("Domain1 Var1: " + domain1.apply(1))
	println("Domain1 Var2: " + domain1.apply(2))
	println("Domain1     : " + domain1)
	println("Domain1 + x3: " + (domain1 + x3))
	println("Domain1 + x4: " + (domain1 + x4))
	println("Domain1 - x4: " + (domain1 - x4))
	println("Domain1 - x3: " + (domain1 - x3))

	println()

	println("Domain2: " + domain2)
	println("Domain2 is empty: " + domain2.isEmpty)
	println("Length domain2: " + domain2.length)
	println("Weights domain2: " + domain2.getWeights)
	println("Domain2 max index: " + domain2.maxIndex)

	println()

	println("Domain1 + Domain4: " + (domain1 + domain4))
	println("Domain1 + Domain4 max index: " + (domain1 + domain4).maxIndex)

}
