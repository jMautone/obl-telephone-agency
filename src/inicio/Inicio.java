
package inicio;

import vistaEscritorio.AppTest;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Precargas.cargar();
        new AppTest().setVisible(true);
    }

}
