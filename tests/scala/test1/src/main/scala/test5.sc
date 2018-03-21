val x = 3

x.isInstanceOf[Any]

class NumeroComplejo(val x: Double, val y: Double){}

val c1 = new NumeroComplejo(3.4, 8.9)

c1.isInstanceOf[AnyRef]

c1.isInstanceOf[Any]

val nada = () // Tipo Unit

val t: Char = 65

t.getClass.getName

"A".hashCode

val tEntero = t.asInstanceOf[Int]

20.toByte

(5.0/7.0).toString

// Tuplas
val ejemplo = (5, "sol", false, 9.43)

println("Componente 2: "+ejemplo._2)

val rojo = "rojo" -> "0xff0000"

val rojoInvertido = rojo._2 -> rojo._1