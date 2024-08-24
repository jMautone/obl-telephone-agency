
package modelo;

public abstract class TipoCliente {
    
    private String nombre;

    public TipoCliente(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract double calcularCosto(int duracion, int tiempoEspera, int costoFijo);

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //toString
    @Override
    public String toString() {
        return nombre;
    }
}
