
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class Categoria {
    //Atributos
    private int idCategoria;
    private String categoria;

    //Metodos

    //Constructor
    public Categoria() {
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    //Seccion de metodos gettes and settes
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}//fin de la clase, despues de esta linea no va nada