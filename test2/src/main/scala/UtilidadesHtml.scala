trait UtilidadesHtml{

	def quitarMarcas(entrada: String): String = {
		println("Se quitan marcas")
		entrada
	}

}

trait OperacionesSegurasString{

	def eliminarEspacios(entrada: String): String = {
		println("Quitando blancos")
		entrada
	}

}

class Pagina(val contenido: String) extends UtilidadesHtml with OperacionesSegurasString{

	def comoTextoPlano: String = {
		quitarMarcas(eliminarEspacios(contenido))
	}

}

class ATrait{
	def mostrar = "Class A"
}

trait B1{self:ATrait => }

//class C1 extends B1
//class C2 extends ATrait with B1