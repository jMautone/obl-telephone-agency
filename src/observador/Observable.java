
package observador;

import java.util.ArrayList;

public class Observable {
    
    private ArrayList<Observador> observadores = new ArrayList();
    
    public void agregarObservador(Observador obs){
        if(!observadores.contains(obs)){
            observadores.add(obs);
        }
    }
    public void quitarObservador(Observador obs){
        observadores.remove(obs);
    }
    public void avisar(Object evento){
        ArrayList<Observador> copia = new ArrayList(observadores); //clon de la lista
        //Recorro la copia de la lista por si alguno se borra de la lista original durante el for
        for(Observador obs:copia){
            obs.actualizar(evento, this);
        }
    }

    
    
}
