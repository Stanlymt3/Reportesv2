/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportesv2;

/**
 *
 * @author stanl
 */
public class reporteTabla {
    private String Numero;
    private String Nombre_del_producto;
    private String Cantidad;
    private String Precio_sin_iva;
    private String Iva;
    private String Precio_con_iva;
    private String Dinero_total;

    public reporteTabla(String Numero, String Nombre_del_producto, String Cantidad, String Precio_sin_iva, String Iva, String Precio_con_iva, String Dinero_total) {
        this.Numero = Numero;
        this.Nombre_del_producto = Nombre_del_producto;
        this.Cantidad = Cantidad;
        this.Precio_sin_iva = Precio_sin_iva;
        this.Iva = Iva;
        this.Precio_con_iva = Precio_con_iva;
        this.Dinero_total = Dinero_total;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getNombre_del_producto() {
        return Nombre_del_producto;
    }

    public void setNombre_del_producto(String Nombre_del_producto) {
        this.Nombre_del_producto = Nombre_del_producto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getPrecio_sin_iva() {
        return Precio_sin_iva;
    }

    public void setPrecio_sin_iva(String Precio_sin_iva) {
        this.Precio_sin_iva = Precio_sin_iva;
    }

    public String getIva() {
        return Iva;
    }

    public void setIva(String Iva) {
        this.Iva = Iva;
    }

    public String getPrecio_con_iva() {
        return Precio_con_iva;
    }

    public void setPrecio_con_iva(String Precio_con_iva) {
        this.Precio_con_iva = Precio_con_iva;
    }

    public String getDinero_total() {
        return Dinero_total;
    }

    public void setDinero_total(String Dinero_total) {
        this.Dinero_total = Dinero_total;
    }
    
    
    
    
    
    
}
