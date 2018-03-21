import scala.io.Source
// Versión 1:
// procesar líneas y para cada línea escribir longitud y contenido
// Version 2:
// mantener sangrado
// doble procesamiento de líneas:
// - determinar máx. número de caracteres necesarios para la longitud
// - escribir contenido
// Versión 3:
// obtener línea más larga y calcular el número de caracteres para la longitud

object ProcesamientoLineas {

	// Versión inicial
	def imprimirLineasV1(nombreArchivo: String): Unit = {

		// Se obtienen objetos de la clase String para cada línea
		val lineas: List[String] = Source.fromFile(nombreArchivo).getLines().toList

		// Procesamiento de cada línea
		for(linea <- lineas)
			println(linea.length + " | " + linea)

	}

	// Segunda versión con dos pasadas
	def calcularAnchoTamLinea(linea: String) = linea.length.toString.length

	def imprimirLineasV2(nombreArchivo: String): Unit = {

		val lineas = Source.fromFile(nombreArchivo).getLines().toList

		// Primera pasada sobre líneas para determinar la más larga
		var maximoAnchoTam = 0

		for(linea <- lineas){
			maximoAnchoTam = maximoAnchoTam.max(calcularAnchoTamLinea(linea))
		}

		val maximoAnchoTam2 = lineas.map(linea => calcularAnchoTamLinea(linea)).max

		// Procesamiento para imprimir el contenido de las líneas
		for(linea <- lineas){
			val tamLinea = calcularAnchoTamLinea(linea)
			val relleno = " "*(maximoAnchoTam2-tamLinea)
			println(relleno+linea.length+" | "+linea)
		}

	}

	// Tercera versión
	def imprimirLineasV3(nombreArchivo: String): Unit = {

		val lineas = Source.fromFile(nombreArchivo).getLines().toList

		// Obtener la línea de mayor longitud
		val lineaMasLarga = lineas.reduceLeft((a, b) => if(a.length > b.length) a else b)

		// Determinar el máximo tamaño para indicar la longitud
		val maximoAnchoTam = calcularAnchoTamLinea(lineaMasLarga)

		for(linea <- lineas){
			val tamLinea = calcularAnchoTamLinea(linea)
			val relleno = " "*(maximoAnchoTam-tamLinea)
			println(relleno+linea.length+" | "+linea)
		}

	}

	def main(args: Array[String]): Unit = {

		if(args.length == 0){
			println("El uso del programa debe incluir un nombre de archivo")
		} else{
			println("----------------------- Versión 1 -------------------")
			imprimirLineasV2(args(0))
			println("-----------------------------------------------------")
		}

	}

}
