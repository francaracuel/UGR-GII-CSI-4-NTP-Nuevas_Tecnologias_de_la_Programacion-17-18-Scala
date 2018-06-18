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

/**
  * Clase Variable. Contiene un nombre para la variable y el número de estados
  * que puede tener
  * @param name - Nombre de la variable
  * @param state - Número de estados. Si el número de estados fuera 3, se
  *              permitiría una asignación de 0, 1 o 2
  */
class Variable(val name: String, val state: Int) {

	private val this.name: String = name
	private val this.state: Int = state

	/**
	  * Sobreescritura del método toString para poder pintar por pantalla el
	  * objeto sin ningún tratamiento más
	  * @return String con el contenido que se quiere mostrar
	  */
	override def toString = {
		"Name: %s, State: %d".format(this.name, this.state)
	}

}
