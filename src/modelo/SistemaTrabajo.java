package modelo;

import java.util.ArrayList;

public class SistemaTrabajo {

    private ArrayList<Sector> sectores = new ArrayList();

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public void agregarSector(Sector s) {
        sectores.add(s);
    }

    public PuestoTrabajo asignarTrabajadorPuestoTrabajo(UsuarioTrabajador ut) throws AgenciaTelefonicaException {
        //Recorro los sectores y encuentro al que le pertenece el trabajador
        for (Sector s : sectores) {
            if (ut.getSector().equals(s)) {
                //Si encuentro su sector me fijo si tiene puestos libres
                PuestoTrabajo p = s.asignarTrabajadorPuestoTrabajo(ut);
                return p;
            }
        }
        throw new AgenciaTelefonicaException("El trabajador no tiene un sector asociado"); //Mensaje opcional
    }

    public Sector obtenerUnSector(String numeroSector) throws AgenciaTelefonicaException {
        for (Sector s : sectores) {
            if (s.getNumeroSector().equals(numeroSector)) {
                return s;
            }
        }
        throw new AgenciaTelefonicaException("Sector no válido");
    }

    public ArrayList<Llamada> obtenerLasLlamadasDeTodosLosSectores() {
        ArrayList<Llamada> todasLasLlamadas = new ArrayList();
        for (Sector s : sectores) {
            for (Llamada l : s.getHistorial()) {
                todasLasLlamadas.add(l);
            }
        }
        return todasLasLlamadas;
    }
}
