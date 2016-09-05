
package org.si301.jugueteria.model;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Cliente extends Persona {
    //Atributos
    private int idCliente;
    private Date fechaRegistro;
    private String horaRegistro;
    private boolean Estatus;
    private String email;
    private Usuario usuario;

    //Metodos

    //Constructor
    public Cliente() {
    }

    public Cliente(Date fechaRegistro, String horaRegistro, boolean Estatus, String email, Usuario usuario) {
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.Estatus = Estatus;
        this.email = email;
        this.usuario = usuario;
    }

    public Cliente(Date fechaRegistro, String horaRegistro, boolean Estatus, String email, Usuario usuario, String nombre, String apellidoPateno, String apellidoMaterno, Date fechaNacimiento, String RFC, String curp, String genero, String domicilio, String cp, Long telefono, String estado, String ciudad) {
        super(nombre, apellidoPateno, apellidoMaterno, fechaNacimiento, RFC, curp, genero, domicilio, cp, telefono, estado, ciudad);
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.Estatus = Estatus;
        this.email = email;
        this.usuario = usuario;
    }
    

    //Seccion de metodos gettes and settes
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(String horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public boolean isEstatus() {
        return Estatus;
    }

    public void setEstatus(boolean Estatus) {
        this.Estatus = Estatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

}//fin de la clase, despues de esta linea no va nada