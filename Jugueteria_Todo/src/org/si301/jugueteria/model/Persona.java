
package org.si301.jugueteria.model;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Persona {
    //Atributos
    private int idPersona;
    private String nombre;
    private String apellidoPateno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String RFC;
    private String curp;
    private String genero;
    private String domicilio;
    private String cp;
    private Long telefono;
    private String estado;
    private String ciudad;

    //Metodos

    //Constructor
    public Persona() {
    }

    public Persona(String nombre, String apellidoPateno, String apellidoMaterno, Date fechaNacimiento, String RFC, String curp, String genero, String domicilio, String cp, Long telefono, String estado, String ciudad) {
        this.nombre = nombre;
        this.apellidoPateno = apellidoPateno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.RFC = RFC;
        this.curp = curp;
        this.genero = genero;
        this.domicilio = domicilio;
        this.cp = cp;
        this.telefono = telefono;
        this.estado = estado;
        this.ciudad = ciudad;
    }
    
    //Seccion de metodos gettes and settes
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPateno() {
        return apellidoPateno;
    }

    public void setApellidoPateno(String apellidoPateno) {
        this.apellidoPateno = apellidoPateno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}//fin de la clase, despues de esta linea no va nada