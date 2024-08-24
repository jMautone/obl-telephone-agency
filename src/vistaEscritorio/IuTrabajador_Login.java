package vistaEscritorio;

import controlador.ControladorLogin;
import java.awt.Frame;
import modelo.PuestoTrabajo;
import modelo.Usuario;

public class IuTrabajador_Login extends IuUsuario_Login {

    private ControladorLogin controlador;

    public IuTrabajador_Login(Frame parent, boolean modal, String titulo) {
        super(parent, modal, titulo);
        controlador=new ControladorLogin(this);
    }

    @Override
    public void hacerLogin(String ced, String pwd) {
        controlador.login(ced, pwd, ControladorLogin.TiposUsuario.trabajador);
    }

    @Override
    public void mostrarProximaInterfaz(Object usr) {
        new IuTrabajador_AtenderLlamada(null, false, (PuestoTrabajo)usr).setVisible(true);
        dispose();
    }

}
