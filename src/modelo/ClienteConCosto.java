
package modelo;

public class ClienteConCosto extends TipoCliente {

    public ClienteConCosto() {
        super("Cliente con costo");
    }

    @Override
    public double calcularCosto(int duracion, int tiempoEspera, int costoFijo) {
        double costo = duracion*costoFijo;
        if(tiempoEspera>60){
            //Pagan la mitad del costo fijo
            costo=costo/2;
        }
        return costo;
    }
    
}
