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
// Test PascalsTriangle.scala
//
///////////////////////////////////////////////////////////////////////////////

import pascalsTriangle.PascalsTriangle
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.{forAll}

object PascalsTriangle extends Properties("PascalsTriangle") {

	val pascalsTriangle: PascalsTriangle = new PascalsTriangle

	val MAXIMO = 10

	val coordenadasExtremos = for{
		fila <- Gen.choose(0, MAXIMO)
		columna <- Gen.oneOf(0, fila)
	} yield(fila ,columna)

	val internalCoord = for {
		row <- Gen.choose(2, MAXIMO)
		col <- Gen.choose(1, row - 1)
	} yield (row, col)

	property("Elementos en los lados del triángulo valen 1") = forAll(coordenadasExtremos){
		(i) => {
			val resultado = pascalsTriangle.getValue(i._1, i._2)
			println("Fila = " + i._1 + ", Columna = " + i._2 + " -> Resultado = " + resultado)
			resultado == 1
		}
	}

	property("Elementos interiores deben ser iguales a la suma de los elementos superiores") =
		forAll(internalCoord){
			(i) => {
				val result = pascalsTriangle.getValue(i._1, i._2)
				println("Fila = " + i._1 + ", Columna = " + i._2 + " -> Resultado = " + result)
				result == pascalsTriangle.getValue(i._1 - 1, i._2 - 1) +
								pascalsTriangle.getValue(i._1 - 1, i._2)
			}
	}

}
