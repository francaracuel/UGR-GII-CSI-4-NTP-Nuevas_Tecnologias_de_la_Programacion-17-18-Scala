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
import java.util.*;
import java.util.function.Predicate;
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
     * Patrón utilizado para separar cadenas con espacios en blanco
     */
    private static Pattern patronEspacios = Pattern.compile("\\s+");

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

            Stream<String> lines = Files.lines(Paths.get(file),
                    StandardCharsets.ISO_8859_1);

            // Se guardan todos los empleados en listadoArchivo
            listadoArchivo = lines.map(line -> crearEmpleado(line)).
                    collect(Collectors.toList());

        //} catch (IOException e) {
            //e.printStackTrace();
        //}

    }

    ///////////////////////////////////////////////////////////////////////////
    // Primera parte
    //

    /**
     * Crea un empleado en base a una línea del fichero de datos y lo devuelve
     *
     * @param line Línea con los datos de un empleado separados por comas
     * @return Objeto empleado con los datos de "line"
     */
    private Empleado crearEmpleado(String line){

        // Se separarán los datos con un patrón que busca las comas
        List<String> employee = Pattern.compile(",+").
                splitAsStream(line).
                collect(Collectors.toList());

        // Se devuelve el empleado enviando los parámetros correspondientes que
        // necesita en el constructor
        return new Empleado(employee.get(0).replaceAll("\\s+",""),
                employee.get(1).replaceAll("\\s+",""),
                employee.get(2).replaceAll("\\s+",""),
                employee.get(3).replaceAll("\\s+",""));

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
        Map<String, List<Empleado>> employees = listadoArchivo.stream().
                        collect(Collectors.groupingBy(Empleado::obtenerDni));

        // Se devuelve el diccionario pero solo con aquellas listas que tienen
        // más de 1 empleado con el mismo dni
        return employees.entrySet().stream().
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
        Map<String, List<Empleado>> employees = listadoArchivo.stream().
                collect(Collectors.groupingBy(Empleado::obtenerCorreo));

        // Se devuelve el diccionario pero solo con aquellas listas que tienen
        // más de 1 empleado con el mismo correo
        return employees.entrySet().stream().
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

    //
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Segunda parte
    //

    /**
     * Procesan la información de los sectores de los empleados
     *
     * @param file Nombre de fichero que contiene los sectores
     * @return Número de errores obtenidos en la asignación
     */
    public long cargarArchivoAsignacionSector(String file) throws IOException{

        // Se lee el fichero con los sectores
        List<String> lines = Files.lines(Paths.get(file)).
                                            collect(Collectors.toList());

        // Se obtiene el nombre del sector que se está leyendo
        Sector sector = procesarNombreSector(lines.get(0));

        // Se devuelve el número de errores que existen al procesar el fichero
        return lines.stream().skip(2).
                map(line -> procesarAsignacionSector(sector, line)).
                filter(flag -> flag == false).count();

    }

    /**
     * Convierte la cadena en el tipo Sector
     *
     * @param name Nombre del sector
     * @return Nombre del sector en su tipo correspondiente
     */
    private Sector procesarNombreSector(String name){

        // Se separa la cadena que se recibe utilizando el patrón de los
        // espacios. Como solo hay un elemento, el valor está en la posición 0
        List<String> infos = patronEspacios.splitAsStream(name).
                                            collect(Collectors.toList());

        // Se crea la condición que permite filtrar todos los elementos del
        // enumerado
        Predicate<Sector> condicion = sector -> (sector.name().
                                                    equals(infos.get(0)));

        // Se devuelve el resultado del filtrado
        return Arrays.stream(Sector.values()).
                                filter(condicion).
                                findFirst().
                                get();

    }

    /**
     * Método auxiliar encargado de procesar el contenido de cada línea del
     * fichero de los sectores
     *
     * @param sector Sector al que pertenece el empleado que se recibe
     * @param line Línea que contiene el dni del empleado
     * @return True si el dni se encuentra en el listado. False si no se
     *         encuentra el dni.
     */
    private boolean procesarAsignacionSector(Sector sector, String line){

        // Se comienza pensando que no va a asignar un sector
        boolean seted = false;

        // Se extraen los datos que se reciben en la línea
        List<String> infos = patronEspacios.splitAsStream(line).
                                            collect(Collectors.toList());

        // Se obtiene el empleado que corresponde con el dni recibido
        Empleado empleado = listado.get(infos.get(0));

        // Si el dni existe se le asigna el sector y se indica que es válido
        if(empleado != null){
            empleado.asignarSector(sector);
            seted = true;
        }

        return seted;

    }

    /**
     * Procesan la información de las rutas de los empleados
     *
     * @param file Nombre de fichero que contiene las rutas
     * @return Número de errores obtenidos en la asignación
     */
    public long cargarArchivoAsignacionRuta(String file) throws IOException{

        // Se lee el fichero con las rutas
        List<String> lines = Files.lines(Paths.get(file)).
                collect(Collectors.toList());

        // Se obtiene el nombre de la ruta que se está leyendo
        Ruta ruta = procesarNombreRuta(lines.get(0));

        // Se devuelve el número de errores que existen al procesar el fichero
        return lines.stream().skip(2).
                map(line -> procesarAsignacionRuta(ruta, line)).
                filter(flag -> flag == false).count();

    }


    /**
     * Convierte la cadena en el tipo Ruta
     *
     * @param name Nombre de la ruta
     * @return Nombre de la ruta en su tipo correspondiente
     */
    private Ruta procesarNombreRuta(String name){

        // Se separa la cadena que se recibe utilizando el patrón de los
        // espacios. Como solo hay un elemento, el valor está en la posición 0
        List<String> infos = patronEspacios.splitAsStream(name).
                collect(Collectors.toList());

        // Se crea la condición que permite filtrar todos los elementos del
        // enumerado
        Predicate<Ruta> condicion = ruta -> (ruta.name().
                equals(infos.get(0)));

        // Se devuelve el resultado del filtrado
        return Arrays.stream(Ruta.values()).
                filter(condicion).
                findFirst().
                get();

    }

    /**
     * Método auxiliar encargado de procesar el contenido de cada línea del
     * fichero de las rutas
     *
     * @param ruta Ruta al que pertenece el empleado que se recibe
     * @param line Línea que contiene el dni del empleado
     * @return True si el dni se encuentra en el listado. False si no se
     *         encuentra el dni.
     */
    private boolean procesarAsignacionRuta(Ruta ruta, String line){

        // Se comienza pensando que no va a asignar una ruta
        boolean seted = false;

        // Se extraen los datos que se reciben en la línea
        List<String> infos = patronEspacios.splitAsStream(line).
                collect(Collectors.toList());

        // Se obtiene el empleado que corresponde con el dni recibido
        Empleado empleado = listado.get(infos.get(0));

        // Si el dni existe se le asigna la ruta y se indica que es válido
        if(empleado != null){
            empleado.asignarRuta(ruta);
            seted = true;
        }

        return seted;

    }

    /**
     * Permite obtener los contadores de empleados asignados a cada sector y
     * ruta
     *
     * @return Diccionario con los distintos sectores que hay y las rutas y
     *         empleados que las realizan
     */
    public Map<Sector, Map<Ruta, Long>> obtenerContadoresSectorRuta(){

        // Se devuelve un diccionario poniendo como clave cada elemento del
        // enumerado de los sectores y como valor el diccionario que
        // devuelve el método obtenerContadoresRuta().
        // TreeMap permite ordenar alfabéticamente las claves
        return new TreeMap<>(Arrays.stream(Sector.values()).
                collect(Collectors.
                        toMap(sector -> sector,
                                sector -> obtenerContadoresRuta(sector))));

    }

    /**
     * Comprueba los empleados que pertenecen a cada ruta de un sector
     *
     * @param sector Sector sobre el que se quiere obtener la información
     * @return Diccionario con las distintas rutas que hay y el número de
     *         empleados que tiene cada una
     */
    public Map<Ruta, Long> obtenerContadoresRuta(Sector sector){

        // Se devuelve un diccionario con las rutas como clave y el número
        // de empleados que pertenecen a cada una, perteneciendo al sector
        // que se recibe. Para eso, se convierte primero el diccionario
        // "listado" a lista, se filtran solo los empleados que tienen
        // asignado el sector recibido, se crea un diccionario agrupando
        // los empleados por ruta y poniendo como valor el tamaño de la lista
        // de los empleados que pertenecen a cada ruta.
        // TreeMap permite ordenar alfabéticamente las claves
        return new TreeMap<>(listado.values().stream().
                filter(e -> e.obtenerSector() == sector).
                collect(Collectors.groupingBy(Empleado::obtenerRuta)).
                entrySet().stream().
                collect(Collectors.toMap(e -> e.getKey(),
                                        e -> (long)e.getValue().size())));

    }

    /**
     * Comprueba los empleados que pertenecen a cada sector
     *
     * @return Diccionario con el sector como clave y con el número de
     *         empleados que pertenecen a cada sector como valor
     */
    public Map<Sector, Long> obtenerContadoresSectores(){

        // Basándose en obtenerContadoresSectorRuta(), se crea un
        // diccionario que tendrá como clave el sector, tal y como devuelve
        // la función y tendrá como valor la suma de todos los empleados que
        // tienen asignadas las rutas de ese sector.
        // TreeMap permite ordenar alfabéticamente las claves
        return new TreeMap<>(obtenerContadoresSectorRuta().entrySet().stream().
                collect(Collectors.toMap(e -> e.getKey(),
                                        e -> e.getValue().values().stream().
                                                mapToLong(Long::longValue).
                                                sum())));

    }

    /**
     * Busca los empleados que no tienen asignados ni sectores ni rutas
     *
     * @return Lista con los empleados que no tienen nada asignado
     */
    public List<Empleado> buscarEmpleadosSinSectorSinRuta(){

        // Se filtran todos los empleados que no tienen ningún sector ni ruta
        // asignados
        return listado.values().stream().
            filter(e -> (e.obtenerSector() == Sector.NOSECTOR) &&
                        (e.obtenerRuta() == Ruta.NORUTA)).
            collect(Collectors.toList());

    }

    /**
     * Busca los empleados que no tienen ruta, teniendo asignado el sector
     * que se recibe
     *
     * @param sector Sector al que tienen que pertenecer los empleados
     * @return Lista con los empleados que no tienen ruta pero sí el sector
     *         recibido
     */
    public List<Empleado> buscarEmpleadosSinRuta(Sector sector){

        // Se filtran todos los empleados que tienen el sector que se recibe
        // asignado pero ninguna ruta
        return listado.values().stream().
            filter(e -> (e.obtenerSector() == sector) &&
                        (e.obtenerRuta() == Ruta.NORUTA)).
            collect(Collectors.toList());

    }

    /**
     * Busca los empleados que tienen asignado un sector pero no una ruta
     *
     * @return Lista con los empleados que tienen sector pero no ruta asignada
     */
    public List<Empleado> buscarEmpleadosConSectorSinRuta(){

        // Se devuelve una lista con todos los empleados que tienen algún
        // sector asignado utilizando el método anterior y concatenando todos
        // ellos en una sola lista
        return Arrays.stream(Sector.values()).
                filter(sector -> sector != Sector.NOSECTOR).
                map(sector -> buscarEmpleadosSinRuta(sector)).
                flatMap(List::stream).
                collect(Collectors.toList());

    }

    /**
     * Busca los empleados que no tienen sector, teniendo asignada la ruta
     * que se recibe
     *
     * @param ruta Ruta a la que tienen que pertenecer los empleados
     * @return Lista con los empleados que no tienen sector pero sí la ruta
     *         recibida
     */
    public List<Empleado> buscarEmpleadosSinSector(Ruta ruta){

        // Se filtran todos los empleados que tienen la ruta que se recibe
        // asignada pero ningún sector
        return listado.values().stream().
                filter(e -> (e.obtenerRuta() == ruta) &&
                            (e.obtenerSector() == Sector.NOSECTOR)).
                collect(Collectors.toList());

    }

    /**
     * Busca los empleados que tienen asignado una ruta pero no un sector
     * @return Lista con los empleados que tienen ruta pero no sector asignado
     */
    public List<Empleado> buscarEmpleadosSinSectorConRuta(){

        // Se devuelve una lista con todos los empleados que tienen alguna
        // ruta asignada utilizando el método anterior y concatenando todos
        // ellos en una sola lista
        return Arrays.stream(Ruta.values()).
                filter(ruta -> ruta != Ruta.NORUTA).
                map(ruta -> buscarEmpleadosSinSector(ruta)).
                flatMap(List::stream).
                collect(Collectors.toList());

    }

    //
    ///////////////////////////////////////////////////////////////////////////

}
