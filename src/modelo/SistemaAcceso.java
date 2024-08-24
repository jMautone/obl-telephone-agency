package modelo;

import java.util.ArrayList;

public class SistemaAcceso {

    private ArrayList<UsuarioCliente> usuariosClientes = new ArrayList();
    private ArrayList<UsuarioTrabajador> usuariosTrabajadores = new ArrayList();

    public void addUsuarioCliente(UsuarioCliente uc) {
        usuariosClientes.add(uc);
    }

    public void addUsuarioTrabajador(UsuarioTrabajador ut) {
        usuariosTrabajadores.add(ut);
    }

    //Obtener clientes por cedula
    public UsuarioCliente obtenerCliente(String ced) throws AgenciaTelefonicaException {
        for (UsuarioCliente usu : usuariosClientes) {
            if (usu.getCedula().equals(ced)) {
                return usu;
            }
        }
        throw new AgenciaTelefonicaException("Cliente no registrado");
    }

    public UsuarioTrabajador loginUsuarioTrabajador(String ced, String pwd) throws AgenciaTelefonicaException {
        UsuarioTrabajador ut = (UsuarioTrabajador) login(ced, pwd, usuariosTrabajadores);
        return ut;
    }

    //Restringido solo a trabajadores
    public Usuario login(String ced, String pwd, ArrayList listaUsu) throws AgenciaTelefonicaException {
        UsuarioTrabajador usr;
        for (Object o : listaUsu) {
            usr = (UsuarioTrabajador) o;
            if (usr.getCedula().equals(ced) && usr.getPwd().equals(pwd)) {
                return usr;
            }
        }
        throw new AgenciaTelefonicaException("Acceso denegado");
    }

}
