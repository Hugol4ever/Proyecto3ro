
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class Usuario {
    //Atributos
    private int idUsuario;
    private String usuario;
    private String contrasenia;
    private String perfil;

    //Metodos

    //Constructor
    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia, String perfil) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.perfil = perfil;
    }

    //Seccion de metodos gettes and settes
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}//fin de la clase, despues de esta linea no va nada