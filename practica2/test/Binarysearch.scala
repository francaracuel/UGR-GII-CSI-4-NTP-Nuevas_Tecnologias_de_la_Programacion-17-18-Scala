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
// Test BinarySearch.scala
//
///////////////////////////////////////////////////////////////////////////////

import binarySearch.BinarySearch
import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object BinarySearch extends Properties("BinarySearch") {

	val binarySearch: BinarySearch = new BinarySearch

	val numberGen = Gen.listOf(Gen.choose(0, 500))


	property("Búsqueda binaria genérica") = forAll(numberGen){
		(list) => {

			val sorted = list.sorted

			val element = Gen.choose(0,500).sample.getOrElse(0)

			val indexOfIndexOf = sorted.indexOf(element)
			val indexOfbinarySearch = binarySearch.busquedaBinaria[Int](sorted.toArray, element, _ < _)

			println()
			println("Lista:             " + sorted)
			println("Elemento a buscar: " + element)
			println("indexOf:            " + indexOfIndexOf.toString)
			println("binarySearch:       " + indexOfbinarySearch)

			indexOfIndexOf == indexOfbinarySearch

		}
	}

}
