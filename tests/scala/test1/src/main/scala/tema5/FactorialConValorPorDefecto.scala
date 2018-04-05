package tema5

object FactorialConValorPorDefecto extends App{

	def factorialTR(x: BigInt, acum: BigInt = 1): BigInt = {

		if(x == 0 || x == 1) acum

		else factorialTR(x - 1, acum * x)

	}

	val fac15 = factorialTR(15)

	println("Valor de factorial TR: " + fac15)

	val fac30 = factorialTR(acum = 1, x = 30)

	println("Valor de factorial TR: " + fac30)

}
