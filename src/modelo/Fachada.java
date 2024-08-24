package modelo;

import java.util.ArrayList;
import observador.Observable;

public class Fachada extends Observable{

    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaTrabajo sTrabajo = new SistemaTrabajo();

    private static Fachada instancia = new Fachada();
    
    public enum eventos {
        //Eventos para el sector
        cambioAlgunHistorial
    }
    
    public static Fachada getInstancia() {
        return instancia;
    }

    public Fachada() {
    }

//    *** DELEGACIONES ***
//    ***Sistema ACCESO*** 
    public void agregarUsuarioCliente(UsuarioCliente u) {
        sAcceso.addUsuarioCliente(u);
    }

    public void agregarUsuarioTrabajador(UsuarioTrabajador u) {
        sAcceso.addUsuarioTrabajador(u);
    }

    public UsuarioTrabajador loginUsuarioTrabajador(String ced, String pwd) throws AgenciaTelefonicaException{
        return sAcceso.loginUsuarioTrabajador(ced, pwd);
    }

    public UsuarioCliente obtenerCliente(String ced) throws AgenciaTelefonicaException {
        return sAcceso.obtenerCliente(ced);
    }

    // Sistema TRABAJO //
    public Sector obtenerUnSector(String numeroSector) throws AgenciaTelefonicaException {
        return sTrabajo.obtenerUnSector(numeroSector);
    }

    public ArrayList<Sector> getSectores() {
        return sTrabajo.getSectores();
    }

    public void agregarSector(Sector s) {
        sTrabajo.agregarSector(s);
    }

    public PuestoTrabajo asignarTrabajadorPuestoTrabajo(UsuarioTrabajador ut) throws AgenciaTelefonicaException {
        return sTrabajo.asignarTrabajadorPuestoTrabajo(ut);
    }

    public ArrayList<Llamada> obtenerLasLlamadasDeTodosLosSectores() {
        return sTrabajo.obtenerLasLlamadasDeTodosLosSectores();
    }

}
