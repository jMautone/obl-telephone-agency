package modelo;

import observador.Observable;

public class PuestoTrabajo extends Observable {

    private static int ultNumPuesto = 1;
    private String numeroPuesto;

    private int cantidadLlamadasAtendidas;
    private double tiempoPromedioLlamadasAtendidas;
    private int tiempoAcumulado;

    //El trabajador encargado del puesto
    private UsuarioTrabajador trabajador;
    //El sector a donde pertence el puesto, para que el trabajador sepa a que sector pertenece
    private Sector sector;
    //La llamada asignada al sector
    private Llamada llamada;

    public enum eventos {
        llamadaEnCurso,
        llamadaFinalizada
    }

    public PuestoTrabajo(UsuarioTrabajador trabajador, Sector sector) {
        this.trabajador = trabajador;
        this.sector = sector;
        this.numeroPuesto = ultNumPuesto + "";
        ultNumPuesto++;
    }

    //El trabajador termina su llamada
    public void finalizarLlamada(String desc, boolean actualiza) {
        /*
        desc : la descripcion que llega sobre la llamada finalizada
        actualiza : si es necesario actualizar la informacion del puesto 
        (no es necesario si deja el puesto con una llamada en curso)
         */

        if (desc == "") {
            desc = "No hay descripcion";
        }

        //Validar si ya estaba finalizada por el cliente
        if (!llamada.llamadaTieneFin()) {
            llamada.finalizarLlamada();
        }

        //Le agrego la descripcion
        llamada.setDescripcion(desc); 

        if (actualiza) {
            //Promedio de tiempo
            this.tiempoAcumulado += llamada.getDuracion();
            actualizarPromedioLlamadas();
        }
        
        //Desasignar llamada al puesto
        this.llamada = null;
        //Aviso al puesto que finalizo la llamada
        avisar(eventos.llamadaFinalizada);
    }

    private void actualizarPromedioLlamadas() {
        this.tiempoPromedioLlamadasAtendidas = tiempoAcumulado / cantidadLlamadasAtendidas;
    }

    public boolean estaOcupado() {
        return trabajador != null;
    }

    public void asignarLlamada(Llamada l) {
        //Le asigno un numero a la llamada
        l.setNumeroLlamada();
        //No podria llegar en null
        l.setTrabajador(this); //Le asigno trabajador
        l.iniciarLlamada();
        //Cantidad llamadas atendidas
        cantidadLlamadasAtendidas++;
        //Asignar llamada al historial del sector (recien cuando es asignada a un puesto)
        sector.agregarLlamadaAlHistorial(l);
        //Asignar una nueva llamada en curso
        sector.sumarLlamadasEnCurso();
        this.llamada = l;
        //Se activa evento de puesto con llamada
        avisar(eventos.llamadaEnCurso);
        //return llamada; //Devuelo la llamada para saber a quien se le asigno
    }

    public boolean tieneLlamada() {
        return llamada != null;
    }

    public void dejarPuesto() {
        if (tieneLlamada()) {
            finalizarLlamada("No hay descripcion", false);
        }
        this.trabajador = null;
        this.cantidadLlamadasAtendidas = 0;
        this.tiempoPromedioLlamadasAtendidas = 0;
        this.tiempoAcumulado = 0;
    }

    // Getters & Setters
    public Llamada getLlamada() {
        return llamada;
    }

    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }

    public String getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(String numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    public int getCantidadLlamadasAtendidas() {
        return cantidadLlamadasAtendidas;
    }

    public void setCantidadLlamadasAtendidas(int cantidadLlamadasAtendidas) {
        this.cantidadLlamadasAtendidas = cantidadLlamadasAtendidas;
    }

    public double getTiempoPromedioLlamadasAtendidas() {
        return tiempoPromedioLlamadasAtendidas;
    }

    public UsuarioTrabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(UsuarioTrabajador trabajador) {
        //Para cuando inicia sesion en el puesto busca si tiene una llamada que le sirva
        //Si encuentra se la asigna y se activa el evento de nuevaLlamada
        this.trabajador = trabajador;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    @Override
    public String toString() {
        return "PuestoTrabajo{" + "numeroPuesto=" + numeroPuesto + ", cantidadLlamadasAtendidas=" + cantidadLlamadasAtendidas + ", tiempoPromedioLlamadasAtendidas=" + tiempoPromedioLlamadasAtendidas + ", tiempoAcumulado=" + tiempoAcumulado + ", trabajador=" + trabajador + ", sector=" + sector + ", llamada=" + llamada + '}';
    }

    
}
