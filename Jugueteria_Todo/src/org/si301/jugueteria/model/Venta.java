
package org.si301.jugueteria.model;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Venta {
    //Atributos
    private int idVenta;
    private Date fechaVenta;
    private String horaVenta;
    private Cliente cliente;
    private Empleado empleado;

    //Metodos

    //Constructor
    public Venta() {
    }

    public Venta(Date fechaVenta, String horaVenta, Cliente cliente, Empleado empleado) {
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    //Seccion de metodos gettes and settes
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(String horaVenta) {
        this.horaVenta = horaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}//fin de la clase, despues de esta linea no va nada