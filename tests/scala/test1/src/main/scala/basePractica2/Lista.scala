package basePractica2

/**
  * Interfaz genérica para una lista
  * Sealed indica que la clase esta "sellada" y no se puede redefinir
  * +A indica cómo se va a comportar la clase Lista con respecto a la herencia
  */
sealed trait Lista[+A]

/**
  * Declaración de lista vacía
  */
case object Nil extends Lista[Nothing]

/**
  * Lista con elementos
  */
case class Cons[+A](cabeza: A, cola: Lista[A]) extends Lista[A]

object Lista {

	def apply[A](elementos: A*): Lista[A] = {

		if(elementos.isEmpty) Nil
		else Cons(elementos.head, apply(elementos.tail: _*))

	}

	def longitud[A](lista: Lista[A]): Int = {

		lista match {
			case Nil => 0
			case Cons(cadena, cola) => 1 + longitud(cola)
		}

	}

	def sumaEnteros(enteros: Lista[Int]): Double = enteros match {

		case Nil => 0
		case Cons(cabeza, cola) => cabeza.toDouble + sumaEnteros(cola)

	}

}

object Prueba extends App{

	val lista1 = Lista(1, 2, 3, 4, 5, 6, 7)

}