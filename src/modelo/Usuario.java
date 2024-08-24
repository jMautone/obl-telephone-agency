
package modelo;

public abstract class Usuario {
    
    private String cedula;
    private String nombre;

    public Usuario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }
    
}
