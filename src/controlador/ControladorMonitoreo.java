package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.Fachada;
import modelo.Llamada;
import modelo.Sector;
import observador.Observable;
import observador.Observador;

public class ControladorMonitoreo implements Observador {

    private VistaMonitoreo vista;
    private Sector sector;
    ArrayList<Sector> sectores = new ArrayList();

    public ControladorMonitoreo(VistaMonitoreo vista) {
        this.vista = vista;
        //Muestro los sectores al iniciar
        obtenerSectores();
    }

    public void obtenerSectores() {
        ArrayList<Sector> s = Fachada.getInstancia().getSectores();
        this.sectores = s; //Guardo los sectores
        listarSectores();
    }

    private void listarSectores() {
        //Formateo los sectores con una opcion para listar todos los sectores
        ArrayList<String> sectoresFormateados = new ArrayList();
        sectoresFormateados.add("<Todos los sectores>");
        for (Sector s : sectores) {
            sectoresFormateados.add(
                    s.getNombre()
            );
        }
        vista.mostrarSectores(sectoresFormateados);
    }

    public void elegirSector(int s) {
        //Si es la pos 0 son todos
        Fachada.getInstancia().quitarObservador(this);
        if (s == 0) {
            //Si eligio la opcion 0 son todos los sectores
            obtenerLasLlamadasDeTodosLosSectores();
            Fachada.getInstancia().agregarObservador(this);
        } else {
            //Sino le resto 1 para no salirme del index
            Sector secSelec = sectores.get(s - 1); //Obtengo el sector
            if (sector == null) {
                this.sector = secSelec;
            } else {
                sector.quitarObservador(this);
                this.sector = secSelec;
            }
            sector.agregarObservador(this);
            obtenerLlamadasDeUnSector();
        }
    }

    public void obtenerLlamadasDeUnSector() {
        ArrayList<Llamada> llamadas = sector.getHistorial();
        listarLlamadasSector(llamadas);
    }

    public void obtenerLasLlamadasDeTodosLosSectores() {
        ArrayList<Llamada> todasLasLlamadas = Fachada.getInstancia().obtenerLasLlamadasDeTodosLosSectores();
        listarLlamadasTodosLosSectores(todasLasLlamadas);
    }

    public void listarLlamadasSector(ArrayList<Llamada> llamadas) {
        ArrayList<String> llamadasFormateadas = new ArrayList();
        if (!llamadas.isEmpty()) {
            for (Llamada l : llamadas) {
                llamadasFormateadas.add(
                        "Llamada num: #" + l.getNumeroLlamada() + " | Estado: "
                        + estadoLlamada(l) + " | Fecha inicio: " + l.getInicioLlamada() + " | Fecha fin: "
                        + mostrarFechaFin(l.getFinLlamada()) + " | Puesto num: #" + l.getTrabajador().getNumeroPuesto() + " | Duracion: "
                        + l.getDuracion() + " | Costo: " + mostrarCosto(l.getCosto().getCostoFinal()) + " | Cliente: " + l.getCliente().getNombre() + " | Saldo del cliente: "
                        + l.getCliente().getSaldo()
                );
            }
        }
        vista.mostrarLlamadas(llamadasFormateadas);
    }

    public void listarLlamadasTodosLosSectores(ArrayList<Llamada> llamadas) {
        ArrayList<String> llamadasFormateadas = new ArrayList();
        if (!llamadas.isEmpty()) {
            for (Llamada l : llamadas) {
                llamadasFormateadas.add(
                        "Sector num: #" + l.getSector().getNumeroSector()
                        + " | Llamada num: #" + l.getNumeroLlamada() + " | Estado: "
                        + estadoLlamada(l) + " | Fecha inicio: " + l.getInicioLlamada() + " | Fecha fin: "
                        + mostrarFechaFin(l.getFinLlamada()) + " | Puesto num: #" + l.getTrabajador().getNumeroPuesto() + " | Duracion: "
                        + l.getDuracion() + " | Costo: " + mostrarCosto(l.getCosto().getCostoFinal()) + " | Cliente: " + l.getCliente().getNombre() + " | Saldo del cliente: "
                        + l.getCliente().getSaldo()
                );
            }
        }
        vista.mostrarLlamadas(llamadasFormateadas);
    }

    public String estadoLlamada(Llamada l) {
        String estado = "En curso";
        if (l.llamadaTieneFin()) {
            estado = "Finalizada";
        }
        return estado;
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        //Deberia observar el historial de sectores
        if (evento.equals(Sector.eventos.cambioHistorial)) {
            //Actualizo la informacion de llamadas
            obtenerLlamadasDeUnSector();
        }
        if (evento.equals(Fachada.eventos.cambioAlgunHistorial)) {
            obtenerLasLlamadasDeTodosLosSectores();
        }
    }

    private String mostrarFechaFin(Date finLlamada) {
        if (finLlamada == null) {
            return "La llamada aún no finalizo";
        }
        return finLlamada + "";
    }

    private String mostrarCosto(double costoFinal) {
        if (costoFinal == 0) {
            return "Aún no hay costo para la llamada";
        }
        return costoFinal + "";
    }

}
