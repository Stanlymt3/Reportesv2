package reportesv2;

public class InsertarDatos {
    Conexion cn = new Conexion();
    
    public void insertarBebida(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total){
        cn.UID("INSERT INTO bebidas(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('"+Numero+"','"+Nombre_del_producto+"','"+Cantidad+"','"+Precio_sin_iva+"','"+Iva+"','"+Precio_con_iva+"','"+Dinero_total+"')");
    }
    public void insertarAbarrote(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total){
        cn.UID("INSERT INTO abarrotes(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('"+Numero+"','"+Nombre_del_producto+"','"+Cantidad+"','"+Precio_sin_iva+"','"+Iva+"','"+Precio_con_iva+"','"+Dinero_total+"')");
    }
    
    public void insertarMedicina(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total){
        cn.UID("INSERT INTO Medicina(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('"+Numero+"','"+Nombre_del_producto+"','"+Cantidad+"','"+Precio_sin_iva+"','"+Iva+"','"+Precio_con_iva+"','"+Dinero_total+"')");
    }
    public void insertarLibreria(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total){
        cn.UID("INSERT INTO Libreria(Numero, Nombre_del_Producto, Cantidad, Precio_sin_iva, Iva, Precio_con_iva, Dinero_total) VALUES "
                + "('"+Numero+"','"+Nombre_del_producto+"','"+Cantidad+"','"+Precio_sin_iva+"','"+Iva+"','"+Precio_con_iva+"','"+Dinero_total+"')");
    }
}
