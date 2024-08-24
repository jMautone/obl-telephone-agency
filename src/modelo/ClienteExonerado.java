package modelo;

public class ClienteExonerado extends TipoCliente {

    public ClienteExonerado() {
        super("Cliente exonerado de costo");
    }

    @Override
    public double calcularCosto(int duracion, int tiempoEspera, int costoFijo) {
        return 0;
    }

}
