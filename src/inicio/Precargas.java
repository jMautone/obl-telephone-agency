package inicio;

import java.util.ArrayList;
import modelo.ClienteConCosto;
import modelo.ClienteExonerado;
import modelo.ClienteGestor;
import modelo.Fachada;
import modelo.Llamada;
import modelo.Sector;
import modelo.UsuarioCliente;
import modelo.UsuarioTrabajador;

public class Precargas {

    public static void cargar() {

        Fachada logica = Fachada.getInstancia();
        
        //        La información que se debe precargar es:
        //        *Clientes - Información básica: cédula de identidad, nombre completo, y saldo
        //        *Trabajadores - Información básica: cédula de identidad, contraseña, y nombre completo.
        //        *Sectores - información básica: nombre, número y cantidad de puestos de trabajo.
        //        *Cantidad máxima de llamadas totales (tanto en curso como en espera) que soporta el
        //        sistema = 5.
        //        *Valor del costo fijo x segundo de las llamadas = $1

        //Sectores de trabajo
        Sector s1 = new Sector("Ventas", "1", 5, 5);
        Sector s2 = new Sector("Servicio tecnico", "2", 5, 5);
        Sector s3 = new Sector("Postventa", "3", 5, 5);

        logica.agregarSector(s1);
        logica.agregarSector(s2);
        logica.agregarSector(s3);

        //Usuarios clientes
        UsuarioCliente c1 = new UsuarioCliente("1", "cliente1", 500, new ClienteGestor());
        UsuarioCliente c2 = new UsuarioCliente("2", "cliente2", 300, new ClienteConCosto());
        UsuarioCliente c3 = new UsuarioCliente("3", "cliente3", 300, new ClienteExonerado());
        
        logica.agregarUsuarioCliente(c1);
        logica.agregarUsuarioCliente(c2);
        logica.agregarUsuarioCliente(c3);

        //Usuarios trabajadores
        
        //Sector 1
        logica.agregarUsuarioTrabajador(new UsuarioTrabajador("a", "a", "trabajador1", s1));
        //Sector 2
        logica.agregarUsuarioTrabajador(new UsuarioTrabajador("b", "b", "trabajador2", s2));
        logica.agregarUsuarioTrabajador(new UsuarioTrabajador("c", "c", "trabajador3", s2));
        logica.agregarUsuarioTrabajador(new UsuarioTrabajador("d", "d", "trabajador4", s2));
        logica.agregarUsuarioTrabajador(new UsuarioTrabajador("e", "e", "trabajador5", s2));
        //Sector 3
        logica.agregarUsuarioTrabajador(new UsuarioTrabajador("f", "f", "trabajador6", s3));
        
    }

}
