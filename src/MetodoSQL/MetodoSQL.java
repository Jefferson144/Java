/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MetodoSQL {

    public static ConexionBD conexion = ConexionBD.getInstance();
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;

    public int Guardar_productos(String Cod_barras, String Nombre_producto, String cantidad, String valor) {
        int resultado = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO Tipo_producto(Cod_barra, nombre_producto, cantidad, valor) VALUES (?,?,?,?)");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, Cod_barras);
            sentencia_preparada.setString(2, Nombre_producto);
            sentencia_preparada.setString(3, cantidad);
            sentencia_preparada.setString(4, valor);
            resultado = sentencia_preparada.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Insercion con EXITO", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "System error,Insercion FALLIDA", "Accion no realizada", JOptionPane.ERROR_MESSAGE);
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error es -: "+e.getMessage());
        }
        return resultado;
    }

    public int Guardar_documentos(String documento) {
        int resultado = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO tipo_documento(documento) VALUES (?)");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, documento);
            resultado = sentencia_preparada.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Insercion con EXITO", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "System error,Insercion FALLIDA", "Accion no realizada", JOptionPane.ERROR_MESSAGE);
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error es: "+e);
        }
        return resultado;
    }

    public int guardar_productos(String cod_barra, String nombre_producto, String cantidad, String valor) {
        int resultado = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO tipo_producto (Cod_barra, nombre_producto, cantidad, valor) VALUES (?,?,?,?)");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, cod_barra);
            sentencia_preparada.setString(2, nombre_producto);
            sentencia_preparada.setString(3, cantidad);
            sentencia_preparada.setString(4, valor);
            resultado = sentencia_preparada.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo el producto correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el producto");
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error:"+e);
        }
        return resultado;
    }

    public int Eliminar_documento(String documento) {
        int resultado = 0;
        Connection conexion = null;
        String sentencia = ("DELETE FROM tipo_documento WHERE  documento = ?");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia);
            sentencia_preparada.setString(1, documento);
            resultado = sentencia_preparada.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Eliminacion hecha");
            } else {
                JOptionPane.showMessageDialog(null, "Fallo la eliminacion");
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error es1: "+e);
        }
        return resultado;
    }

    public int Eliminar_producto(String cod_barra) {
        int resultado = 0;
        Connection conexion = null;
        String sentencia = ("DELETE FROM tipo_producto WHERE Cod_barra = ?");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia);
            sentencia_preparada.setString(1, cod_barra);
            resultado = sentencia_preparada.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion fallida");
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error "+e);
        }
        return resultado;
    }

    public int actualizar_documento(String documento, String documento_nuevo) {
        int resultado = 0;
        Connection conexion = null;
        String sentencia = ("UPDATE tipo_documento SET documento = ? WHERE documento = '" + documento + "'");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia);
            sentencia_preparada.setString(1, documento_nuevo);
            resultado = sentencia_preparada.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Actualizacion fallidad");
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :"+e);
        }
        return resultado;
    }

    public int actualizar_producto(String cod_barra, String nombre_producto, String cantidad, String valor) {
        int resultado = 0;
        Connection conexion = null;
        String sentencia = ("UPDATE tipo_producto SET nombre_producto = ?, cantidad = ?, valor = ? WHERE Cod_barra = '" + cod_barra + "'");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia);
            sentencia_preparada.setString(1, nombre_producto);
            sentencia_preparada.setString(2, cantidad);
            sentencia_preparada.setString(3, valor);
            resultado = sentencia_preparada.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo los del producto correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE actualizo los del producto correctamente");
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        return resultado;
    }

    public static ArrayList<String> llenar_combo_Tipos_documentos() {
        Connection conexion = null;
        ArrayList<String> Tipos_documentos = new ArrayList<String>();
        String sentencia_buscar = ("SELECT * FROM tipo_documento");
        try {
            conexion = (Connection) ConexionBD.getConnection();
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error es: "+e);
        }
        try {
            while (resultado.next()) {
                Tipos_documentos.add(resultado.getString("documento"));
            }
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error es: "+e);
        }
        return Tipos_documentos;
    }

    public int buscar_datoM() {
        int datoMayorV = 0;
        Connection conexion = null;
        try {
            conexion = (Connection) ConexionBD.getConnection();
            String Sentencia_buscar_N_I = ("SELECT max(Cod_factura) FROM producto");
            sentencia_preparada = conexion.prepareStatement(Sentencia_buscar_N_I);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String datoMayor = resultado.getString("max(Cod_factura)");
                if (datoMayor == null){
                    datoMayor = "0";
                }
                datoMayorV = Integer.parseInt(datoMayor);
            }
            MetodoSQL.conexion.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return datoMayorV;
    }
    
    public int Buscar_iva(){
        int Buscar_iva = 0;
        Connection conexion = null;
        try{
            conexion = (Connection) ConexionBD.getConnection();
            String sentencia = ("SELECT iva FROM producto WHERE cod_factura = 1");
            sentencia_preparada = conexion.prepareStatement(sentencia);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()){
                String iva = resultado.getString("Iva");
                Buscar_iva = Integer.parseInt(iva);
            }
            MetodoSQL.conexion.CerrarConexion();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error es: "+e);
        }
        return Buscar_iva;
    }
    
    public int Actualizar_productos_venta(String cod_barras, String producto_actualizar){
        int Actualizacion_producto = 0;
        Connection conexion = null;
        try{
            conexion = (Connection) ConexionBD.getConnection();
            String sentencia = ("UPDATE tipo_producto SET cantidad = ? WHERE Cod_barra = '"+cod_barras+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia);
            sentencia_preparada.setString(1, producto_actualizar);
            Actualizacion_producto = sentencia_preparada.executeUpdate();
            if(Actualizacion_producto > 0){
                JOptionPane.showMessageDialog(null, "Producto actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "Producto NO actualizado");
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error es: "+e);
        }
        return Actualizacion_producto;
    }
    
    public int venta(String descripcion, String cantidad_productos, int valor_venta, int subtotal, int iva, int total, int descuento, int total_pagar, String primer_nombre_C, String tipo_documento, String documento){
        int venta = 0;
        Connection conexion = null;
        try{
            conexion = (Connection) ConexionBD.getConnection();
            String sentencia = ("INSERT INTO producto(descripcion, cantidad_productos, valor_venta, subtotal, iva, total, descuento, total_pagar, primer_nombre_c, documento, numero_documento) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            sentencia_preparada = conexion.prepareStatement(sentencia);
            sentencia_preparada.setString(1, descripcion);
            sentencia_preparada.setString(2, cantidad_productos);
            String valor_ventaF = Integer.toString(valor_venta);
            sentencia_preparada.setString(3, valor_ventaF);
            String subtotalF = Integer.toString(subtotal);
            sentencia_preparada.setString(4, subtotalF);
            String ivaF = Integer.toString(iva);
            sentencia_preparada.setString(5, ivaF);
            String totalF = Integer.toString(total);
            sentencia_preparada.setString(6, totalF);
            String descuentoF = Integer.toString(descuento);
            sentencia_preparada.setString(7, descuentoF);
            String total_pagarF = Integer.toString(total_pagar);
            sentencia_preparada.setString(8, total_pagarF);
            sentencia_preparada.setString(9, primer_nombre_C);
            sentencia_preparada.setString(10, tipo_documento);
            sentencia_preparada.setString(11, documento);
            venta = sentencia_preparada.executeUpdate();
            if (venta > 0){
                JOptionPane.showMessageDialog(null, "Venta generada");
            }else{
                JOptionPane.showMessageDialog(null, "Venta NO generada");
            }
            sentencia_preparada.close();
            MetodoSQL.conexion.CerrarConexion();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error es: "+e);
        }
        return venta;
    }

}
