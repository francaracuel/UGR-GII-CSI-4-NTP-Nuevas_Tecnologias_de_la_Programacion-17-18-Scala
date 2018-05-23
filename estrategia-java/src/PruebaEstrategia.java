
interface ComportamientoCambioNivel{
    public default void cambiar(){
        System.out.println("Comportamiento cambio nivel defecto")
    }
}

class CambioNivelNormal implements ComportamientoCambioNivel {}

class CambioNivelCentral implements ComportamientoCambioNivel {
    public void cambiar(){
        System.out.println("Cambio de nivel central");
    }
}

interface ComportamientoSincronizacion{
    // No existe un comportamiento por defecto
    public void sincronizar();
}

class SincronizacionCentral implements ComportamientoSincronizacion{
    public void sincronizar(){
        System.out.println("Sincronización de forma centralizada");
    }
}

class SincronizacionDescentralizada implements ComportamientoSincronizacion{
    public void sincronizar(){
        System.out.println("Sincronización de forma descentralizada");
    }
}

abstract class ControlAcceso{

    protected ComportamientoSincronizacion sincronizador;
    protected ComportamientoCambioNivel gestorNivel;

    public void asignarComportamientoCambioNivel(ComportamientoCambioNivel gestor){
        gestorNivel = gestor;
    }

    public void asignarComportamientoSincronizacion(ComportamientoSincronizacion gestor){
        sincronizador = gestor;
    }

    // La labor de sincronización y cambio de nivel se delega en los datos miembro
    public boolean cambiarNivel(){
        gestorNivel.cambiar();
        return true;
    }

    public boolean sincronizar(){
        sincronizador.sincronizar();
        return true;
    }

    public abstract void mostrarInfo();

}

class ControlAccesoNivelCentral extends ControlAcceso{
    public ControlAccesoNivelCentral(){
        asignarComportamientoCambioNivel(new CambioNivelCentral());
        asignarComportamientoSincronizacion(new SincronizacionCentral());
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Clase con control central...");
    }
}

class ControlAccesoNivelDescentralizado extends ControlAcceso{
    public ControlAccesoNivelDescentralizado(){
        asignarComportamientoCambioNivel(new CambioNivelNormal());
        asignarComportamientoSincronizacion(new SincronizacionDescentralizada());
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Clase con control central...");
    }
}

public class PruebaEstrategia {
    public static void main(String args[]) {
        ControlAcceso control1 = new ControlAccesoNivelCentral();
        ControlAcceso control2 = new ControlAccesoNivelDescentralizado();
        control1.sincronizador.sincronizar();
        control1.gestorNivel.cambiar();
        control1.asignarComportamientoCambioNivel(new CambioNivelNormal());
        control1.gestorNivel.cambiar();
    }
}




















