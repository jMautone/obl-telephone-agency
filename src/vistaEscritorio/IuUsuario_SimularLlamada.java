package vistaEscritorio;

import controlador.ControladorSimularLlamada;
import controlador.VistaSimularLlamada;

public class IuUsuario_SimularLlamada extends javax.swing.JDialog implements VistaSimularLlamada {

    private ControladorSimularLlamada controlador;
    private String txtValorCampo = "";

    public IuUsuario_SimularLlamada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Simular llamada: ");
        setLocationRelativeTo(parent);
        bFInalizar.setEnabled(false);
        //Ver si es necesario hacerlo en el constructor o mediante un evento
        controlador = new ControladorSimularLlamada(this);
    }

    @Override
    public void mostrarMensajeCentralTelefonica(String msg) {
        lbMensajeCentralTelefonica.setText("<html><body>" + msg + "</body></html>"); //Solo para mostrar las respuestas que envia el controlador
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bSalir = new javax.swing.JButton();
        bFInalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbMensajeCentralTelefonica = new javax.swing.JLabel();
        bNumber2 = new javax.swing.JButton();
        bNumber3 = new javax.swing.JButton();
        bNumber1 = new javax.swing.JButton();
        bNumber5 = new javax.swing.JButton();
        bNumber6 = new javax.swing.JButton();
        bNumber4 = new javax.swing.JButton();
        bNumber8 = new javax.swing.JButton();
        bNumber9 = new javax.swing.JButton();
        bNumber7 = new javax.swing.JButton();
        bNumber0 = new javax.swing.JButton();
        bIngresarValorAcumulado = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        bIniciar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 63, 65));
        jLabel3.setText("Simulador de llamadas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(496, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bFInalizar.setForeground(new java.awt.Color(255, 0, 0));
        bFInalizar.setText("Finalizar");
        bFInalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFInalizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Mensaje de");

        jLabel2.setText("la central");

        jLabel4.setText("telefonica: ");

        lbMensajeCentralTelefonica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));

        bNumber2.setText("2");
        bNumber2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber2ActionPerformed(evt);
            }
        });

        bNumber3.setText("3");
        bNumber3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber3ActionPerformed(evt);
            }
        });

        bNumber1.setText("1");
        bNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber1ActionPerformed(evt);
            }
        });

        bNumber5.setText("5");
        bNumber5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber5ActionPerformed(evt);
            }
        });

        bNumber6.setText("6");
        bNumber6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber6ActionPerformed(evt);
            }
        });

        bNumber4.setText("4");
        bNumber4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber4ActionPerformed(evt);
            }
        });

        bNumber8.setText("8");
        bNumber8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber8ActionPerformed(evt);
            }
        });

        bNumber9.setText("9");
        bNumber9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber9ActionPerformed(evt);
            }
        });

        bNumber7.setText("7");
        bNumber7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber7ActionPerformed(evt);
            }
        });

        bNumber0.setText("0");
        bNumber0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumber0ActionPerformed(evt);
            }
        });

        bIngresarValorAcumulado.setText("#");
        bIngresarValorAcumulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIngresarValorAcumuladoActionPerformed(evt);
            }
        });

        jButton25.setText("*");

        bIniciar1.setForeground(new java.awt.Color(0, 200, 0));
        bIniciar1.setText("Iniciar");
        bIniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNumber0, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bIngresarValorAcumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bIniciar1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bFInalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMensajeCentralTelefonica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bFInalizar)
                    .addComponent(bIniciar1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lbMensajeCentralTelefonica, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNumber0, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bIngresarValorAcumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalir))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNumber2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber2ActionPerformed
        txtValorCampo = txtValorCampo + "2";

    }//GEN-LAST:event_bNumber2ActionPerformed

    private void bNumber4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber4ActionPerformed
        txtValorCampo = txtValorCampo + "4";
    }//GEN-LAST:event_bNumber4ActionPerformed

    private void bNumber6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber6ActionPerformed
        txtValorCampo = txtValorCampo + "6";
    }//GEN-LAST:event_bNumber6ActionPerformed

    private void bIniciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciar1ActionPerformed
        controlador.iniciarProcesoLlamada();
        bIniciar1.setEnabled(false);
    }//GEN-LAST:event_bIniciar1ActionPerformed

    private void bIngresarValorAcumuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIngresarValorAcumuladoActionPerformed
        controlador.ejecutarAccion(txtValorCampo);
        txtValorCampo = "";//Cada vez que se ejecuta el numeral borro el valor acumulado
    }//GEN-LAST:event_bIngresarValorAcumuladoActionPerformed

    private void bNumber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber1ActionPerformed
        txtValorCampo = txtValorCampo + "1";
    }//GEN-LAST:event_bNumber1ActionPerformed

    private void bNumber3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber3ActionPerformed
        txtValorCampo = txtValorCampo + "3";

    }//GEN-LAST:event_bNumber3ActionPerformed

    private void bNumber5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber5ActionPerformed
        txtValorCampo = txtValorCampo + "5";

    }//GEN-LAST:event_bNumber5ActionPerformed

    private void bNumber7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber7ActionPerformed
        txtValorCampo = txtValorCampo + "7";

    }//GEN-LAST:event_bNumber7ActionPerformed

    private void bNumber8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber8ActionPerformed
        txtValorCampo = txtValorCampo + "8";

    }//GEN-LAST:event_bNumber8ActionPerformed

    private void bNumber9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber9ActionPerformed
        txtValorCampo = txtValorCampo + "9";

    }//GEN-LAST:event_bNumber9ActionPerformed

    private void bNumber0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumber0ActionPerformed
        txtValorCampo = txtValorCampo + "0";
    }//GEN-LAST:event_bNumber0ActionPerformed

    private void bFInalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFInalizarActionPerformed
        //Finalizar la llamada
        controlador.finalizarProcesoLlamada();
    }//GEN-LAST:event_bFInalizarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        //Ver validaciones si quiere salir y tiene una llamda pendiente
        controlador.salir();
    }//GEN-LAST:event_bSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFInalizar;
    private javax.swing.JButton bIngresarValorAcumulado;
    private javax.swing.JButton bIniciar1;
    private javax.swing.JButton bNumber0;
    private javax.swing.JButton bNumber1;
    private javax.swing.JButton bNumber2;
    private javax.swing.JButton bNumber3;
    private javax.swing.JButton bNumber4;
    private javax.swing.JButton bNumber5;
    private javax.swing.JButton bNumber6;
    private javax.swing.JButton bNumber7;
    private javax.swing.JButton bNumber8;
    private javax.swing.JButton bNumber9;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton jButton25;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbMensajeCentralTelefonica;
    // End of variables declaration//GEN-END:variables

    @Override
    public void salir() {
        dispose();
    }

    @Override
    public void reiniciarCasoDeUso() {
        bIniciar1.setEnabled(true);
        bFInalizar.setEnabled(false);
    }

    @Override
    public void iniciaLlamada() {
        bFInalizar.setEnabled(true);
    }
}
