///////////////////////////////////////////////////////////////////////////////
//
// Francisco Javier Caracuel Beltrán
//
// Nuevas Tecnologías de la Programación (NTP) - CSI - UGR - ETSIIT
//
// Curso 2017/2018
//
// Práctica 2. Programación funcional en Scala. Recursivdad
//
// Test ListaCheck.scala
//
///////////////////////////////////////////////////////////////////////////////

import lista.Lista
import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

import scala.util.Random

object ListaCheck extends Properties("Lista") {

	val numberGen = Gen.listOf(Gen.choose(0, 10))

	property("Lista -> Longitud") = forAll(numberGen) {

		(list) => {

			Lista.longitud(Lista(list : _*)) == list.length

		}

	}

	property("Lista -> Suma de enteros") = forAll(numberGen){

		(list) => {

			Lista.sumaEnteros(Lista(list : _*)) == list.map(_.toDouble).sum

		}

	}

	property("Lista -> Producto de enteros") = forAll(numberGen){

		(list) => {

			Lista.productoEnteros(Lista(list : _*)) == list.map(_.toDouble).product

		}

	}

	property("Lista -> Concatenación") = forAll(numberGen){

		(list) => {

			Lista.toList(Lista.concatenar(Lista(list : _*), Lista(list : _*))) == list:::list

		}

	}

	property("Lista -> Fold right") = forAll(numberGen){

		(list) => {

			Lista.foldRight(Lista(list : _*), 0)(_ + _) == list.foldRight(0)(_ + _)

		}

	}

	property("Lista -> Suma fold right") = forAll(numberGen){

		(list) => {

			Lista.sumaFoldRight(Lista(list : _*)) == list.foldRight(0)(_ + _)

		}

	}

	property("Lista -> Producto fold right") = forAll(numberGen){

		(list) => {

			Lista.productoFoldRight(Lista(list : _*)) == list.foldRight(0)(_ * _)

		}

	}

	property("Lista -> Asignar cabeza") = forAll(numberGen){

		(list) => {

			val head = Gen.choose(0,10)

			if(list.size > 0)
				Lista.toList(Lista.asignarCabeza(Lista(list : _*), head)) == list.updated(0, head)
			else true

		}

	}

	property("Lista -> Tail") = forAll(numberGen){

		(list) => {

			if(list.size > 0)
				// Tener que comprobar que es mayor que 0 es debido al tipo List,
				// no a la lista implementada en la clase List
				Lista.toList(Lista.tail(Lista(list : _*))) == list.tail
			else true

		}

	}

	property("Lista -> Eliminar") = forAll(numberGen){

		(list) => {

			// Se comprueba que tenga algún valor para calcular el número aleatorio
			if(list.size > 0) {

				val n = Random.nextInt(list.size)
				Lista.toList(Lista.eliminar(Lista(list : _*), n)) == list.drop(n)

			} else true

		}

	}

	property("Lista -> Eliminar mientras") = forAll(numberGen){

		(list) => {

			// Se comprueba que tenga algún valor para calcular el número aleatorio
			if(list.size > 0) {

				val criterion = (a:Int) => a < 3

				Lista.toList(Lista.eliminarMientras(Lista(list : _*), criterion)) == list.dropWhile(criterion)

			} else true

		}

	}

	property("Lista -> Eliminar último") = forAll(numberGen){

		(list) => {

			Lista.toList(Lista.eliminarUltimo(Lista(list : _*))) == list.dropRight(1)

		}

	}

	property("Lista -> Fold left") = forAll(numberGen){

		(list) => {

			Lista.foldLeft(Lista(list : _*), 0)(_ + _) == list.foldLeft(0)(_ + _)

		}

	}

}
