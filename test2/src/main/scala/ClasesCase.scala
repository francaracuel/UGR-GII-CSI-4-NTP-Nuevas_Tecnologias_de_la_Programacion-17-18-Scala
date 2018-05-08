
/* Las clases Case siempre implementan "Companion object". Todos los datos
	son directamente "val"
	Ofrecen los siguientes métodos:
	- apply: const. de objetos
	- copy
	- equals
	- hashcode
	- toString
	- unapply: utilizado en una sentencia match para trocear los elementos que
	 		   se usan en el case
	*/

case class Personaje(nombre: String, heroe: Boolean) {



}

object ClasesCase extends App{

	val personaje1 = Personaje("Superman", true)
	val personaje2 = Personaje("Spiderman", false)

	// Comparación
	val comparacion: Boolean = personaje1 == personaje2
	println(comparacion)

	// Uso toString
	println(personaje1)

	// Uso de unapply
	val resultado: Option[(String, Boolean)] = Personaje.unapply(personaje1)

}