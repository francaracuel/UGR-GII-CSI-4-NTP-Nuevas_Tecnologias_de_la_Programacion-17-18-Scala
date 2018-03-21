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

	def main(args: Array[String]): Unit = {

		if(args.length == 0){
			println("El uso del programa debe incluir un nombre de archivo")
		} else{
			println("----------------------- Versión 1 -------------------")
			imprimirLineasV1(args(0))
			println("-----------------------------------------------------")
		}

	}

}
