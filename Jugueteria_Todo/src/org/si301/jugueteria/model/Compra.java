
package org.si301.jugueteria.model;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Compra {
    //Atributos
    private int idCompra;
    private Date fechaCompra;
    private Empleado empleado;

    //Metodos

    //Constructor
    public Compra() {
    }

    public Compra(Date fechaCompra, Empleado empleado) {
        this.fechaCompra = fechaCompra;
        this.empleado = empleado;
    }

    //Seccion de metodos gettes and settes
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}//fin de la clase, despues de esta linea no va nada