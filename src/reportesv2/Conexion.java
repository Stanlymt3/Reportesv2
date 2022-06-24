package reportesv2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private final String url="jdbc:mysql://bkjemzmxcoa1eelwlf6j-mysql.services.clever-cloud.com:3306/bkjemzmxcoa1eelwlf6j";
    private final String login="udv0mxxkekbzv4rz";
    private final String password="OIEIxuowHTQhM8O3S7Jr";
    private final String puerto = "3306";
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
