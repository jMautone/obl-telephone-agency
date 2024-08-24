
package modelo;


public class Costo {
    //Esta clase existe para solucionar problemas en el caso que la llamada pueda tener varios costos
    //Mi costo es mi llamada en el caso de uso de agenda
    private static int costoFijo=1; 
    private double costoFinal; //El costo que se calcula al final de una llamada
    private UsuarioCliente cliente; //El cliente al que se le va a asignar el costo

    public Costo(UsuarioCliente cliente) {
        this.cliente = cliente;
    }
    
    public void calcularCosto(int duracion, int tiempoEspera) {
        double costoCalculado = cliente.calcularCosto(duracion, tiempoEspera, costoFijo);
        this.costoFinal=costoCalculado; //Minimo costo = 0
    }
    
    ////////////////////////////////
    public static int getCostoFijo() {
        return costoFijo;
    }

    public static void setCostoFijo(int costoFijo) {
        Costo.costoFijo = costoFijo;
    }

    public UsuarioCliente getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioCliente cliente) {
        this.cliente = cliente;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }
}
