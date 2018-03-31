
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import listado.ListadoEmpleados;
import org.junit.runners.MethodSorters;

import java.io.IOException;

/**
 * Práctica 1 NTP
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListadoTestP1 {
   private static ListadoEmpleados listado;

   /**
    * Codigo a ejecutar antes de realizar las llamadas a los métodos
    * de la clase; incluso antes de la propia instanciación de la
    * clase. Por eso el método debe ser estatico
    */
   @BeforeClass
   public static void inicializacion() {
      System.out.println("Metodo inicializacion conjunto pruebas");
      // Se genera el listado de empleados
      try {
         listado = new ListadoEmpleados("./data/datos.txt");
      } catch (IOException e) {
         System.out.println("Error en lectura de archivo de datos");
      };
   }

   /**
    * Test para comprobar que se ha leido de forma correcta la
    * informacion de los empleados
    *
    * @throws Exception
    */
   @Test
   public void test1ConstruccionListado() throws Exception {
      assert (listado.obtenerNumeroEmpleadosArchivo() == 5000);
   }

   /**
    * Test para comprobar la deteccion de dnis repetidos
    */
   @Test
   public void test2ComprobarHayDnisRepetidos() {
      assert (listado.hayDnisRepetidosArchivo() == true);
   }

   /**
    * Test para comprobar el numero de empleados con correos
    * repetidos
    */
   @Test
   public void test3ComprobarContadoresDnisRepetidosArchivo() {

      assert (listado.contarEmpleadosDnisRepetidos() == 4);

      // Se reparan los dnis repetidos
      listado.repararDnisRepetidos(listado.obtenerDnisRepetidosArchivo());

   }

    ///////////////////////////////////////////////////////////////////////////
    // Mis tests
    //

   /**
    * Test para comprobar que no existen dnis repetidos
    */
    @Test
    public void test4CheckRepeatedDnisFixed() {
        assert (listado.contarEmpleadosDnisRepetidos() == 0);
    }

    /**
     * Test para comprobar la detección de correos repetidos
     */
    @Test
    public void test5CheckRepeatedMails() {
        assert (listado.hayCorreosRepetidosArchivo() == true);
    }

    /**
     * Test para comprobar el numero de empleados con correos
     * repetidos
     */
    @Test
    public void test6CheckCounterRepeatedMails() {

        assert (listado.contarCorreosRepetidos() == 315);

        // Se reparan los correos repetidos
        listado.repararCorreosRepetidos(listado.obtenerCorreosRepetidosArchivo());

    }

    /**
     * Test para comprobar que no existen dnis repetidos
     */
    @Test
    public void test7CheckRepeatedMailsFixed() {
        assert (listado.contarCorreosRepetidos() == 0);
    }

    /**
     * Se almacena la información en listado
     */
    @AfterClass
    public static void validarListaArchivo() {

        System.out.println("\nDatos validados correctamente");
        System.out.println("\nComienza el volcado de los datos...\n");

        listado.validarListaArchivo();

        System.out.println(listado.toString());

        System.out.println("\nVolcado de datos completado...\n");

    }

    //
    ///////////////////////////////////////////////////////////////////////////

}