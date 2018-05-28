///////////////////////////////////////////////////////////////////////////////
//
// Francisco Javier Caracuel Beltrán
//
// Nuevas Tecnologías de la Programación - NTP
//
// Grado en Ingeniería Informática - CSI
//
// Curso 2017/2018
//
// Práctica 3. Programación funcional en Scala. Clases y objetos
//
// ConjuntoSuitePropiedades.scala
//
///////////////////////////////////////////////////////////////////////////////

import org.scalacheck.Gen._
import org.scalacheck.Prop.forAll
import org.scalacheck.Prop.all
import org.scalacheck.Properties

object ConjuntoSuitePropiedades extends Properties("Test sobre conjunto") {
	val valor = choose(0, 10)

	/**
	  * Generacion de secuencia de tamaño
	  *
	  * @param tam
	  * @return
	  */
	def secuencia(tam: Int): Range = {
		val inicio = valor.sample.getOrElse(0)
		inicio to (inicio + tam)
	}

	/**
	  * Propiedad para probar el metodo de obtencion de la longitud
	  */
	property("conjunto de tamaño uno") =
		forAll(valor) {
			valor => {
				// Se crea el conjunto de un elemento
				val conjunto = Conjunto.conjuntoUnElemento(valor)

				// Se comprueba que el conjunto contiene el valor
				conjunto(valor) == true
			}
		}

	property("conjunto union") =
		forAll(valor) {
			valor => {
				val secuencia1 = secuencia(10)
				val secuencia2 = secuencia(10)

				// Se generan los conjuntos a unir
				val conjunto1 = Conjunto(x => x >= secuencia1.min && x <= secuencia1.max)
				val conjunto2 = Conjunto(x => x >= secuencia2.min && x <= secuencia2.max)

				// Se produce la union
				val union = Conjunto.union(conjunto1, conjunto2)

				// Se itera sobre la union de ambos rangos y se comprueba la
				// pertenencia al conjunto
				val rangoUnion = secuencia1.toList ::: secuencia2.toList

				// De cumplirse que cada elemento esta en el conjunto union
				val resultado = rangoUnion.map(valor => {
					union(valor) == true
				})

				val global: Boolean = resultado.forall(res => res == true)
				global == true
			}
		}

	property("Conjunto Intersección") =
		forAll(valor) {
			valor => {
				val secuencia1 = secuencia(10)
				val secuencia2 = secuencia(10)

				// Se generan los conjuntos para la intersección
				val conjunto1 = Conjunto(x => x >= secuencia1.min && x <= secuencia1.max)
				val conjunto2 = Conjunto(x => x >= secuencia2.min && x <= secuencia2.max)

				// Se produce la intersección
				val interseccion = Conjunto.interseccion(conjunto1, conjunto2)

				// Se itera sobre la intersección de ambos rangos y se comprueba la
				// pertenencia al conjunto
				val rangoInterseccion = secuencia1.toList.intersect(secuencia2.toList)

				// De cumplirse que cada elemento esta en el conjunto intersección
				val resultado = rangoInterseccion.map(valor => {
					interseccion(valor) == true
				})

				val global: Boolean = resultado.forall(res => res == true)
				global == true
			}
		}

	property("Conjunto Diferencia") =
		forAll(valor) {
			valor => {
				val secuencia1 = secuencia(10)
				val secuencia2 = secuencia(10)

				// Se generan los conjuntos para la diferencia
				val conjunto1 = Conjunto(x => x >= secuencia1.min && x <= secuencia1.max)
				val conjunto2 = Conjunto(x => x >= secuencia2.min && x <= secuencia2.max)

				// Se produce la diferencia
				val diferencia = Conjunto.diferencia(conjunto1, conjunto2)

				// Se itera sobre la diferencia de ambos rangos y se comprueba la
				// pertenencia al conjunto
				val rangoDiferencia = secuencia1.toList.filterNot(secuencia2.toList.contains(_))

				// De cumplirse que cada elemento esta en el conjunto diferencia
				val resultado = rangoDiferencia.map(valor => {
					diferencia(valor) == true
				})

				val global: Boolean = resultado.forall(res => res == true)
				global == true
			}
		}

	property("Conjunto Filtrado") =
		forAll(valor) {
			valor => {
				val secuencia1 = secuencia(10)
				val secuencia2 = secuencia(10)

				// Se generan los conjuntos para el filtrado
				val conjunto1 = Conjunto(x => x >= secuencia1.min && x <= secuencia1.max)
				val conjunto2 = Conjunto(x => x >= secuencia2.min && x <= secuencia2.max)

				// Se produce el filtrado
				val filtrado = Conjunto.filtrar(conjunto1, conjunto2.funcionCaracteristica)

				// Se itera sobre el filtrado de ambos rangos y se comprueba la
				// pertenencia al conjunto
				val rangoFiltrado = secuencia1.toList.intersect(secuencia2.toList)

				// De cumplirse que cada elemento esta en el conjunto filtrado
				val resultado = rangoFiltrado.map(valor => {
					filtrado(valor) == true
				})

				val global: Boolean = resultado.forall(res => res == true)
				global == true
			}
		}

	property("Conjunto ParaTodo") =
		forAll(valor) {
			valor => {
				val secuencia1 = secuencia(10)

				// Se generan los conjuntos para el ParaTodo
				val conjunto1 = Conjunto(x => x >= secuencia1.min && x <= secuencia1.max)

				// Se crean las condiciones
				val condicion1 = Conjunto.paraTodo(conjunto1, x => x <= secuencia1.max)
				val condicion2 = Conjunto.paraTodo(conjunto1, x => x >= secuencia1.min)

				all(condicion1, condicion2)

			}
		}

	property("Conjunto Existe") =
		forAll(valor) {
			valor => {
				val secuencia1 = secuencia(10)

				// Se generan los conjuntos para el Existe
				val conjunto1 = Conjunto(x => x >= secuencia1.min && x <= secuencia1.max)

				// Se crean las condiciones
				val condicion1 = Conjunto.existe(conjunto1, x => x <= secuencia1.max / 2)
				val condicion2 = Conjunto.existe(conjunto1, x => x >= secuencia1.min * 2 )

				all(condicion1, condicion2)

			}
		}

	property("Conjunto Map") =
		forAll(valor) {
			valor => {
				val secuencia1 = secuencia(10)

				// Se generan los conjuntos para el Map
				val conjunto1 = Conjunto(x => x >= secuencia1.min && x <= secuencia1.max)
				val conjunto2 = Conjunto.map(conjunto1, (x => x*x))

				// Se crean las condiciones
				val condicion1 = conjunto1(secuencia1.max)
				val condicion2 = !conjunto2(secuencia1.max)

				all(condicion1 && condicion2)

			}
		}

}