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
    * Dato miembro para almacenar a los empleados tal y como se encuentran
    * en el archivo de datos.txt
    */
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
    public ListadoEmpleados(String file) throws IOException {

        // Se crea el diccionario donde finalmente se almacenarán los empleados
        listado = new HashMap<String, Empleado>();

        // Se recoge el posible error por no encontrar el fichero
        //try {

            Stream<String> lines = Files.lines(Paths.get(file), StandardCharsets.ISO_8859_1);

            // Se guardan todos los empleados en listadoArchivo
            listadoArchivo = lines.map(line -> crearEmpleado(line)).collect(Collectors.toList());

        //} catch (IOException e) {
            //e.printStackTrace();
        //}

    }

    /**
     * Crea un empleado en base a una línea del fichero de datos y lo devuelve
     *
     * @param line Línea con los datos de un empleado separados por comas
     * @return Objeto empleado con los datos de "line"
     */
    private Empleado crearEmpleado(String line){

        // Se separarán los datos con un patrón que busca las comas
        List<String> employer = Pattern.compile(",+").
                splitAsStream(line).
                collect(Collectors.toList());

        // Se devuelve el empleado enviando los parámetros correspondientes que
        // necesita en el constructor
        return new Empleado(employer.get(0).replaceAll("\\s+",""),
                employer.get(1).replaceAll("\\s+",""),
                employer.get(2).replaceAll("\\s+",""),
                employer.get(3).replaceAll("\\s+",""));

    }

    /**
     * Calcula el número de empleados que contiene listadoArchivo
     *
     * @return Número de empleados en listadoArchivo
     */
    public int obtenerNumeroEmpleadosArchivo(){
        return listadoArchivo.size();
    }

    /**
     * Comprueba si existen DNIs repetidos en listadoArchivo
     *
     * @return True si hay dnis repetidos. False si no los hay.
     */
    public boolean hayDnisRepetidosArchivo(){

        // Se comprueba si el número de dnis que hay diferentes no es igual al
        // número de empleados que hay en listadoArchivo
        /*return listadoArchivo.stream().
                map(Empleado::obtenerDni).
                distinct().count() != obtenerNumeroEmpleadosArchivo();*/

        // Se hace uso del método contarEmpleadosDnisRepetidos() para
        // comprobar si el valor devuelto es mayor que 0
        return  contarEmpleadosDnisRepetidos() > 0;

    }

    /**
     * Crea un diccionario donde se encuentran los pares <dni, lista de
     * empleados> donde aparece como clave el dni repetido y el valor una lista
     * con los empleados que tienen ese dni
     *
     * @ref https://stackoverflow.com/questions/33459961/how-to-filter-a-map-by-its-values-in-java-8
     *
     * @return Diccionario con los dnis y los empleados repetidos asociados a
     *         ese dni
     */
    public Map<String, List<Empleado>> obtenerDnisRepetidosArchivo(){

        // Se crea un diccionario con el dni como clave y una lista con los
        // empleados que tienen ese dni como valor
        Map<String, List<Empleado>> employers = listadoArchivo.stream().
                                                    collect(Collectors.groupingBy(Empleado::obtenerDni));

        // Se devuelve el diccionario pero solo con aquellas listas que tienen
        // más de 1 empleado con el mismo dni
        return employers.entrySet().stream().
                filter(value -> value.getValue().size() > 1).
                collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

    }

    /**
     * Comprueba utilizando el método obtenerDnisRepetidosArchivos() el número
     * de empleados que tienen el dni repetido
     *
     * @ref https://stackoverflow.com/questions/35993201/finding-number-of-values-in-a-hashmap
     *
     * @return Número de empleados con el dni repetido
     */
    public int contarEmpleadosDnisRepetidos(){

        // Se devuelve el número de elementos que tiene cada lista de empleados
        return obtenerDnisRepetidosArchivo().values().stream().
                mapToInt(List::size).sum();

    }

    /**
     * Procesa los datos de los empleados que tienen los dnis repetidos,
     * modificándolos
     *
     * @param listaRepeticion Diccionario con los dni repetidos
     */
    public void repararDnisRepetidos(Map<String, List<Empleado>> listaRepeticion){

        // listaRepeticion tiene los empleados con dnis repetidos con la
        // referencia a ellos, por lo que solo es necesario recorrerlos y
        // modificar su dni
        listaRepeticion.values().forEach(empleados ->
                empleados.forEach(Empleado::asignarDniAleatorio));

    }

    /**
     * Comprueba si existe algún correo repetido
     *
     * @return true si hay repetido. False si no lo hay
     */
    public boolean hayCorreosRepetidosArchivo(){

        // Se comprueba si el número de correos que hay diferentes no es igual
        // al número de empleados que hay en listadoArchivo
        /*return listadoArchivo.stream().
                map(Empleado::obtenerCorreo).
                distinct().count() != obtenerNumeroEmpleadosArchivo();*/

        // Se hace uso del método contarCorreosRepetidos() para
        // comprobar si el valor devuelto es mayor que 0
        return  contarCorreosRepetidos() > 0;

    }

    /**
     * Comprueba los datos de los empleados que tienen sus correos repetidos
     *
     * @return Diccionario con el correo y una lista de empleados que tienen el
     *         mismo correo
     */
    public Map<String, List<Empleado>> obtenerCorreosRepetidosArchivo(){

        // Se crea un diccionario con el correo como clave y una lista con los
        // empleados que tienen ese correo como valor
        Map<String, List<Empleado>> employers = listadoArchivo.stream().
                collect(Collectors.groupingBy(Empleado::obtenerCorreo));

        // Se devuelve el diccionario pero solo con aquellas listas que tienen
        // más de 1 empleado con el mismo correo
        return employers.entrySet().stream().
                filter(value -> value.getValue().size() > 1).
                collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

    }

    /**
     * Cuenta el número de empleados que tienen los correos repetidos
     *
     * @return Número de empleados que tienen los correos repetidos
     */
    public int contarCorreosRepetidos(){

        // Se devuelve el número de elementos que tiene cada lista de empleados
        return obtenerCorreosRepetidosArchivo().values().stream().
                mapToInt(List::size).sum();

    }

    /**
     * Corrige todos aquellos correos que están repetidos
     *
     * @param listaRepeticiones Diccionario que contiene los correos que están
     *                          repetidos como clave y la lista con los
     *                          empleados que lo tienen como valor
     */
    public void repararCorreosRepetidos(Map<String, List<Empleado>> listaRepeticiones){

        // listaRepeticion tiene los empleados con correos repetidos con la
        // referencia a ellos, por lo que solo es necesario recorrerlos y
        // modificar su correo
        listaRepeticiones.values().forEach(empleados ->
                empleados.forEach(Empleado::generarCorreoCompleto));

    }

    /**
     * Se almacena la información en el dato miembro listado
     */
    public void validarListaArchivo(){

        // Se guarda en listado una copia de los datos que hay en
        // listadoArchivo en la estructura de diccionario
        listado = listadoArchivo.stream().
                collect(Collectors.toMap(e -> e.obtenerDni(), e -> e));

    }

}
