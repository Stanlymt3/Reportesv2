package reportesv2;

import java.sql.ResultSet;

public class InsertarDatos {

    Conexion cn = new Conexion();

    //Metodos Insertar
    public void insertarBebida(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {
        cn.UID("INSERT INTO bebidas(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('" + Numero + "','" + Nombre_del_producto + "','" + Cantidad + "','" + Precio_sin_iva + "','" + Iva + "','" + Precio_con_iva + "','" + Dinero_total + "')");
    }

    public void insertarAbarrote(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {
        cn.UID("INSERT INTO Abarrotes(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('" + Numero + "','" + Nombre_del_producto + "','" + Cantidad + "','" + Precio_sin_iva + "','" + Iva + "','" + Precio_con_iva + "','" + Dinero_total + "')");
    }

    public void insertarMedicina(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {
        cn.UID("INSERT INTO Medicina(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('" + Numero + "','" + Nombre_del_producto + "','" + Cantidad + "','" + Precio_sin_iva + "','" + Iva + "','" + Precio_con_iva + "','" + Dinero_total + "')");
    }

    public void insertarLibreria(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {
        cn.UID("INSERT INTO Libreria(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('" + Numero + "','" + Nombre_del_producto + "','" + Cantidad + "','" + Precio_sin_iva + "','" + Iva + "','" + Precio_con_iva + "','" + Dinero_total + "')");
    }

    //Metodos contar
    public ResultSet contarRegistrosBebidas() {
        return (cn.getValores("SELECT COUNT(*) FROM bebidas"));
    }

    public ResultSet contarRegistrosAbarrotes() {
        return (cn.getValores("SELECT COUNT(*) FROM Abarrotes"));
    }

    public ResultSet contarRegistrosMedicina() {
        return (cn.getValores("SELECT COUNT(*) FROM Medicina"));
    }

    public ResultSet contarRegistrosLibreria() {
        return (cn.getValores("SELECT COUNT(*) FROM Libreria"));
    }

    //Metodos Buscar
    public ResultSet buscarBebidas(String codigo) {
        return (cn.getValores("SELECT * FROM bebidas WHERE Numero='" + codigo + "'"));
    }

    public ResultSet buscarAbarrotes(String codigo) {
        return (cn.getValores("SELECT * FROM Abarrotes WHERE Numero='" + codigo + "'"));
    }

    public ResultSet buscarMedicina(String codigo) {
        return (cn.getValores("SELECT * FROM Medicina WHERE Numero='" + codigo + "'"));
    }

    public ResultSet buscarLibreria(String codigo) {
        return (cn.getValores("SELECT * FROM Libreria WHERE Numero='" + codigo + "'"));
    }

    //Metodo modificar 
    public void modificarBebidas(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {//Bebidas
        cn.UID("UPDATE bebidas SET Numero='" + Numero + "', Nombre_del_producto='" + Nombre_del_producto + "',Cantidad='" + Cantidad + "',Precio_sin_iva='" + Precio_sin_iva + "',Iva='"
                + Iva + "',Dinero_total='" + Dinero_total + "' WHERE idJugo='" + Numero + "'");
    }

    public void modificarAbarrotes(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {//Abarrotes
        cn.UID("UPDATE bebidas SET Numero='" + Numero + "', Nombre_del_producto='" + Nombre_del_producto + "',Cantidad='" + Cantidad + "',Precio_sin_iva='" + Precio_sin_iva + "',Iva='"
                + Iva + "',Dinero_total='" + Dinero_total + "' WHERE idJugo='" + Numero + "'");
    }

    public void modificarMedicina(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {//Medicina
        cn.UID("UPDATE bebidas SET Numero='" + Numero + "', Nombre_del_producto='" + Nombre_del_producto + "',Cantidad='" + Cantidad + "',Precio_sin_iva='" + Precio_sin_iva + "',Iva='"
                + Iva + "',Dinero_total='" + Dinero_total + "' WHERE idJugo='" + Numero + "'");
    }

    public void modificarLibreria(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {//Libreria
        cn.UID("UPDATE bebidas SET Numero='" + Numero + "', Nombre_del_producto='" + Nombre_del_producto + "',Cantidad='" + Cantidad + "',Precio_sin_iva='" + Precio_sin_iva + "',Iva='"
                + Iva + "',Dinero_total='" + Dinero_total + "' WHERE idJugo='" + Numero + "'");
    }

}
