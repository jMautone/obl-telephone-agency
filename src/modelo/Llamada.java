package modelo;

import java.util.Date;
import observador.Observable;

public class Llamada extends Observable {

    //Mi llamada seria mi contacto
    private Date inicioSolicitudLlamada; //Se asigna la fecha en la que se solicito la llamada
    private Date inicioLlamada; //Al atender una llamada se le asigna la fecha de incio
    private Date finLlamada; //Al finalizar una llamada se asigna la fecha de fin

    private String descripcion; //Al finalizar una llamada se asigna una descripcion
    
    private int duracion; //Al finalizar una llamada se asigna una duracion, resultado del calculo de fechas
    private int numeroEspera = 0; //Numero de llamadas que quedan para ser atendido
    private int numeroLlamada; //Numero de llamada que le asigna el sector

    private PuestoTrabajo trabajador; //Al atender una llamada se debe asignar un trabajador
    private Sector sector; //Al iniciar una llamada se asigna un sector
    private UsuarioCliente cliente; //Al iniciar una llamada se asigna un cliente
    private Costo costo; //Al finalizar una llamada se le incluye un costo

    public enum eventos {
        /*
        El cliente observa la llamada, para saber cuando inicia,
        cuando esta en espera y cuando finaliza
         */
        comenzoLlamada,
        finalizoLlamada,
        enEspera,
        actualizaLlamadaEnEspera
    }

    public Llamada() {
        this.inicioSolicitudLlamada = new Date();
    }

    public void iniciarLlamada() {
        this.setInicioLlamada(); //Le asigno la fecha de cuando se comenzo la llamada
        this.costo = new Costo(cliente);
        avisar(eventos.comenzoLlamada);
    }

    public void finalizarLlamada() {
        //Se le asigna una fecha de fin
        this.setFinLlamada();
        //Se calcula la duracion de la llamada
        this.calcularDuracion();
        //Se le agrega los costos
        this.calcularCosto();
        //Actualizo las llamadas en curso del sector
        sector.restarLlamadasEnCurso();
        //El sector avisa que la llamada finalizo
        sector.avisar(Sector.eventos.cambioHistorial);
        //La fachada se entera que una llamada finalizo
        Fachada.getInstancia().avisar(Fachada.eventos.cambioAlgunHistorial);
        //Aviso al cliente que termino la llamada
        avisar(eventos.finalizoLlamada);
    }

    public void calcularDuracion() {
        long milisegundos = finLlamada.getTime() - inicioLlamada.getTime();
        int segundos = (int) (milisegundos / 1000);
        this.duracion = segundos;
    }

    private int calcularTiempoEspera() {
        long milisegundos = inicioLlamada.getTime() - inicioSolicitudLlamada.getTime();
        int segundos = (int) (milisegundos / 1000);
        return segundos;
    }

    public void calcularCosto() {
        //ACORDARSE DE QUE HAY DISTINTOS TIPOS DE CLIENTE
        //El costo fijo es siempre el mismo
        int tiempoEspera = calcularTiempoEspera();
        costo.calcularCosto(duracion, tiempoEspera);
    }
    
    public void actualizarEspera() {
        numeroEspera-=1;
        avisar(eventos.actualizaLlamadaEnEspera);
    }

    public boolean llamadaTieneFin() {
        return finLlamada != null;
    }

    public boolean tieneTrabajador() {
        return trabajador != null;
    }

    public boolean tieneSector() {
        return sector != null;
    }

    public void quitarLlamadaEnEspera() {
        sector.quitarLlamadaEnEspera(this);
    }

    // Getters & Setters
    public Costo getCosto() {
        return costo;
    }

    public void setCosto(Costo costo) {
        this.costo = costo;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Date getInicioLlamada() {
        return inicioLlamada;
    }

    public void setInicioLlamada() {
        this.inicioLlamada = new Date();
    }

    public Date getFinLlamada() {
        return finLlamada;
    }

    public void setFinLlamada() {
        this.finLlamada = new Date();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PuestoTrabajo getTrabajador() {
        return trabajador;
    }

    public UsuarioTrabajador getUsuarioTrabajador() {
        return trabajador.getTrabajador();
    }

    public void setTrabajador(PuestoTrabajo trabajador) {
        this.trabajador = trabajador;
    }

    public UsuarioCliente getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioCliente cliente) {
        this.cliente = cliente;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNumeroEspera() {
        return numeroEspera;
    }

    public void setNumeroEspera(int numeroEspera) {
        this.numeroEspera = numeroEspera;
    }

    public int getNumeroLlamada() {
        return numeroLlamada;
    }

    public void setNumeroLlamada() {
        this.numeroLlamada = sector.getNumeroLlamada();
        this.sector.actualizarNumeroLlamada();
    }
}
