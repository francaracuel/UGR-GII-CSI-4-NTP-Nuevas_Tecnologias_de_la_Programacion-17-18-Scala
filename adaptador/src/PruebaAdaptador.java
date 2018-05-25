
class Cifrador1{
    public void cifrar(String cadena){
        System.out.println("Cifra con Cifrador1... - " + cadena);
    }
}

class Cifrador2{
    public void ejecutar(String cadena){
        System.out.println("Cifrado con Cifrado2... - " + cadena);
    }
}

interface AdaptadorCifrado{
    public void cifrar(String cadena);
}

class Adaptador1 implements AdaptadorCifrado{
    private Cifrador1 cifrador;

    public Adaptador1(Cifrador1 cifrador){
        this.cifrador = cifrador;
    }

    public void cifrar(String cadena){
        cifrador.cifrar(cadena);
    }
}

class Adaptador2 implements AdaptadorCifrado{
    private Cifrador2 cifrador;

    public Adaptador2(Cifrador2 cifrador){
        this.cifrador = cifrador;
    }

    public void cifrar(String cadena){
        cifrador.ejecutar(cadena);
    }
}

class Cliente{
    private AdaptadorCifrado adaptador;

    public Cliente(AdaptadorCifrado adaptador){
        this.adaptador = adaptador;
    }

    public void realizarCifrado(String cadena){
        adaptador.cifrar(cadena);
    }
}

public class PruebaAdaptador {
    public static void main(String args[]){

        Cifrador1 cifrador1 = new Cifrador1();
        Cifrador2 cifrador2 = new Cifrador2();

        Adaptador1 adaptador1 = new Adaptador1(cifrador1);
        Adaptador2 adaptador2 = new Adaptador2(cifrador2);

        Cliente cliente1 = new Cliente(adaptador1);
        cliente1.realizarCifrado("Hola cifrado1");

        Cliente cliente2 = new Cliente(adaptador2);
        cliente2.realizarCifrado("Hola cifrado2");

    }
}
