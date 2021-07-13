/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import MetodoSQL.ConexionBD;
import MetodoSQL.MetodoSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//autor libre

public class Interfaz_generar_venta extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_generar_venta
     */
    public Interfaz_generar_venta() {
        initComponents();
        setLocationRelativeTo(null);
        modelo.addColumn("Codigo de barras");
        modelo.addColumn("Nombre del producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Valor");
    }
    DefaultTableModel modelo = new DefaultTableModel();

    ArrayList<String> codigo_barras = new ArrayList<String>();
    ArrayList<String> cantidad_productos = new ArrayList<String>();

    MetodoSQL metodos = new MetodoSQL();

    int total_pagar, total_pagarF, valor_venta, valor_ventaF , subtotal, subtotalF, descuento;
    int cantidad_P_disminuir, cantidad_P_antiguo, iva = 19;
    String descripcion, cantidad_productos_descripcion, tipo_documento, documento;

    public void limpiarcajas() {
        int Numero_venta = metodos.buscar_datoM();
        if (Numero_venta == 0){
            Numero_venta = 1;
        }else {
          Numero_venta = Numero_venta + 1;  
        }
        String venta = Integer.toString(Numero_venta);
        txt_numero_venta.setText(venta);
        try {
            DefaultTableModel modelo = new DefaultTableModel();//creo un modelo basico por el Jtable
            Jt_datos.setModel(modelo);//mi variable que le puse a mi Jtablet y la seteo en lo que hay en modelo
            PreparedStatement sentencia_preparada = null;//llamo la libreria y le pongo el nombre y la igualo a nulo/Libreria necesaria para la ejecuccion
            ResultSet resultado = null;  //tambien el ResultSet el nombre y se iguala a nulo
            ConexionBD conexion = ConexionBD.getInstance();//creo un objeto a mi clase de ConexionBD
            Connection con = conexion.getConnection();//Llamo la libreria y le pongo un nombre, esto la igual con la conexion establecida directamente
            String consulta = "SELECT * FROM tipo_producto";
            //hago una consulta de tipo String y alli va la consulta necesaria
            sentencia_preparada = con.prepareStatement(consulta);
            //sentencia preparada va hacer igual a la conexion.sintaxis para que haga la consulta y dentro de sus parametros va la sintaxis necesaria
            resultado = sentencia_preparada.executeQuery();
            //resultado que es mi ResultSet va hacer igual a lo que me hizo mi sentencia preparada o variable .funcion
            ResultSetMetaData rsmd = resultado.getMetaData();
            //llamo una libreria ResultSetMetaData y le pongo un nombre y eso va hacer igual a resultado y esto es pasandole el resultado de la consulta
            int cantidad_colum = rsmd.getColumnCount();
            //creo una variable y alli mi rsmd o variable . funcion de que me diga cuantas columnas hay en la base de datos o gp2013
            modelo.addColumn("Cod_barra");
            //los datos que hay y que se va reflejar lo que traigamos de BD en campos individuales
            modelo.addColumn("nombre_producto");
            modelo.addColumn("cantidad");
            modelo.addColumn("valor");
            while (resultado.next()) {//el while es para ir recorriendo los datos de la consulta
                Object[] filas = new Object[cantidad_colum];//creo un array con la cantidad de columnas que hicimos hace poco
                for (int i = 0; i < filas.length; i++) {//el for es para ir pasando todos los datos a este tipo Objeto 
                    filas[i] = resultado.getObject(i + 1);//esto es para que diga la columna de la BD
                }
                modelo.addRow(filas);//relleno filas por medio del array que creamos
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JcomB_tipos_documentos.removeAllItems();
        ArrayList<String> Tipos_documentos = new ArrayList<String>();
        Tipos_documentos = MetodoSQL.llenar_combo_Tipos_documentos();
        for (int i = 0; i < Tipos_documentos.size(); i++) {
            JcomB_tipos_documentos.addItem(Tipos_documentos.get(i));
        }

        int cantidad = Jt_lista_productos.getRowCount();
        try {
            for (int i = 0; cantidad >= 0; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        txt_total_pagar.setText("");
        txt_nombre_cliente.setText("");
        txt_numero_documento.setText("");
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
        Jl_N_venta = new javax.swing.JLabel();
        txt_numero_venta = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jt_datos = new javax.swing.JTable();
        Jl_lista_productos = new javax.swing.JLabel();
        total_a_pagar = new javax.swing.JLabel();
        txt_total_pagar = new javax.swing.JTextField();
        btn_cobrar = new javax.swing.JButton();
        btn_terminar = new javax.swing.JButton();
        Primer_nombre_apellido_C = new javax.swing.JLabel();
        txt_nombre_cliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JcomB_tipos_documentos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_numero_documento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jt_lista_productos = new javax.swing.JTable();
        btn_limpiar_tabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generar venta");
        setResizable(false);

        titulo.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("GENERAR VENTA");

        Jl_N_venta.setText("Numero de venta");

        txt_numero_venta.setText("1");
        txt_numero_venta.setEnabled(false);

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

        Jt_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo de barras", "Nombre producto", "Cantidad", "Valor"
            }
        ));
        Jt_datos.setEnabled(false);
        Jt_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jt_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jt_datos);

        Jl_lista_productos.setText("Lista de productos del cliente");

        total_a_pagar.setText("Total a pagar");

        txt_total_pagar.setEnabled(false);

        btn_cobrar.setText("Cobrar");
        btn_cobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cobrarActionPerformed(evt);
            }
        });

        btn_terminar.setText("Terminar");
        btn_terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terminarActionPerformed(evt);
            }
        });

        Primer_nombre_apellido_C.setText("Primer nombre y apellido del cliente");

        txt_nombre_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombre_clienteKeyTyped(evt);
            }
        });

        jLabel3.setText("Tipo de documento");

        jLabel1.setText("Numero del documento");

        txt_numero_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numero_documentoKeyTyped(evt);
            }
        });

        Jt_lista_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo de barras", "Nombre producto", "Cantidad", "Valor"
            }
        ));
        Jt_lista_productos.setEnabled(false);
        Jt_lista_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jt_lista_productosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Jt_lista_productos);

        btn_limpiar_tabla.setText("Limpiar");
        btn_limpiar_tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_tablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_nombre_cliente)
                                            .addComponent(Primer_nombre_apellido_C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JcomB_tipos_documentos, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txt_numero_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btn_limpiar_tabla))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(total_a_pagar)
                                .addGap(48, 48, 48)
                                .addComponent(txt_total_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Jl_N_venta)
                                .addGap(43, 43, 43)
                                .addComponent(txt_numero_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jl_lista_productos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_terminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_N_venta)
                    .addComponent(txt_numero_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(Jl_lista_productos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_terminar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cobrar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_regresar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btn_limpiar_tabla)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Primer_nombre_apellido_C)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcomB_tipos_documentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_numero_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_a_pagar)
                    .addComponent(txt_total_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarcajas();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        Interfaz ob = new Interfaz();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void Jt_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jt_datosMouseClicked
        int seleccionar = Jt_datos.rowAtPoint(evt.getPoint());
        int cantidad = (int) Jt_datos.getValueAt(seleccionar, 2);
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "No se puede hacer la venta con este producto");
            evt.consume();
        } else {
            int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad del producto seleccionado"));
            String cantidadClie_pro = Integer.toString(cantidad2);
            if (cantidad >= cantidad2) {
                String cod_barras = (String.valueOf(Jt_datos.getValueAt(seleccionar, 0)));
                if (descripcion == null) {
                    descripcion = cod_barras;
                    cantidad_productos_descripcion = cantidadClie_pro;
                } else {
                    descripcion = descripcion + "-" + cod_barras;
                    cantidad_productos_descripcion = cantidad_productos_descripcion+"-"+cantidadClie_pro;
                }
                //guardo el nombre del producto para colocarselo a la tabla de los productos
                String nombre_producto = (String.valueOf(Jt_datos.getValueAt(seleccionar, 1)));
                String cantidadOficial = (String.valueOf(Jt_datos.getValueAt(seleccionar, 2)));
                //guardo la cantidad oficial del producto
                cantidad_P_antiguo = Integer.parseInt(cantidadOficial);
                //guardo el valor oficial
                String valorOficial = (String.valueOf(Jt_datos.getValueAt(seleccionar, 3)));
                //le asigno un modelo basico a la tabla
                Jt_lista_productos.setModel(modelo);
                //es igual a la cantidad2 que es la del cliente
                cantidad_P_disminuir = cantidad2;
                //hago la respectiva deduccion y es la que se vga actualizar
                int producto_reducir_final = (cantidad_P_antiguo - cantidad_P_disminuir);
                //la pongo tipo String
                String productos_final = Integer.toString(producto_reducir_final);
                //agrego un arreglo de 4 indices que son los que tiene la tabla
                String[] datos = new String[4];
                datos[0] = cod_barras;
                datos[1] = nombre_producto;
                datos[2] = cantidadClie_pro;
                datos[3] = valorOficial;
                //el modelo que es el de Jt_lista_productos los convierto en objectos y los guardo
                modelo.addRow((Object[]) datos);
                //guardo los codigos para actualizar en un arraylist
                codigo_barras.add(cod_barras);
                cantidad_productos.add(productos_final);
                int importe = Integer.parseInt(valorOficial) * cantidad2;
                valor_venta = importe;
                valor_ventaF = valor_ventaF+valor_venta; 
                int impuesto = (importe * iva) / 100; //formula del subtotal
                subtotal = impuesto;
                subtotalF = subtotalF + subtotal;
                total_pagar = (importe + impuesto);
                total_pagarF = (total_pagarF + total_pagar);
                btn_cobrar.doClick();
                if (total_pagarF > 6999999) {
                    total_pagarF = (total_pagarF * 11) / 100;
                    descuento = total_pagarF;
                }
                importe = 0;
                impuesto = 0;
            } else {
                JOptionPane.showMessageDialog(null, "No poseemos lo suficiente que esta requiriendo el cliente");
            }
        }
    }//GEN-LAST:event_Jt_datosMouseClicked

    private void btn_cobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cobrarActionPerformed
        String total = Integer.toString((int) total_pagarF);
        txt_total_pagar.setText(total);
    }//GEN-LAST:event_btn_cobrarActionPerformed

    private void Jt_lista_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jt_lista_productosMouseClicked
        int seleccionar = Jt_lista_productos.rowAtPoint(evt.getPoint());
        codigo_barras.remove(seleccionar);
        cantidad_productos.remove(seleccionar);
        modelo.removeRow(seleccionar);
    }//GEN-LAST:event_Jt_lista_productosMouseClicked

    private void btn_limpiar_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_tablaActionPerformed
        int cantidad = Jt_lista_productos.getRowCount();
        try {
            for (int i = 0; cantidad >= 0; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_limpiar_tablaActionPerformed

    private void btn_terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terminarActionPerformed
        int cantidad = codigo_barras.size();
        for (int i = 0; i < cantidad; i++) {
            metodos.Actualizar_productos_venta(codigo_barras.get(i), cantidad_productos.get(i));
        }
        tipo_documento = (String) JcomB_tipos_documentos.getSelectedItem();
        metodos.venta(descripcion,cantidad_productos_descripcion,valor_ventaF,subtotalF,iva,total_pagarF,descuento,total_pagarF,txt_nombre_cliente.getText(),tipo_documento,txt_numero_documento.getText());        
        txt_nombre_cliente.setText("");
        txt_total_pagar.setText("");
        txt_numero_documento.setText("");
        descripcion = null;
        cantidad_productos_descripcion = null;
        total_pagar = 0;
        total_pagarF = 0;
        valor_venta = 0;
        valor_ventaF = 0;
        subtotal = 0;
        subtotalF = 0;
        descuento = 0;
        cantidad_P_antiguo = 0;
        cantidad_P_disminuir = 0;
        cantidad_productos.clear();
        codigo_barras.clear();
        limpiarcajas();
    }//GEN-LAST:event_btn_terminarActionPerformed

    private void txt_nombre_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombre_clienteKeyTyped
        char c = evt.getKeyChar();
        if(txt_nombre_cliente.getText().length() >=50){
            evt.consume();
        } else {
            if (Character.isDigit(c)){
                getToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_nombre_clienteKeyTyped

    private void txt_numero_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numero_documentoKeyTyped
        char c = evt.getKeyChar();
        if(txt_numero_documento.getText().length() >=30){
            evt.consume();
        } else {
            if (Character.isLetter(c)){
                getToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_numero_documentoKeyTyped

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
            java.util.logging.Logger.getLogger(Interfaz_generar_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_generar_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_generar_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_generar_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_generar_venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcomB_tipos_documentos;
    private javax.swing.JLabel Jl_N_venta;
    private javax.swing.JLabel Jl_lista_productos;
    private javax.swing.JTable Jt_datos;
    private javax.swing.JTable Jt_lista_productos;
    private javax.swing.JLabel Primer_nombre_apellido_C;
    private javax.swing.JButton btn_cobrar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_limpiar_tabla;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_terminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel total_a_pagar;
    private javax.swing.JTextField txt_nombre_cliente;
    private javax.swing.JTextField txt_numero_documento;
    private javax.swing.JTextField txt_numero_venta;
    private javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

}
