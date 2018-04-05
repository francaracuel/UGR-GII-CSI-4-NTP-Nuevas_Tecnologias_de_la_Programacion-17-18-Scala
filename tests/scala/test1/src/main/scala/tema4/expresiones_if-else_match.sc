if(47 %3 > 0) println("No múltiplo de 3")

var x = 3
var y = 0

val max = if(x > y) x else y

val maxX = if(x > y) true

///////////////////////////////////////////////////////////////////////////////

x = 10

y = 30

val maximo = x > y match {
	case true => x
	case false => y
}

val error = 500

val mensaje = error match {
	case 200 => "OK"
	case 400 => {
					println("Error de ejecución")
					"Error 400"
				}
	case 500 => {
					println("Error sintáctico")
					"Error 500"
				}
}

val dia = "sabado"

val laborable = dia match {
	case "lunes" | "martes" | "miercoles" | "jueves" | "viernes" => "laborable"
	case "sabado" | "domingo" => "festivo"
	//case _ => "error"
	case otraCosa => {
		println(s"Cadena: $otraCosa")
		"Error"
	}
}

val respuesta = null

val mensajeRespuesta = respuesta match {
	case s if s != null => "Cadena no nula"
	case s => "Cadena nula"
}

val x1:Int = 12345

val y1:Any = x1

val respuesta1 = y1 match{
	case z:String => s"$z - String"
	case z:Double => f"$z%.2f - Double"
	case z:Float => f"$z%.2f - Float"
	case z:Long => s"${z} - Long"
	case z:Int => s"${z} - Int"
}

