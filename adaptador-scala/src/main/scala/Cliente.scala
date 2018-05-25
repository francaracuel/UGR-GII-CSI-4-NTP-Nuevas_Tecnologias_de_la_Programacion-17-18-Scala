
object Adaptadores{
	implicit class Adaptador1(val cifrador1: Cifrador1){
		def ejecutar(cadena: String): String = {
			cifrador1.cifrar(cadena)
		}
	}

	implicit class Adaptador2(val cifrador2: Cifrador2){
		def ejecutar(cadena: String): String = {
			cifrador2.realizarCifrado(cadena)
		}
	}
}

class Cifrador1{
	def cifrar(cadena: String): String = {
		"Cifrado con Cifrador1 : " + cadena
	}
}

class Cifrador2{
	def realizarCifrado(cadena: String): String = {
		"Cifrado con Cifrador2 : " + cadena
	}
}

object Cliente extends App{

	import Adaptadores._

	val cifrador1 = new Cifrador1
	val cifrador2 = new Cifrador2

	cifrador1.ejecutar("Cadena a cifrar...")
	cifrador2.ejecutar("Cadena a cifrar...")

}
