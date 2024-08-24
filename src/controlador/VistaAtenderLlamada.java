package controlador;

public interface VistaAtenderLlamada {

    public void finalizarLlamada();

    public void mostrarInformacionSector(String nombreSector);

    public void actualizarInformacionPuesto(String countLlamadasAtendidas, String tiempoProm);
    
    public void mostrarInformacionPuesto(String numeroPuesto);

    public void mostrarInformacionNuevaLlamada(String nombreUsuarioCliente);
    
    public void mostrarMensajeEstadoLlamada(String msgEstadoLlamada);
    
    public void mostrarInformacionTrabajador(String nombreTrabajador);
    
    public void mostrarPuestoSinLlamada();

    public void salir();
    
    public void confirmarSalida();

    public void mostrarMsjEmergente(String msj);

}
