package modelo;

import java.util.ArrayList;
import observador.Observable;

public class Sector extends Observable {

    private String nombre;
    private String numeroSector;
    private int cantidadPuestosTrabajo;

    private int cantMaxLlamadas; //La max cantidad de llamadasa que soporta el sistema
    private int cantLlamadasEnCurso; //La cantidad de llamadas que hay en curso
    private int numeroLlamada = 1;

    private ArrayList<PuestoTrabajo> puestos = new ArrayList<>();
    private ArrayList<Llamada> llamadas = new ArrayList<>(); //llamadas en espera
    private ArrayList<Llamada> historial = new ArrayList<>(); //Historial de llamadas

    public enum eventos {
        //Eventos para el sector
        cambioHistorial
    }

    public Sector(String nombre, String numeroSector, int cantidadPuestosTrabajo,
            int cantMaxLlamadas) {
        this.nombre = nombre;
        this.numeroSector = numeroSector;
        this.cantidadPuestosTrabajo = cantidadPuestosTrabajo;
        this.cantMaxLlamadas = cantMaxLlamadas;
        incializarPuestoDeTrabajo();
    }

    private void incializarPuestoDeTrabajo() {
        for (int i = 0; i < cantidadPuestosTrabajo; i++) {
            PuestoTrabajo p = new PuestoTrabajo(null, this);
            puestos.add(p);
        }
    }

    //Llamadas en espera
    public boolean agregarLlamadaEnEspera(Llamada l) {
        llamadas.add(l);
        return true;
    }

    public void quitarLlamadaEnEspera(Llamada l) {
        llamadas.remove(l);
    }

    public void asignarLlamadaEnEspera(PuestoTrabajo p) {
        /*
        Podria activarse el evento de llamada finalizada cuando el trabajador deja el puesto
        por lo que no me interesa asignarle otra llamada
         */
        if (p.estaOcupado()) {
            //Veo si hay llamadas en espera
            Llamada l = obtenerPrimeraLlamadaEnEspera();
            if (l != null) {
                //Le asigno la llamada
                p.asignarLlamada(l);
                //Acutalizo la lista de llamadas en espera
                quitarPrimeraLlamadaEnEspera();
                //
                actualizarEsperaDeLlamadas();
            }
            //Sino me voy porque no tiene llamadas en espera
        }
    }

    private void actualizarEsperaDeLlamadas() {
        for (Llamada l : llamadas) {
            //Se actualizan todas las llamadas que estaban en espera
            l.actualizarEspera();
        }
    }

    private Llamada obtenerPrimeraLlamadaEnEspera() {
        if (!llamadas.isEmpty()) {
            return llamadas.get(0); //Obtengo la llamada con mas tiempo en espera
        }
        return null;
    }

    private void quitarPrimeraLlamadaEnEspera() {
        if (!llamadas.isEmpty()) {
            llamadas.remove(0); //Remuevo la primera llamada en espera
        }
    }

    //Historial de llamadas
    public void agregarLlamadaAlHistorial(Llamada l) {
        historial.add(l);
        avisar(eventos.cambioHistorial);
        Fachada.getInstancia().avisar(Fachada.eventos.cambioAlgunHistorial);
    }

    //Puestos de trabajo 
    public void asignarLlamadaPuestoTrabajo(Llamada l) throws AgenciaTelefonicaException {
        //Agregar el sector a la llamada
        l.setSector(this);
        //Maximo de llamadas en curso
        if (cantLlamadasEnCurso == cantMaxLlamadas) {
            throw new AgenciaTelefonicaException("Comuníquese más tarde…");
        }
        //Verifico que hayan trabajadores trabajando
        if (!hayPuestoConTrabajador()) {
            throw new AgenciaTelefonicaException("Sector no disponible");
        }
        //Busco el primer trabajador libre y verifico si todos los trabajadores del sector estan ocupados
        PuestoTrabajo p = devolverPuestoInactivo();
        if (p == null) {
            //Si quedo en null es porque estan todos ocupados y tengo que calcular el tiempo de espera
            //Pero primero tengo que calcular si la cant de llamadas  en espera iguala al maximo de llamadas que soporta el sistema
            if (llamadas.size() == cantMaxLlamadas) {
                throw new AgenciaTelefonicaException("Comuníquese más tarde…");
            }
            //Si paso es porque se puede poner la llamada en espera
            llamadas.add(l);
            l.setNumeroEspera(getCantidadLlamadasEnEspera());
            l.avisar(Llamada.eventos.enEspera);
        } else {
            //Si encontro puesto inactivo le asigno la llamada
            //Le asigno la llamada 
            p.asignarLlamada(l);
        }
    }

    public PuestoTrabajo asignarTrabajadorPuestoTrabajo(UsuarioTrabajador ut) throws AgenciaTelefonicaException {
        for (PuestoTrabajo p : puestos) {
            if (!p.estaOcupado()) {
                //Ingreso un nuevo trabajador
                p.setTrabajador(ut);
                return p; //Retorno el puesto
            }
        }
        //Si paso por el for y no encotro puestos disponibles retorno excepcion
        throw new AgenciaTelefonicaException("No hay puestos disponibles");
    }

    public PuestoTrabajo devolverPuestoInactivo() {
        for (PuestoTrabajo p : puestos) {
            //si encuentro un puesto sin llamada lo devuelvo
            if (!p.tieneLlamada() && p.estaOcupado()) {
                return p;
            }
        }
        return null;
    }

    private boolean hayPuestoConTrabajador() {
        for (PuestoTrabajo p : puestos) {
            //si encuentro un puesto sin llamada lo devuelvo
            if (p.estaOcupado()) {
                return true;
            }
        }
        return false;
    }

    public int calcularTiempoEsperaEstimadoEnMinutos() {
        double tiempoPromedioDeAtencion = 0;
        for (PuestoTrabajo p : puestos) {
            tiempoPromedioDeAtencion += p.getTiempoPromedioLlamadasAtendidas(); //Se acumula en segundos
        }
        //Obtengo la cantidad de puestos ocupados del sector
        int cantPuestosOcupados = obtenerCantDePuestosOcupados();
        //El promedio de los tiempos promedio de atencion de cada puesto de trabajo
        tiempoPromedioDeAtencion = tiempoPromedioDeAtencion / cantPuestosOcupados;
        //La espera estimada en segundos
        tiempoPromedioDeAtencion = tiempoPromedioDeAtencion * llamadas.size();
        //Lo paso a minutos
        tiempoPromedioDeAtencion = Math.floor(tiempoPromedioDeAtencion / 60);
        return (int) tiempoPromedioDeAtencion;
    }

    private int obtenerCantDePuestosOcupados() {
        int cantPuestosOcupados = 0;
        for (PuestoTrabajo p : puestos) {
            if (p.estaOcupado()) {
                cantPuestosOcupados++;
            }
        }
        return cantPuestosOcupados;
    }

    public void sumarLlamadasEnCurso() {
        cantLlamadasEnCurso++;
    }

    public void restarLlamadasEnCurso() {
        cantLlamadasEnCurso--;
    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroSector() {
        return numeroSector;
    }

    public void setNumeroSector(String numeroSector) {
        this.numeroSector = numeroSector;
    }

    public int getCantidadPuestosTrabajo() {
        return cantidadPuestosTrabajo;
    }

    public void setCantidadPuestosTrabajo(int cantidadPuestosTrabajo) {
        this.cantidadPuestosTrabajo = cantidadPuestosTrabajo;
    }

    public int getCantidadLlamadasEnEspera() {
        return llamadas.size();
    }

    public ArrayList<Llamada> getHistorial() {
        return historial;
    }

    public int getNumeroLlamada() {
        return numeroLlamada;
    }

    public void actualizarNumeroLlamada() {
        numeroLlamada++;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
