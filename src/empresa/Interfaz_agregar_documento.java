/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import MetodoSQL.MetodoSQL;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//autor libre

public class Interfaz_agregar_documento extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_agregar_documento
     */
    public Interfaz_agregar_documento() {
        initComponents();
        setLocationRelativeTo(null);
    }

    MetodoSQL metodos = new MetodoSQL();

    public void limpiarcajas() {
        txt_documento_actualizar.setText(null);
        txt_documento_nuevo.setText(null);
        JcomB_documentos.removeAllItems();
        ArrayList<String> Tipos_documentos = new ArrayList<String>();
        Tipos_documentos = MetodoSQL.llenar_combo_Tipos_documentos();
        for (int i = 0; i < Tipos_documentos.size(); i++) {
            JcomB_documentos.addItem(Tipos_documentos.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        Jl_agregar_documento = new javax.swing.JLabel();
        txt_documento_nuevo = new javax.swing.JTextField();
        Jl_documentos = new javax.swing.JLabel();
        JcomB_documentos = new javax.swing.JComboBox<>();
        Jl_documento_actualizar = new javax.swing.JLabel();
        txt_documento_actualizar = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar documento");
        setResizable(false);

        titulo.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("AGREGAR DOCUMENTO");

        Jl_agregar_documento.setText("Documento nuevo");

        txt_documento_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_documento_nuevoKeyTyped(evt);
            }
        });

        Jl_documentos.setText("Documentos de la empresa");

        Jl_documento_actualizar.setText("Documento a actualizar");

        txt_documento_actualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_documento_actualizarKeyTyped(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar cajas");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_regresar.setText("regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jl_agregar_documento)
                    .addComponent(Jl_documentos)
                    .addComponent(Jl_documento_actualizar))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_documento_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addComponent(txt_documento_actualizar))
                    .addComponent(JcomB_documentos, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_agregar_documento)
                    .addComponent(txt_documento_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_documento_actualizar)
                    .addComponent(txt_documento_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jl_documentos)
                            .addComponent(JcomB_documentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btn_actualizar)
                        .addGap(27, 27, 27)
                        .addComponent(btn_limpiar)))
                .addGap(29, 29, 29)
                .addComponent(btn_regresar)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (txt_documento_nuevo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede guardar por que no hay ningun documento");
            limpiarcajas();
        } else {
            metodos.Guardar_documentos(txt_documento_nuevo.getText());
            limpiarcajas();
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarcajas();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (txt_documento_nuevo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar porque se desconoce el documento");
            limpiarcajas();
        } else {
            metodos.Eliminar_documento(txt_documento_nuevo.getText());
            limpiarcajas();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        if (txt_documento_nuevo.getText().isEmpty() || txt_documento_actualizar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar porque falta rellenar datos");
            limpiarcajas();
        } else {
            metodos.actualizar_documento(txt_documento_nuevo.getText(), txt_documento_actualizar.getText());
            limpiarcajas();
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        this.dispose();
        Interfaz ob = new Interfaz();
        ob.setVisible(true);
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void txt_documento_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documento_nuevoKeyTyped
        char c = evt.getKeyChar();
        if (txt_documento_nuevo.getText().length() >= 45) {
            evt.consume();
        } else {
            if (Character.isDigit(c)) {
                getToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_documento_nuevoKeyTyped

    private void txt_documento_actualizarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documento_actualizarKeyTyped
        char c = evt.getKeyChar();
        if (txt_documento_actualizar.getText().length() >=45){
            evt.consume();
        } else {
            if (Character.isDigit(c)){
                getToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_documento_actualizarKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_agregar_documento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_agregar_documento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_agregar_documento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_agregar_documento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_agregar_documento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcomB_documentos;
    private javax.swing.JLabel Jl_agregar_documento;
    private javax.swing.JLabel Jl_documento_actualizar;
    private javax.swing.JLabel Jl_documentos;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txt_documento_actualizar;
    private javax.swing.JTextField txt_documento_nuevo;
    // End of variables declaration//GEN-END:variables
}
