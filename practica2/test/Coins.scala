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
// Test Coins.scala
//
///////////////////////////////////////////////////////////////////////////////

import coins.Coins
import org.scalacheck.Properties
import org.scalacheck.Prop.{all}

object Coins extends Properties("Coins") {

	val coins: Coins = new Coins

	val amounts = List(4, 8, 367, 0)
	val typeCoins = List(
		List(1, 2),
		List(1, 2, 5, 10, 20, 50),
		List(1, 2, 5, 10, 20, 50),
		List(1, 2, 5, 10, 20, 50)
	)
	val numberOfChanges = List(3, 7, 962812, 1)

	property("Contador de posibles cambios de monedas") = {

		all(
			coins.getNumberChanges(amounts(0), typeCoins(0)) == numberOfChanges(0),
			coins.getNumberChanges(amounts(1), typeCoins(1)) == numberOfChanges(1),
			coins.getNumberChanges(amounts(2), typeCoins(2)) == numberOfChanges(2),
			coins.getNumberChanges(amounts(3), typeCoins(3)) == numberOfChanges(3)
		)

	}



}
