
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class CompraProducto {
    //Atributos
    private int idCompraProducto;
    private double precio;
    private int cantidad;
    private Compra compra;
    private Producto producto;

    //Metodos

    //Constructor
    public CompraProducto() {
    }

    public CompraProducto(double precio, int cantidad, Compra compra, Producto producto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.compra = compra;
        this.producto = producto;
    }

    //Seccion de metodos gettes and settes
    public int getIdCompraProducto() {
        return idCompraProducto;
    }

    public void setIdCompraProducto(int idCompraProducto) {
        this.idCompraProducto = idCompraProducto;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    

}//fin de la clase, despues de esta linea no va nada