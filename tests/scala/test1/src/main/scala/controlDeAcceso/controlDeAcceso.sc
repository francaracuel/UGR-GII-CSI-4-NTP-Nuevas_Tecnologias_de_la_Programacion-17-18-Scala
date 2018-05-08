class Usuario(private var password: String){

	def actualizarPassword(p: String): Unit = {
		password = p
	}

	def validar(p: String): Boolean = {
		p == password
	}

}

val usuario1 = new Usuario("clave")

usuario1.password

