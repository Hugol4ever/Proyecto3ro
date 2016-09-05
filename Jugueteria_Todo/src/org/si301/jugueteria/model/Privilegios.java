
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class Privilegios {
    //Atributos
    private int idPrivilegio;
    private boolean ABC_cliente;
    private boolean rep_cliente;
    private boolean ABC_empleado;
    private boolean rep_empleado;
    private boolean ABC_producto;
    private boolean rep_producto;
    private boolean ABC_venta;
    private boolean rep_venta;
    private boolean rep_compra;
    private boolean ABC_pedido;
    private boolean rep_pedido;
    private boolean add_user;
    private boolean add_marca;
    private boolean add_puesto;
    private boolean add_categoria;
    private boolean abastecer_almacen;
    private boolean rep_almacen;

    //Metodos

    //Constructor
    public Privilegios() {
    }

    public Privilegios(boolean ABC_cliente, boolean rep_cliente, boolean ABC_empleado, boolean rep_empleado, boolean ABC_producto, boolean rep_producto, boolean ABC_venta, boolean rep_venta, boolean rep_compra, boolean ABC_pedido, boolean rep_pedido, boolean add_user, boolean add_marca, boolean add_puesto, boolean add_categoria, boolean abastecer_almacen, boolean rep_almacen) {
        this.ABC_cliente = ABC_cliente;
        this.rep_cliente = rep_cliente;
        this.ABC_empleado = ABC_empleado;
        this.rep_empleado = rep_empleado;
        this.ABC_producto = ABC_producto;
        this.rep_producto = rep_producto;
        this.ABC_venta = ABC_venta;
        this.rep_venta = rep_venta;
        this.rep_compra = rep_compra;
        this.ABC_pedido = ABC_pedido;
        this.rep_pedido = rep_pedido;
        this.add_user = add_user;
        this.add_marca = add_marca;
        this.add_puesto = add_puesto;
        this.add_categoria = add_categoria;
        this.abastecer_almacen = abastecer_almacen;
        this.rep_almacen = rep_almacen;
    }

    //Seccion de metodos gettes and settes
    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public boolean isABC_cliente() {
        return ABC_cliente;
    }

    public void setABC_cliente(boolean ABC_cliente) {
        this.ABC_cliente = ABC_cliente;
    }

    public boolean isRep_cliente() {
        return rep_cliente;
    }

    public void setRep_cliente(boolean rep_cliente) {
        this.rep_cliente = rep_cliente;
    }

    public boolean isABC_empleado() {
        return ABC_empleado;
    }

    public void setABC_empleado(boolean ABC_empleado) {
        this.ABC_empleado = ABC_empleado;
    }

    public boolean isRep_empleado() {
        return rep_empleado;
    }

    public void setRep_empleado(boolean rep_empleado) {
        this.rep_empleado = rep_empleado;
    }

    public boolean isABC_producto() {
        return ABC_producto;
    }

    public void setABC_producto(boolean ABC_producto) {
        this.ABC_producto = ABC_producto;
    }

    public boolean isRep_producto() {
        return rep_producto;
    }

    public void setRep_producto(boolean rep_producto) {
        this.rep_producto = rep_producto;
    }

    public boolean isABC_venta() {
        return ABC_venta;
    }

    public void setABC_venta(boolean ABC_venta) {
        this.ABC_venta = ABC_venta;
    }

    public boolean isRep_venta() {
        return rep_venta;
    }

    public void setRep_venta(boolean rep_venta) {
        this.rep_venta = rep_venta;
    }

    public boolean isRep_compra() {
        return rep_compra;
    }

    public void setRep_compra(boolean rep_compra) {
        this.rep_compra = rep_compra;
    }

    public boolean isABC_pedido() {
        return ABC_pedido;
    }

    public void setABC_pedido(boolean ABC_pedido) {
        this.ABC_pedido = ABC_pedido;
    }

    public boolean isRep_pedido() {
        return rep_pedido;
    }

    public void setRep_pedido(boolean rep_pedido) {
        this.rep_pedido = rep_pedido;
    }

    public boolean isAdd_user() {
        return add_user;
    }

    public void setAdd_user(boolean add_user) {
        this.add_user = add_user;
    }

    public boolean isAdd_marca() {
        return add_marca;
    }

    public void setAdd_marca(boolean add_marca) {
        this.add_marca = add_marca;
    }

    public boolean isAdd_puesto() {
        return add_puesto;
    }

    public void setAdd_puesto(boolean add_puesto) {
        this.add_puesto = add_puesto;
    }

    public boolean isAdd_categoria() {
        return add_categoria;
    }

    public void setAdd_categoria(boolean add_categoria) {
        this.add_categoria = add_categoria;
    }

    public boolean isAbastecer_almacen() {
        return abastecer_almacen;
    }

    public void setAbastecer_almacen(boolean abastecer_almacen) {
        this.abastecer_almacen = abastecer_almacen;
    }

    public boolean isRep_almacen() {
        return rep_almacen;
    }

    public void setRep_almacen(boolean rep_almacen) {
        this.rep_almacen = rep_almacen;
    }

}//fin de la clase, despues de esta linea no va nada