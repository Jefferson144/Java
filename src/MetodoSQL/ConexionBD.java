
package MetodoSQL;

import java.sql.*;
import javax.swing.JOptionPane;


public class ConexionBD {
    
    private static Connection conexion;
    private static ConexionBD instancia;
    private static final String url="jdbc:mysql://localhost:3306/empresa";
    private static final String username = "root";
    private static final String password = "1a2c3m4e.";
    
    private ConexionBD(){
    
    }
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El error es-: "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return conexion;       
    }
    
    public void CerrarConexion() throws SQLException{
        try{
            conexion.close();
        }catch(Exception e){
            conexion.close();
        }finally{
            conexion.close();
        }
    }
    
    public static ConexionBD getInstance(){
        if (instancia == null){
            instancia = new ConexionBD();
        }
        return instancia;
    }
}
