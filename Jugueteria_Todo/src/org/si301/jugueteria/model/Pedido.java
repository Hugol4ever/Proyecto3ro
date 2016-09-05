
package org.si301.jugueteria.model;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Pedido {
    //Atributos
    private int idPedido;
    private Date fechaPedido;
    private Cliente cliente;

    //Metodos

    //Constructor
    public Pedido() {
    }

    public Pedido(Date fechaPedido, Cliente cliente) {
        this.fechaPedido = fechaPedido;
        this.cliente = cliente;
    }

    //Seccion de metodos gettes and settes
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}//fin de la clase, despues de esta linea no va nada