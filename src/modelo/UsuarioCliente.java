
package modelo;

public class UsuarioCliente extends Usuario {
    
    private int saldo;
    private TipoCliente tipoCliente;
    
    public UsuarioCliente(String cedula, String nombre, int saldo, TipoCliente tipoCliente) {
        super(cedula, nombre);
        this.saldo = saldo;
        this.tipoCliente=tipoCliente;
    }

    //Getters & Setters
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public double calcularCosto(int duracion, int tiempoEspera, int costoFijo) {
        return tipoCliente.calcularCosto(duracion, tiempoEspera, costoFijo);
    }
    
}
