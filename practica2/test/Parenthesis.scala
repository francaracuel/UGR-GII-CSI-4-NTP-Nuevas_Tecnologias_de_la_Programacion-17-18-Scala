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
// Test Parenthesis.scala
//
///////////////////////////////////////////////////////////////////////////////

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}
import parenthesis.Parenthesis

object Parenthesis extends Properties("Parenthesis") {

	val parenthesis: Parenthesis = new Parenthesis

	// Generación de cadenas de longitud n: forma de uso strGen(10) para
	// cadenas de 10 caracteres
	val strGen = (n: Int) => Gen.listOfN(n, Gen.oneOf('(', ')',
								Gen.alphaChar.sample.get))

	/**
	  * Comprueba si una cadena está balanceada
	  * @param list - Lista de caracteres que contiene la cadena
	  * @return true si está balanceada. False si no lo está
	  */
	private def isBalanced(list: List[Char]): Boolean = {

		parenthesis.isBalanced(list)

		var opened = 0
		var closed = 0
		var balanced = true

		list.map(c => {
			if(c == '(') opened += 1
			else if(c == ')') closed += 1
			if(opened < closed) balanced = false
		})

		balanced && opened == closed

	}

	property("Balanceo de paréntesis") = forAll(strGen(10)){
		(list) => {
			println("Cadena: " + list.mkString)
			// El resultado será positivo si el método recursivo creado ofrece
			// el mismo resultado que el creado en esta clase
			parenthesis.isBalanced(list) == isBalanced(list)
		}
	}

}
