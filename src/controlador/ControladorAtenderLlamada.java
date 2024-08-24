package controlador;

import modelo.Llamada;
import modelo.PuestoTrabajo;
import modelo.Sector;
import modelo.UsuarioCliente;
import modelo.UsuarioTrabajador;
import observador.Observable;
import observador.Observador;

public class ControladorAtenderLlamada implements Observador {

    private PuestoTrabajo puesto;
    private Sector sector;
    private VistaAtenderLlamada vista;
    private UsuarioTrabajador trabajador;

    public ControladorAtenderLlamada(VistaAtenderLlamada vista, PuestoTrabajo puesto) {
        this.vista = vista;
        this.puesto = puesto;
        this.sector = puesto.getSector();
        this.trabajador = puesto.getTrabajador();
        puesto.agregarObservador(this);
        //Busco si le puedo asignar una llamada
        sector.asignarLlamadaEnEspera(puesto); //No me importa si no hay llamadas en espera
        //Eventos de inicializacion
        incializarPuesto();
        actualizarInformacionPuesto();
        preguntarSipuestoTieneLlamada();
    }

    //EVENTOS DE LA LLAMADA
    private void mostrarInformacionNuevaLlamada() {
        UsuarioCliente u = puesto.getLlamada().getCliente();
        vista.mostrarInformacionNuevaLlamada(u.getNombre());
        vista.mostrarMensajeEstadoLlamada("Llamada en curso ... (Inicio: " + puesto.getLlamada().getInicioLlamada() + ")");
    }

    private void mostrarPuestoSinLlamada() {
        vista.mostrarPuestoSinLlamada();
    }

    //INFORMACION DINAMICA
    public void actualizarInformacionPuesto() {
        vista.actualizarInformacionPuesto(puesto.getCantidadLlamadasAtendidas() + "",
                puesto.getTiempoPromedioLlamadasAtendidas() + "");
    }

    public void preguntarSipuestoTieneLlamada() {
        if (puesto.tieneLlamada()) {
            mostrarInformacionNuevaLlamada();
        } else {
            mostrarPuestoSinLlamada();
        }
    }

    //INFORMACION ESTATICA
    private void incializarPuesto() {
        mostrarInformacionTrabajador();
        mostrarInformacionSector();
        mostrarInformacionPuesto();
    }

    public void mostrarInformacionTrabajador() {
        vista.mostrarInformacionTrabajador(trabajador.getNombre());
    }

    public void mostrarInformacionSector() {
        vista.mostrarInformacionSector(sector.getNombre());
    }

    public void mostrarInformacionPuesto() {
        vista.mostrarInformacionPuesto("Puesto Nro. #" + puesto.getNumeroPuesto());
    }

    //EVENTOS DEL TRABAJADOR
    public void finalizarLlamada(String desc) {
        //Me cubro de que se use el boton cuando no hay llamadas asignadas
        //(Aunque se deberia deshabilitar cuando no hay llamadas en curso)
        if (puesto.tieneLlamada()) {
            Llamada l = puesto.getLlamada();
            puesto.finalizarLlamada(desc, true);
            vista.mostrarMsjEmergente("Duracion: "
                    + l.getDuracion() + " segundos. Costo: " + l.getCosto().getCostoFinal());
            vista.finalizarLlamada(); //Por ahora .. vacia el campo descripcion
        }
    }

    public void salir() {
        if (puesto.tieneLlamada()) {
            vista.confirmarSalida();
        } else {
            dejarPuesto();
        }
    }

    public void dejarPuesto() {
        puesto.quitarObservador(this);
        puesto.dejarPuesto();
        vista.salir();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(PuestoTrabajo.eventos.llamadaEnCurso)) {
            //Se le asigna una nueva llamada al puesto de trabajo
            mostrarInformacionNuevaLlamada();
        }
        if (evento.equals(PuestoTrabajo.eventos.llamadaFinalizada)) {
            //Le pido al sector si tiene una nueva llamada en espera 
            vista.mostrarMensajeEstadoLlamada("Llamada finalizada ... ");
            sector.asignarLlamadaEnEspera(puesto); //No me importa si no hay llamadas en espera
        }
        if (!puesto.tieneLlamada()) {
            mostrarPuestoSinLlamada();
        }
        //Se actualiza la informacion
        actualizarInformacionPuesto();
    }
}
