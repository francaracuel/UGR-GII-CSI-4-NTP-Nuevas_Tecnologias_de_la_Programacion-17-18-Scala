package int_stream;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class OperacionesIntStream {

    private int valores[];

    public OperacionesIntStream(int numeroValores) {

        valores = new int[numeroValores];

        Random generador = new Random();

        for (int i = 0; i < numeroValores; i++) {
            valores[i] = generador.nextInt(101);
        }

    }

    public void mostrarValoresImperativo(){

        for(int i=0; i<valores.length; i++){
            System.out.printf("%d", valores[i]);
        }

        System.out.println();

    }

    public void mostrarValoresFuncional(){

        IntStream flujo = IntStream.of(valores);

        // Definir la operación a realizar
        IntConsumer operacion = valor -> System.out.printf("%d", valor);

        // Se realiza la operación con el flujo
        flujo.forEach(operacion);

        System.out.println();

    }

    public void mostrarValoresFuncional2(){

        IntStream.of(valores).forEach(valor -> System.out.printf("%d", valor));

        System.out.println();

    }

    public void obtenerMinimo(){

        int asInt = IntStream.of(valores).min().getAsInt();

    }

    public int obtenerMaximo(){

        int asInt = IntStream.of(valores).max().getAsInt();

        return asInt;

    }

    public int obtenerSuma(){

        int asInt = IntStream.of(valores).sum();

        return asInt;

    }

    public int obtenerSumaReduce(){

        int suma = IntStream.of(valores).reduce(0, (x, y) -> {
                System.out.println("Valores de x e y: "+x+", "+y);
                return x+y;
        });

        return suma;

    }

    public int obtenerMultiplicacionReduce(){

        int mult = IntStream.of(valores).reduce(1, (x, y) -> {
            System.out.println("Valores de x e y: "+x+", "+y);
            return x*y;
        });

        return mult;

    }

    public double obtenerMultiplicacionAmpliado(){

        double mult = IntStream.of(valores).asDoubleStream().reduce(1, (x, y) -> x*y);

        return mult;

    }

    public double obtenerSumaCuadrado(){

        double mult = IntStream.of(valores).asDoubleStream().reduce(0, (x, y) -> x+(y*y));

        return mult;

    }

    public void filtrarValoresPropios(){

        int[] ints = IntStream.of(valores).filter(valor -> valor%2==0).toArray();

    }

    public void filtrarValoresParesyFiltrar(){

        int[] ints = IntStream.of(valores).filter(valor -> valor % 2 == 0).sorted().toArray();

    }

    // Filtrar pares y mayores que 5
    public void filtarConVariasCondiciones(){

        // Se pueden definir los predicados que interesan
        IntPredicate par = valor -> valor%2 == 0;
        IntPredicate mayor5 = valor -> valor > 5;

        IntStream.of(valores).filter(par.and(mayor5)).sorted().forEach(System.out::println);

    }

    public void convertirColleccion(){

        double[] resultado = IntStream.of(valores).filter(valor -> valor % 2 == 0).mapToDouble(valor -> valor*8.70).
                                                                                                            toArray();

    }

    public static void main(String args[]){

        OperacionesIntStream objeto = new OperacionesIntStream(1000);

        System.out.println(objeto.obtenerMaximo());

        System.out.println(objeto.obtenerMultiplicacionReduce());

    }

}
