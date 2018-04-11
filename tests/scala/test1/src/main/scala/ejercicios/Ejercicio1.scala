package ejercicios

object Ejercicio1 extends App{

	/**
	  * Función identidad
	  * @param x valor a devolver
	  * @return mismo valor recibido
	  */
	def identidad(x: Int): Int = x

	/**
	  * Calcula el cuadrado de un valor
	  * @param x valor a calcular el cuadrado
	  * @return cuadrado del valor recibido
	  */
	def cuadrado(x: Int): Int = x*x

	/**
	  * Función que calcula la potencia 2 de un número
	  * @param x valor sobre el que se calcula
	  * @return 2^valor de un número
	  */
	def potencia2(x: Int): Int = {
		if(x == 0) 1
		else potencia2(x-1) * 2
	}

	println(potencia2(5))

	def potencia2TR(x: Int): Int = {

		@annotation.tailrec
		def go(x: Int, acum: Int): Int = {

			if(x == 0) acum

			else go(x-1, acum * 2)

		}

		go(x, 1)

	}

	println(potencia2TR(5))

	/**
	  * Sumatorio entre a y b de x
	  */
	def sumatorioEnteros(a: Int, b: Int): Int = {

		@annotation.tailrec
		def go(a: Int, acum: Int): Int = {

			if(a > b) acum
			else go(a + 1, a + acum)

		}

		go(a, 0)

	}

	println("Sumatoria entre 1 y 5: " + sumatorioEnteros(1, 5))

	/**
	  * Sumatorio entre a y b de x al cuadrado
	  */
	def sumatorioEnterosCuadrado(a: Int, b: Int): Int = {

		@annotation.tailrec
		def go(a: Int, acum: Int): Int = {

			if(a > b) acum
			else go(a + 1, cuadrado(a) + acum)

		}

		go(a, 0)

	}

	println("Sumatoria entre 1 y 5 al cuadrado: " + sumatorioEnterosCuadrado(1, 5))

	/**
	  * Sumatorio entre a y b de x con la potencia de 2
	  */
	def sumatorioEnterosPotencia2(a: Int, b: Int): Int = {

		@annotation.tailrec
		def go(a: Int, acum: Int): Int = {

			if(a > b) acum
			else go(a + 1, potencia2TR(a) + acum)

		}

		go(a, 0)

	}

	println("Sumatoria entre 1 y 5 con la potencia de 2: " + sumatorioEnterosPotencia2(1, 5))

	/**
	  * Función sumatorio general
	  */
	def sumatorio(funcion: Int => Int, a: Int, b: Int): Int = {

		@annotation.tailrec
		def go(a: Int, acum: Int): Int = {

			if(a > b) acum
			else go(a + 1, funcion(a) + acum)

		}

		go(a, 0)

	}

	/**
	  * Nueva función sumatorio enteros
	  */
	def sumatorioEnterosV2(a: Int, b: Int): Int = sumatorio(identidad, a, b)
	def sumatorioCuadradosV2(a: Int, b: Int): Int = sumatorio(cuadrado, a, b)
	def sumatorioPotencia2V2(a: Int, b: Int): Int = sumatorio(potencia2TR, a, b)

	println("Sumatoria entre 1 y 5: " + sumatorioEnterosV2(1, 5))

	def sumatorioGeneral(f: Int => Int): (Int, Int) => Int = {

		def sumaConLimites(a: Int, b: Int): Int = {
			if(a > b) 0
			else f(a) + sumaConLimites(a+1, b)
		}

		sumaConLimites

	}

	def sumatorioEnterosV3 = sumatorioGeneral(identidad)
	def sumatorioCuadradosV3 = sumatorioGeneral(cuadrado)
	def sumatorioPotencias2V3 = sumatorioGeneral(potencia2TR)

	def sumatorioGeneralC(a: Int, b: Int)(f: Int => Int): Int = {

		if(a > b) 0
		else f(a) + sumatorioGeneralC(a+1, b)(f)

	}

	val resultado3 = sumatorioGeneralC(1, 10)(identidad)

	println(resultado3)

	def sumatorioGeneralCTR(a: Int, b: Int)(f: Int => Int): Int = {

		@annotation.tailrec
		def go(a: Int, acum: Int): Int = {

			if(a > b) acum
			else go(a+1, f(a) + acum)

		}

		go(a, 0)

	}

	val resultado4 = sumatorioGeneralCTR(1, 10)(identidad)

	println(resultado4)

}
