package vistaEscritorio;

import controlador.ControladorAtenderLlamada;
import javax.swing.JOptionPane;
import modelo.PuestoTrabajo;
import controlador.VistaAtenderLlamada;

public class IuTrabajador_AtenderLlamada extends javax.swing.JDialog implements VistaAtenderLlamada {

    private ControladorAtenderLlamada controlador;

    public IuTrabajador_AtenderLlamada(java.awt.Frame parent, boolean modal, PuestoTrabajo puesto) {
        super(parent, modal);
        initComponents();
        setTitle("Atender llamadas: ");
        setLocationRelativeTo(parent);
        controlador = new ControladorAtenderLlamada(this, puesto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JList();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbNombreTrabajador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbSector = new javax.swing.JLabel();
        lbNumeroPuesto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTiempoPromedio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbCountLlamadasAtendidas = new javax.swing.JLabel();
        lbNombreCliente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bFinalizar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfDescripcion = new javax.swing.JTextArea();
        lbEstadoLlamada = new javax.swing.JLabel();
        s = new javax.swing.JLabel();

        resultado.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                resultadoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(resultado);

        jFormattedTextField1.setText("Llamada en curso ...");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setText("jFormattedTextField2");

        jScrollPane3.setViewportView(jTextPane1);

        jLabel6.setText("jLabel6");

        label1.setText("label1");

        jScrollPane4.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 63, 65));
        jLabel3.setText("Aplicacion para trabajadores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(450, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbNombreTrabajador.setText("lbNombreCompletoTrabajador");

        lbSector.setText("lbSector.................");

        lbNumeroPuesto.setText("lbNumeroPuesto");

        jLabel2.setText("Llamadas atendidas: ");

        lbTiempoPromedio.setText("1");

        jLabel4.setText("Tiempo promedio:");

        lbCountLlamadasAtendidas.setText("1");

        lbNombreCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbNombreCliente.setText("Cliente:");

        jLabel5.setText("Descripcion:");

        bFinalizar.setText("Finalizar llamada");
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        tfDescripcion.setColumns(20);
        tfDescripcion.setRows(5);
        jScrollPane2.setViewportView(tfDescripcion);

        lbEstadoLlamada.setText("No hay llamada en curso ...");
        lbEstadoLlamada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));

        s.setText("|");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(lbNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbCountLlamadasAtendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbTiempoPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lbEstadoLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbSector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbNumeroPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(371, 371, 371))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNombreTrabajador)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSector)
                            .addComponent(lbNumeroPuesto)
                            .addComponent(s)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTiempoPromedio)
                            .addComponent(lbCountLlamadasAtendidas)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addComponent(lbEstadoLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(lbNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalir)
                    .addComponent(bFinalizar))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void resultadoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_resultadoValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_resultadoValueChanged

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed
        // TODO add your handling code here:
        String desc = tfDescripcion.getText();
        controlador.finalizarLlamada(desc);
    }//GEN-LAST:event_bFinalizarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        controlador.salir();
    }//GEN-LAST:event_bSalirActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        controlador.salir();
    }//GEN-LAST:event_formWindowClosed

    //INFORMACION ESTATICA
    @Override
    public void mostrarInformacionSector(String nombreSector) {
        lbSector.setText("Sector: " + nombreSector);
    }

    @Override
    public void mostrarInformacionPuesto(String numeroPuesto) {
        //Informacion perteneciente al puesto de trabajo
        lbNumeroPuesto.setText(numeroPuesto);
    }

    @Override
    public void mostrarInformacionTrabajador(String nombreTrabajador) {
        lbNombreTrabajador.setText(nombreTrabajador);
    }

    //INFORMACION DINAMICA
    @Override
    public void actualizarInformacionPuesto(String countLlamadasAtendidas, String tiempoProm) {
        lbCountLlamadasAtendidas.setText(countLlamadasAtendidas);
        lbTiempoPromedio.setText(tiempoProm);
    }

    @Override
    public void mostrarMensajeEstadoLlamada(String msgEstadoLlamada) {
        lbEstadoLlamada.setText(msgEstadoLlamada);
    }

    @Override
    public void mostrarInformacionNuevaLlamada(String nombreUsuarioCliente) {
        bFinalizar.setEnabled(true);
        //La informacion de la llamada asignada
        lbNombreCliente.setText("Cliente: " + nombreUsuarioCliente);
    }

    @Override
    public void mostrarPuestoSinLlamada() {
        bFinalizar.setEnabled(false);
        //La informacion para cuando el puesto no tiene llamada asignada
        lbNombreCliente.setText("Cliente: -");
    }

    //EVENTOS DEL TRABAJADOR
    @Override
    public void finalizarLlamada() {
        //Aca si quisiera hacer algo cuando termina la llamada
        tfDescripcion.setText("");
    }

    @Override
    public void salir() {
        dispose();
    }

    @Override
    public void confirmarSalida() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "Realmente desea salir y finalizar la llamada en curso?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (JOptionPane.YES_OPTION == confirmacion) {
            controlador.dejarPuesto();
        }
    }

    @Override
    public void mostrarMsjEmergente(String msj) {
        JOptionPane.showMessageDialog(this, msj);
    }

// @Override
//    public void salir() {
//        dispose();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bSalir;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private java.awt.Label label1;
    private javax.swing.JLabel lbCountLlamadasAtendidas;
    private javax.swing.JLabel lbEstadoLlamada;
    private javax.swing.JLabel lbNombreCliente;
    private javax.swing.JLabel lbNombreTrabajador;
    private javax.swing.JLabel lbNumeroPuesto;
    private javax.swing.JLabel lbSector;
    private javax.swing.JLabel lbTiempoPromedio;
    private javax.swing.JList resultado;
    private javax.swing.JLabel s;
    private javax.swing.JTextArea tfDescripcion;
    // End of variables declaration//GEN-END:variables

}
