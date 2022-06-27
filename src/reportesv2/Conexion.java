package reportesv2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private final String url="jdbc:mysql://localhost:3306/inventario?characterEncoding=utf8";
    private final String login="root";
    private final String password="02011388";
    private Connection cnx=null;
    private Statement sttm=null;
    private ResultSet rst=null;
    
    
    public Conexion(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR:"+ ex.getMessage());
            System.exit(1);
        } catch (ClassNotFoundException c){
            JOptionPane.showMessageDialog(null,"ERROR:"+ c.getMessage());
            System.exit(1);            
        }
    }
    
    //Metodo UID
    public void UID(String sql){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection(url, login, password);
            sttm=cnx.createStatement();
            sttm.executeUpdate(sql);
        } catch (ClassNotFoundException c) {
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            System.exit(1);            
        }
    }
    
    //Metodo Consultar
    public ResultSet getValores(String sql){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection(url, login, password);
            sttm=cnx.createStatement();
            rst = sttm.executeQuery(sql);
        } catch (ClassNotFoundException c) {
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            System.exit(1);            
        }
        return rst;
    }
    
    //Metodo Cerrar
    public void cerrar(){
        try {
            this.cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            System.exit(1); 
        }
    }
    
    //Metodo Connection
    public Connection getConexion(){
        return this.cnx;
    }
    
}
