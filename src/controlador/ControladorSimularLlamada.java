package controlador;

import java.util.ArrayList;
import modelo.AgenciaTelefonicaException;
import modelo.Fachada;
import modelo.Llamada;
import modelo.Sector;
import modelo.UsuarioCliente;
import observador.Observable;
import observador.Observador;

public class ControladorSimularLlamada implements Observador {

    /*
    ESTE CONTROLADOR UTILIZA EXCEPCIONES
     */
    private VistaSimularLlamada vista;
    private Llamada llamada;
    private UsuarioCliente cliente;
    private Sector sector;

    private boolean llamadaEnCurso = false;
    private int numeroEspera = 0;

    public ControladorSimularLlamada(VistaSimularLlamada vista) {
        this.vista = vista;
        reinciarCasoDeUso();
    }

    //Eventos del cliente
    public void iniciarProcesoLlamada() {
        if (!llamadaEnCurso) {
            reinciarCasoDeUso();
            this.llamada = new Llamada();
            llamada.agregarObservador(this);
            vista.mostrarMensajeCentralTelefonica("Ingrese su cédula seguida de la tecla numeral");
        }
    }

    public void finalizarProcesoLlamada() {
        if (llamada != null) {
            if (llamadaEnCurso) {
                //Finalizar llamada 
                llamada.finalizarLlamada();
                llamada.quitarObservador(this);
            } else if (llamada.tieneSector()) {
                //Quitar llamada en espera
                llamada.quitarLlamadaEnEspera();
                llamada.quitarObservador(this);
                vista.mostrarMensajeCentralTelefonica("Llamada cancelada con éxito");
            }
            //Finalizo y reinicio el caso de uso
            llamadaEnCurso = false;
            reinciarCasoDeUso();
        }
    }

    public void salir() {
        if(llamadaEnCurso){
            finalizarProcesoLlamada();
        }
        vista.salir();
    }

    //EVENTOS DEL BTN NUMERAL
    public void ejecutarAccion(String txt) {
        //Si la llamada esta en null es porque no se inicializo con el btn
        if (llamada != null && !llamadaEnCurso && numeroEspera == 0) {
            //Se va a ejecutar siempre este metodo
            //Es el boton numeral
            if (cliente == null) {
                /*
                Significa que estoy en el primer caso de uso
                Se accede a la fachada en busca del cliente
                 */
                agregarClienteLlamada(txt);
            } else {
                /*Si paso denuevo y no quedo el cliente en null significa 
              que lo que nos acaba de llegar es el numero del sector que eligio
                 */
                agregarSectorLlamada(txt);
            }
        }
    }

    public void agregarClienteLlamada(String cedula) {
        // 1ER CASO DE USO
        try {
            //Se accede a la fachada en busca del cliente
            UsuarioCliente usu = Fachada.getInstancia().obtenerCliente(cedula);
            this.cliente = usu;
            //Agregar el cliente a la llamada
            llamada.setCliente(cliente);
            //Obtener y listar los sectores
            vista.mostrarMensajeCentralTelefonica(mostrarSectores(Fachada.getInstancia().getSectores()));
        } catch (AgenciaTelefonicaException ex) {
            vista.mostrarMensajeCentralTelefonica(ex.getMessage());
            reinciarCasoDeUso();
        }
    }

    private void agregarSectorLlamada(String numeroSector) {
        // 2DO CASO DE USO
        try {
            //Se accede a la fachada en busca del sector
            Sector s = Fachada.getInstancia().obtenerUnSector(numeroSector);
            this.sector = s;
            asignarLlamada();
        } catch (AgenciaTelefonicaException ex) {
            vista.mostrarMensajeCentralTelefonica(ex.getMessage());
            reinciarCasoDeUso();
        }
    }

    private void asignarLlamada() {
        //Intento agregar la llamada al sector
        try {
            //El sistema inicia la llamada con el primer trabajador libre del sector
            sector.asignarLlamadaPuestoTrabajo(llamada);
        } catch (AgenciaTelefonicaException ex) {
            vista.mostrarMensajeCentralTelefonica(ex.getMessage());
            if (!llamada.tieneTrabajador()) {
                reinciarCasoDeUso();
            }
        }
    }

    //MOSTRAR LA INFORMACION DE LA LLAMADA
    public String mostrarSectores(ArrayList<Sector> sectores) {
        String sectoresFormateados = "Para comunicarse con ";
        for (Sector s : sectores) {
            sectoresFormateados = sectoresFormateados
                    + s.getNombre() + " digite "
                    + s.getNumeroSector() + ", ";
        }
        return sectoresFormateados;
    }

    private void mostrarMsjLlamadaFinalizada() {
        vista.mostrarMensajeCentralTelefonica(
                "Llamada finalizada… <br>Duracion: " + llamada.getDuracion()
                + ". Costo: " + llamada.getCosto().getCostoFinal() + ". Su saldo es de: "
                + cliente.getSaldo()
        );
        vista.reiniciarCasoDeUso();
    }

    private void mostrarMsjLlamadaComenzo() {
        vista.mostrarMensajeCentralTelefonica(
                "Llamada en curso… ud. se está comunicando con el sector " + llamada.getSector().getNombre()
                + ", <br> y está siendo atendido por " + llamada.getUsuarioTrabajador().getNombre()
                + ". <br>Su llamada se ha iniciado en " + llamada.getInicioLlamada() + "."
        );
        vista.iniciaLlamada();
    }

    private void mosrarMsjLlamadaEnEspera() {
        int tiempoEsperaEstimado = sector.calcularTiempoEsperaEstimadoEnMinutos(); //Recibo en minutos
        vista.mostrarMensajeCentralTelefonica(
                "Aguarde en línea, Ud. se encuentra a "
                + numeroEspera + " llamadas de ser atendido, <br>la espera estimada es de "
                + tiempoEsperaEstimado + " minutos"
        );
        vista.iniciaLlamada();
    }

    //REINICIAR CASO
    private void reinciarCasoDeUso() {
        //Me interesa una funcion para poner las clases en null
        this.cliente = null;
        this.llamada = null;
        this.sector = null;

        llamadaEnCurso = false;
        numeroEspera = 0;

        vista.reiniciarCasoDeUso();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        //El controlador cliente tendria que observar a la llamada?
        if (evento.equals(Llamada.eventos.finalizoLlamada)) {
            //La llamada finalizo .. Mostrar mensaje 
            mostrarMsjLlamadaFinalizada();
            llamadaEnCurso = false;
        }
        if (evento.equals(Llamada.eventos.comenzoLlamada)) {
            //Muestro que le atendieron la llamada que estaba en espera
            mostrarMsjLlamadaComenzo();
            llamadaEnCurso = true;
        }
        if (evento.equals(Llamada.eventos.enEspera)
                || evento.equals(Llamada.eventos.actualizaLlamadaEnEspera)) {
            numeroEspera = llamada.getNumeroEspera();
            //Muesto que la llamada esta en espera
            mosrarMsjLlamadaEnEspera();
        }
    }
}
