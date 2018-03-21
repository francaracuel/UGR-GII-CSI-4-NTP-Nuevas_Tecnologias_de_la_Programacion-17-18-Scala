package stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlujoLineas {

    public static void main(String args[]) throws IOException {

        // Cada vez que haya un blanco se piensa que es una palabra diferente
        Pattern patron = Pattern.compile("\\s+");

        Stream<String> lineas = Files.lines(Paths.get("data/alicia.txt"), StandardCharsets.ISO_8859_1);

        // Trabaja con flujo de líneas
        TreeMap<String, Long> contadores = lineas.map(linea -> linea.replaceAll("(?!')\\p{Punct}", "")).
                flatMap(linea -> patron.splitAsStream(linea)).
                filter(palabra -> !palabra.isEmpty()).
                collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

        // Generar ahora colección con inicial - colección de entradas de contadores con esa inicial
        TreeMap<Character, List<Map.Entry<String, Long>>> collect = contadores.entrySet().stream().collect(Collectors.groupingBy(entrada ->
                entrada.getKey().charAt(0), TreeMap::new, Collectors.toList()
        ));

    }

}
