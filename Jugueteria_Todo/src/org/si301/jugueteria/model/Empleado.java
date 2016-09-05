
package org.si301.jugueteria.model;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Empleado extends Persona {
    //Atributos
    private int idEmpleado;
    private Date fechaIngreso;
    private Puesto puesto;
    private int codigo;
    private int salario;
    private boolean estatus;
    private Usuario usuario;
    private Privilegios privilegios;

    //Metodos

    //Constructor
    public Empleado() {
    }

    public Empleado(Date fechaIngreso, Puesto puesto, int codigo, int salario, boolean estatus, Usuario usuario, Privilegios privilegios) {
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.codigo = codigo;
        this.salario = salario;
        this.estatus = estatus;
        this.usuario = usuario;
        this.privilegios = privilegios;
    }
    
    public Empleado(Date fechaIngreso, Puesto puesto, int codigo, int salario, boolean estatus, Usuario usuario, Privilegios privilegios, String nombre, String apellidoPateno, String apellidoMaterno, Date fechaNacimiento, String RFC, String curp, String genero, String domicilio, String cp, Long telefono, String estado, String ciudad) {
        super(nombre, apellidoPateno, apellidoMaterno, fechaNacimiento, RFC, curp, genero, domicilio, cp, telefono, estado, ciudad);
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.codigo = codigo;
        this.salario = salario;
        this.estatus = estatus;
        this.usuario = usuario;
        this.privilegios = privilegios;
    }
    
    //Seccion de metodos gettes and settes
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Privilegios getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Privilegios privilegios) {
        this.privilegios = privilegios;
    }

}//fin de la clase, despues de esta linea no va nada