
class ControlAcceso(val sincronizador: () => Boolean,
					val gestorNivel: () => Boolean){
	// Ejecución sincronización
	def ejecutarSincronizacion: Boolean = {
		sincronizador()
	}

	def ejecutarCambioNivel: Boolean = {
		gestorNivel()
	}
}

object ComportamientoSincronizacion{
	def sincronizacionCentral(): Boolean = {
		println("Sincronización centralizada...")
		true
	}

	def sincronizacionDescentralizada(): Boolean = {
		println("Sincronización descentraliazada...")
		true
	}
}

object ComportamientoCambioNivel{
	def cambioNivelCentral(): Boolean = {
		println("Cambio de nivel centralizado...")
		true
	}

	def cambioNivelDescentralizado(): Boolean = {
		println("Cambio de nivel descentraliazado...")
		true
	}
}

object PruebaEstrategia extends App{

	val control1 = new ControlAcceso(ComportamientoCambioNivel.cambioNivelCentral,
		ComportamientoSincronizacion.sincronizacionCentral)

	control1.ejecutarSincronizacion
	control1.ejecutarCambioNivel

}
