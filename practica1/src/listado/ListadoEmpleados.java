///////////////////////////////////////////////////////////////////////////////
//
// Francisco Javier Caracuel Beltrán
//
// Nuevas Tecnologías de la Programación (NTP) - CSI - UGR - ETSIIT
//
// Curso 2017/2018
//
// ListadoEmpleados.java
//
///////////////////////////////////////////////////////////////////////////////

package listado;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoEmpleados {

    /**
    2 * Dato miembro para almacenar a los empleados tal y como se encuentran
    3 * en el archivo de datos.txt
    4 */
    private List<Empleado> listadoArchivo;

    /**
    * Dato miembro para almacenar a los empleados como mapa con pares
    * (una vez reparados los datos leidos del archivo)
    * <dni - empleado>
    */
    private Map<String, Empleado> listado;

    /**
     * Constructor de la clase
     * @constructor Recibe un nombre de fichero y crea un listado de empleados
     * @param file Ruta del fichero que contiene los datos
     */
    public ListadoEmpleados(String file){

        // Se crea el diccionario donde finalmente se almacenarán los empleados
        listado = new HashMap<String, Empleado>();

        // Se recorre el posible error por no encontrar el fichero
        try {

            Stream<String> lines = Files.lines(Paths.get(file), StandardCharsets.ISO_8859_1);

            // Se separarán los datos con un patrón que busca las comas
            Pattern pattern = Pattern.compile(",+");

            lines.map(line -> crearEmpleado(line)).forEach(System.out::println);




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Crea un empleado en base a una línea del fichero de datos y lo
     * @param line Línea con los datos de un empleado
     */
    private Empleado crearEmpleado(String line){

        return new Empleado("1", "2", "3", "4");

    }

}
