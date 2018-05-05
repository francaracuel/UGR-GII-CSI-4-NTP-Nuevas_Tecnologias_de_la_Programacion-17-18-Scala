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
// Test Lista.scala
//
///////////////////////////////////////////////////////////////////////////////

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}
import pascalsTriangle.PascalsTriangle

object PascalsTriangle extends Properties("Lista") {

	val secuenciaEnteros = Gen.listOf(choose(0,10))

}
