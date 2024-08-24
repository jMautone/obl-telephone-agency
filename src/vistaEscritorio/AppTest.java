/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaEscritorio;

/**
 *
 * @author PC
 */
public class AppTest extends javax.swing.JFrame {

    /**
     * Creates new form AppTest
     */
    public AppTest() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemLoginTrabajador = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        itemNuevaLlamada = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        itemMonitoreo = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("jMenu4");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jMenu1.setText("Inciar sesión");

        itemLoginTrabajador.setText("Trabajador");
        itemLoginTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLoginTrabajadorActionPerformed(evt);
            }
        });
        jMenu1.add(itemLoginTrabajador);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Realizar una llamada");

        itemNuevaLlamada.setText("Nueva llamada");
        itemNuevaLlamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevaLlamadaActionPerformed(evt);
            }
        });
        jMenu5.add(itemNuevaLlamada);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Monitoreo llamadas");

        itemMonitoreo.setText("Monitorear");
        itemMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMonitoreoActionPerformed(evt);
            }
        });
        jMenu6.add(itemMonitoreo);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemLoginTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLoginTrabajadorActionPerformed
        // Login para varios usuarios : Actualmente 1
        new IuTrabajador_Login(null, false, "Iniciar sesion - Trabajadador").setVisible(true);
    }//GEN-LAST:event_itemLoginTrabajadorActionPerformed

    private void itemNuevaLlamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevaLlamadaActionPerformed
        // Simular llamadas : cualquier usuario puede acceder
        new IuUsuario_SimularLlamada(null, false).setVisible(true);
    }//GEN-LAST:event_itemNuevaLlamadaActionPerformed

    private void itemMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMonitoreoActionPerformed
        // Monitorear llamadas : cualquier usuario puede acceder
        new IuUsuario_Monitoreo(null, false).setVisible(true);
    }//GEN-LAST:event_itemMonitoreoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemLoginTrabajador;
    private javax.swing.JMenuItem itemMonitoreo;
    private javax.swing.JMenuItem itemNuevaLlamada;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
