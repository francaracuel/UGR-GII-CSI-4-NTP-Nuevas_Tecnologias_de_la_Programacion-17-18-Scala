package tema5

object Fibonacci extends App{

	def fibonacci(n: Long): Long = {

		if(n == 0 || n == 1) n
		else fibonacci(n-1) + fibonacci(n-2)

	}

	def fibonacciTR(n: Long): Long = {

		@annotation.tailrec
		def go(n: Long, prev: Long, act: Long): Long = {

			// Caso base
			if(n == 0) prev

			// Caso inductivo
			else go(n - 1, act, act + prev)

		}

		go(n, 0, 1)

	}

	println("Fibonacci: " + fibonacci(7))
	println("Fibonacci: " + fibonacciTR(7))

	// Generar el término 20
	val tiempoInicio = System.nanoTime()

	val res2 = fibonacci(20)

	val tiempoFinal = System.nanoTime()

	// Generar el término 20
	val tiempoInicio3 = System.nanoTime()

	val res3 = fibonacci(20)

	val tiempoFinal3 = System.nanoTime()

	println("Tiempo de ejecución normal: " + (tiempoFinal-tiempoInicio) + ". Valor: " + res2)
	println("Tiempo de ejecución normal TR: " + (tiempoFinal3-tiempoInicio3) + ". Valor: " + res3)

}
