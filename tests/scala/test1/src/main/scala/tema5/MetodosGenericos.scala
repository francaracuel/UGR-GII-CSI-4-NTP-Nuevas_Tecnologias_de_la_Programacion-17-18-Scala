package tema5

object MetodosGenericos extends App{

	def eliminarPrimero[A](lista: List[A]) = lista.tail

	val lista1 = eliminarPrimero(List(1, 2, 3, 4))

	println(lista1)

	val lista2 = eliminarPrimero(List('a', 'b', 'c', 'd'))

	println(lista2)

	val lista3 = eliminarPrimero(List("cadena1", "cadena2", "cadena3"))

	println(lista3)

}
