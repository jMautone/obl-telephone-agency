package modelo;

public class UsuarioTrabajador extends Usuario {

    private Sector sector;
    private String pwd;

    public UsuarioTrabajador(String cedula, String pwd, String nombre, Sector sector) {
        super(cedula, nombre);
        this.sector = sector;
        this.pwd = pwd;
    }

    //Getters & Setters
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getPwd() {
        return pwd;
    }
    
}
