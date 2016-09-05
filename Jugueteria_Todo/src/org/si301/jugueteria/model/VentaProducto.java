
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class VentaProducto {
    //Atributos
    private int idVentaProducto;
    private double precio;
    private int cantidad;
    private Venta venta;
    private Producto producto;

    //Metodos

    //Constructor
    public VentaProducto() {
    }

    public VentaProducto(double precio, int cantidad, Venta venta, Producto producto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.venta = venta;
        this.producto = producto;
    }

    //Seccion de metodos gettes and settes
    public int getIdVentaProducto() {
        return idVentaProducto;
    }

    public void setIdVentaProducto(int idVentaProducto) {
        this.idVentaProducto = idVentaProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}//fin de la clase, despues de esta linea no va nada