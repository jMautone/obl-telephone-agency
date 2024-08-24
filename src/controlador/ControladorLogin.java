package controlador;

import modelo.AgenciaTelefonicaException;
import modelo.Fachada;
import modelo.PuestoTrabajo;
import modelo.Usuario;
import modelo.UsuarioTrabajador;

public class ControladorLogin {

    private VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }

    public enum TiposUsuario {
        //Solucion para un posible login de dos usuarios con distintos roles
        admin, trabajador
    };

    //Login para varios usuarios (en esta version solo hay uno)
    public void login(String ced, String pwd, TiposUsuario tu) {
        /*
        if(tu==TiposUsuario.admin){
            usr = Fachada.getInstancia().loginAdministrador(nom, pwd);
        }
         */
        if (tu == TiposUsuario.trabajador) {
            try {
                UsuarioTrabajador u = Fachada.getInstancia().loginUsuarioTrabajador(ced, pwd);
                PuestoTrabajo p = Fachada.getInstancia().asignarTrabajadorPuestoTrabajo(u);
                vista.mostrarProximaInterfaz(p);
            } catch (AgenciaTelefonicaException ex) {
                vista.mostrarError(ex.getMessage());
            }
        }
    }
}
