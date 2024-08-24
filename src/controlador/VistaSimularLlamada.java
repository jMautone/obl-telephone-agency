package controlador;

import java.util.ArrayList;
import modelo.Sector;

public interface VistaSimularLlamada {

    //Evento que se va a disparar cuando inicie la llamada
    public void iniciaLlamada();

    public void mostrarMensajeCentralTelefonica(String msg);

    public void reiniciarCasoDeUso();
    
    public void salir();

}
