package tema5

object OrdenacionPolimorfica{

	def main(args: Array[String]): Unit = {

		val array1: Array[Int] = Array(1, 5, 20, 25, 30, 35, 40)
		val array2: Array[Int] = Array(40, 35, 30, 25, 20, 5, 1)

		val res1 = OrdenacionPolimorfica.ordenado(array1, (x: Int, y: Int) => x < y)
		println("Ordenación creciente de array1: " + res1)

		val res2 = OrdenacionPolimorfica.ordenado(array2, desc(_, _))
		println("Ordenación descreciente de array2: " + res2)

		val res3 = OrdenacionPolimorfica.ordenadoV2(array1)(_ > _)

	}

	def asc(a: Int, b: Int): Boolean = if (a < b) true else false
	def desc(a: Int, b: Int): Boolean = !asc(a, b)

	def ordenado[A](as: Array[A], criterio: (A, A) => Boolean): Boolean = {


		/**
		  * Realiza la comprobación suponiendo que lo que está a la izquierda
		  * de índice está ordenado
		  * @param indice
		  * @return
		  */
		@annotation.tailrec
		def go(indice: Int): Boolean = {

			// Caso base 1: se tratan los dos últimos elementos
			if(indice == as.length - 2) criterio(as(indice), as(indice+1))
			else {
				// Segundo caso base: los elementos no cumplen el criterio
				if(criterio(as(indice), as(indice+1)) == false) false
				// Caso inductivo: seguir comprobando elementos
				else go(indice+1)
			}

		}

		go(0)

	}

	def ordenadoV2[A](as: Array[A])(criterio: (A, A) => Boolean): Boolean = {

		ordenado(as, criterio)

	}

}
