package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamString {

    public static void main(String args[]){

        String [] cadenas = {"Rojo", "Naranaja", "Amarillo", "Verde", "azul", "indigo", "Violeta"};

        Arrays.stream(cadenas).map(cadena -> cadena.toUpperCase());

        // Otra opción
        List<String> lista = Arrays.stream(cadenas).map(String::toUpperCase).collect(Collectors.toList());

        // Filtrar para quedarnos con las cadenas por encima de m, ordenación y recoger sobre lista
        List<String> lista2 = Arrays.stream(cadenas).filter(cadena -> cadena.compareToIgnoreCase("m") > 0).
                sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());

        System.out.println(lista2);

    }

}
