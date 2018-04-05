package tema5

object Factorial extends App{

	// Declaración de la función factorial
	def factorial(x: Int): Int = {

		if(x == 0) 1

		else x * factorial(x-1)

	}

	val fac15 = factorial(15)

	println("Valor de factorial: " + fac15)

	// Tail recursive
	@annotation.tailrec
	def factorialTR(x: Int, acum: Int): Int = {

		if(x == 0 || x == 1) acum

		else factorialTR(x-1, acum * x)

	}

	val fact152 = factorialTR(15)

	println("Valor de factorialTR: " + fact152)

	def factorialTR(x: BigInt): BigInt = {

		@annotation.tailrec
		def aux(x: BigInt, acum: BigInt): BigInt = {

			if(x == 0 || x == 1) acum

			else aux(x-1, acum * x)

		}

		aux(x, 1)

	}

	val fact153 = factorialTR(15)

	println("Valor de factorialTR: " + fact153)

}
