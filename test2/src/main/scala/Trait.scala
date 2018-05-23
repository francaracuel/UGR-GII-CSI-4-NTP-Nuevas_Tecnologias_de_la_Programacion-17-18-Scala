import scala.collection.mutable.ArrayBuffer

class Trait {

}

/**
  * Clase abstracta para cola de enteros
  */
abstract class ColaEnteros{

	def get():Int
	def put(x: Int)

}

class ColaEnterosBasica extends ColaEnteros{

	private val buf = new ArrayBuffer[Int]

	def get() = buf.remove(0)

	def put(x: Int) = buf += x

}

trait ColaDoblando extends ColaEnteros{

	abstract override def put(x: Int) = {
		println("put en ColaDoblando")
		super.put(2*x)
	}

}

trait ColaIncrementando extends ColaEnteros{

	abstract override def put(x: Int) = {
		println("put en ColaIncrementando")
		super.put(x+1)
	}

}

trait ColaFiltrando extends ColaEnteros{

	abstract override def put(x: Int) = {
		println("put en ColaFiltrando")
		if(x >= 0) super.put(x)
	}

}

class ColaVersion1 extends ColaEnterosBasica with ColaDoblando

object PruebaInterfaces extends App{

	val cola1 = new ColaVersion1
	cola1.put(10)
	println(cola1.get())

	// Importa el orden en el que se importa el comportamiento. Se aplica el comportamiento
	// de derecha a izquierda. En cola2 el primer put que se hace es el de ColaFiltrando
	val cola2 = new ColaEnterosBasica with ColaIncrementando with ColaFiltrando
	val cola3 = new ColaEnterosBasica with ColaFiltrando with ColaIncrementando

	cola2.put(-1)
	cola2.put(0)
	cola2.put(1)
	cola3.put(-1)
	cola3.put(0)
	cola3.put(1)

	println("Primero en cola2: " + cola2.get())
	println("Prmero en cola3: " + cola3.get())

}