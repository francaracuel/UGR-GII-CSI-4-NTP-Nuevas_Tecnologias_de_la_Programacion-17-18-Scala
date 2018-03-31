package main;

import listado.ListadoEmpleados;

import java.io.IOException;

public class Main {

    public static void main(String args[]){

        String file = "data/datos.txt";

        try {
            ListadoEmpleados employees = new ListadoEmpleados(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
