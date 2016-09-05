
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class PedidoProducto {
    //Atributos
    private int idPedidoProducto;
    private int cantidad;
    private Pedido pedido;
    private Producto producto;
    private double precio;

    //Metodos

    //Constructor
    public PedidoProducto() {
    }

    public PedidoProducto(int cantidad, Pedido pedido, Producto producto, double precio) {
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.producto = producto;
        this.precio = precio;
    }

    //Seccion de metodos gettes and settes
    public int getIdPedidoProducto() {
        return idPedidoProducto;
    }

    public void setIdPedidoProducto(int idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}//fin de la clase, despues de esta linea no va nada