package pruebaAccesibilidad1

private [pruebaAccesibilidad1] class Configuracion{

	val url = "http://localhost"

}

class Autenticacion{

	// Privado para la instacia
	private [this] val password = "1234"

	def validar: Boolean = password.size > 0

	def comparar(otro: Autenticacion): Boolean = {
		password == otro.password
	}

}