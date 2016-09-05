
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class Marca {
    //Atributos
    private int idMarca;
    private String marca;

    //Metodos

    //Constructor
    public Marca() {
    }

    public Marca(String marca) {
        this.marca = marca;
    }

    //Seccion de metodos gettes and settes
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}//fin de la clase, despues de esta linea no va nada