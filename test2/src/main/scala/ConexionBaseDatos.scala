object ConexionBaseDatos {

	private val url ="htto://locahost"
	private val usuario = "admin"
	private val password = "1234"

	def apply() = new ConexionBaseDatos

}

class ConexionBaseDatos{

	private val propiedades = Map(
		"url" -> ConexionBaseDatos.url,
		"usuario" -> ConexionBaseDatos.usuario,
		"password" -> ConexionBaseDatos.password
	)

}

class A1{

	val a: Int = 3
	val b: Int = 5

	def sumar(): Int = a + b

}

object ObjetoHeredadoA1 extends A1

object EjemploUso extends App{
	val res = ObjetoHeredadoA1.sumar
}











