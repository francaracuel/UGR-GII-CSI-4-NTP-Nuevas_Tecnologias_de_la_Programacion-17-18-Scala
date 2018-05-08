
class PuntoAleatorio{

	val x = {
		println("Asignación x: ")
		util.Random.nextInt
	}

	lazy val y = {
		println("Asignación y: ")
		util.Random.nextInt
	}

}

val p1 = new PuntoAleatorio
println(p1.y)


