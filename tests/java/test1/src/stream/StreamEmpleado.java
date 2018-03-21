package stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEmpleado {

    public static void main(String args[]){

        Empleado [] empleados = {
                new Empleado("Juan", "Lopez", 5000, "IT"),
                new Empleado("Antonio", "Garcia", 7000, "IT"),
                new Empleado("Mateo", "Insausti", 3587.5, "Ventas"),
                new Empleado("Joaquin", "Fernandez", 4700.77, "Marketing"),
                new Empleado("Lucas", "Martinez", 6200, "IT"),
                new Empleado("Pedro", "Garcia", 3200, "Ventas"),
                new Empleado("Fernando", "Gonzalez", 4236.4, "Marketing")
        };

        // Crear un predicado para un filtrados posterior para quedarnos con empleados con sueldo superior a 4000 e
        // inferior o igual a 6000
        Predicate<Empleado> condicion = empleado -> empleado.obtenerSueldo() >= 4000 && empleado.obtenerSueldo() <= 6000;

        // Es necesario especificar un comparador si se quiere hacer una ordenación. Se ordenará por sueldo.
        Comparator<Empleado> comparador = Comparator.comparing(Empleado::obtenerSueldo);

        Arrays.stream(empleados).filter(condicion).sorted(comparador).forEach(System.out::println);

        // Obtener primer elemento que cumple una condición
        Empleado first = Arrays.stream(empleados).filter(condicion).sorted(comparador).findFirst().get();
        
        // Referencias funcionales
        Function<Empleado, String> refNombre = Empleado::obtenerNombre;

        Function<Empleado, String> refPrimerApellido = Empleado::obtenerPrimerApellido;

        // Se crea un comparador a partir de las referencias funcionales
        comparador = Comparator.comparing(refPrimerApellido).thenComparing(refNombre);

        // Ordenación de los empleados con el comparador
        Arrays.stream(empleados).sorted(comparador).forEach(System.out::println);

        // Ordenación de los empleados con el mismo comparador pero en orden inverso
        Arrays.stream(empleados).sorted(comparador.reversed()).forEach(System.out::println);

        // Obtener los apellidos pero sin repetidos
        Stream<String> apellidos = Arrays.stream(empleados).map(Empleado::obtenerPrimerApellido);

        // Elimina todos los repetidos
        apellidos.distinct().sorted().forEach(System.out::println);

        // Almacén en lista
        List<String> apellidosSinRepeticiones = Arrays.stream(empleados).map(Empleado::obtenerPrimerApellido).distinct().
                collect(Collectors.toList());

        // Obtención en nombres sin repeticiones y almacenamiento en lista
        List<String> nombres = Arrays.stream(empleados).map(Empleado::obtenerNombre).distinct().sorted().
                collect(Collectors.toList());

        ///////////////////////////////////////////////////////////////////////
        // Agrupamiento por empleado
        //

        // Agrupamiento por empleado
        Map<String, List<Empleado>> mapa = Arrays.stream(empleados).collect(Collectors.groupingBy(Empleado::obtenerDepartamento));

        Stream<Map.Entry<String, List<Empleado>>> flujo = mapa.entrySet().stream();

        // Recorrido de entradas
        flujo.forEach(entrada -> {
            System.out.println(entrada.getKey());
            entrada.getValue().stream().forEach(System.out::println);
        });

        //
        ///////////////////////////////////////////////////////////////////////

        // Implementación de la tarea anterior sin programación funcional
        Map<String, List<Empleado>> agrupamiento = new HashMap<>();

        String departamento;

        List<Empleado> listaEmpleados;

        // Ir considerando cada empleado
        for(int i=0; i<empleados.length; i++){

            //Obtener departamento del empleado
            departamento = empleados[i].obtenerDepartamento();

            // Se comprueba si ya existe esa clave en el mapa
            listaEmpleados = agrupamiento.get(departamento);

            // Tratamiento del empleado en función de si existía la entrada para el departamento o no
            if(listaEmpleados == null){
                listaEmpleados = new LinkedList<>();
                listaEmpleados.add(empleados[i]);

                // Se mete la lista en el mapa
                agrupamiento.put(departamento, listaEmpleados);

            } else{
                listaEmpleados.add(empleados[i]);
            }

        }

        // Se itea sobre la colección agrupamiento
        Iterator<String> claves = agrupamiento.keySet().iterator();

        String clave;

        while(claves.hasNext()){
            // Se obtiene la clave que corresponda
            clave = claves.next();

            System.out.println(clave);

            // Listado completo de empleados asociados a la clave
            listaEmpleados = agrupamiento.get(clave);

            // Se itera sobre la colección
            for(Empleado elementoLista: listaEmpleados){

            }

        }

        // Agrupamiento con funcionalidad completa: se va a indicar el tipo de mapa a crear
        TreeMap<String, Long> contadoresPorDepartamento = Arrays.stream(empleados).collect(Collectors.groupingBy(
                Empleado::obtenerDepartamento, TreeMap::new, Collectors.counting()));

        // Iteración sobre la colección
        contadoresPorDepartamento.entrySet().stream().forEach(entrada -> {
            System.out.printf("departamento %s con %d empleados %n", entrada.getKey(), entrada.getValue());
        });

        // Sumar los sueldos de todos los empleados
        double sumaSueldos = Arrays.stream(empleados).mapToDouble(Empleado::obtenerSueldo).sum();

        // Se obtiene la media de sueldos
        double mediaSueldos = Arrays.stream(empleados).mapToDouble(Empleado::obtenerSueldo).average().getAsDouble();

    }

}
