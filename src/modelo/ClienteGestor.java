package modelo;

public class ClienteGestor extends TipoCliente {

    public ClienteGestor() {
        super("Cliente gestor");
    }

    @Override
    public double calcularCosto(int duracion, int tiempoEspera, int costoFijo) {
        double costo = duracion * costoFijo;
        costo = costo - (tiempoEspera * costoFijo);
        if (costo < 0) {
            costo = 0; //El costo no puede quedar en negativo
        }
        return costo;
    }

}
