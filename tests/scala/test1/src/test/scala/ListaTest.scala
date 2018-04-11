import basePractica2.Lista
import org.scalacheck.Properties
import org.scalacheck.Prop.{AnyOperators, forAll, throws}
import org.scalacheck.Gen._

object ListaTest extends Properties("ListaTest"){

	// Método de generación de listas de valores
	val secuenciaEnteros = listOf(choose(0, 10))

	property("longitud de lista") = forAll(secuenciaEnteros){

		xs => {

			// Crear una lista a partir de xs
			val lista: Lista[Int] = Lista(xs: _*)
			val longitudList = xs.length
			val longitudLista = Lista.longitud(lista)
			longitudList ?= longitudLista

		}

	}

	property("suma de enteros") = forAll(secuenciaEnteros){

		xs => {

			// se crea onjet de clase Lista
			val lista: Lista[Int] = Lista(xs: _*)
			val sumaList = xs.map(x => x.toDouble).sum
			val sumaLista = Lista.sumaEnteros(lista)

			// Se comprueba la igualdad
			sumaList ?= sumaLista

		}

	}

}
