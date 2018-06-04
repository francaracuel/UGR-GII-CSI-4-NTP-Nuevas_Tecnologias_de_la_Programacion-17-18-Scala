///////////////////////////////////////////////////////////////////////////////
//
// Francisco Javier Caracuel Beltrán
//
// Nuevas Tecnologías de la Programación - NTP
//
// Curso 2017/2018
//
// Computación y Sistemas Inteligentes - CSI
//
// Práctica final - Árboles de probabilidad
//
///////////////////////////////////////////////////////////////////////////////

class Variable(val name: String, val state: Int) {

	private val this.name: String = name
	private val this.state: Int = state

	override def toString = {
		"Name: %s, State: %d".format(this.name, this.state)
	}

}
