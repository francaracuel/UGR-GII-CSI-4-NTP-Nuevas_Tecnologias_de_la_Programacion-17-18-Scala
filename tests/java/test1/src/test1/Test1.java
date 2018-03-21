package test1;

import java.util.function.*;

public class Test1{

    public static void main(String args[]){

        IntBinaryOperator operador = (int x, int y) -> {return x+y;};

        System.out.println("Resultado1: " + operador.applyAsInt(3,2));

        DoubleBinaryOperator operador2 = (double x, double y) -> {return x*y;};

        double resultado = operador2.applyAsDouble(3.8, 7);

        Consumer<Integer> operador3 = valor -> System.out.println("Valor");

        Runnable oper = () -> System.out.println("·sdfsa");

        oper.run();


    }

}
