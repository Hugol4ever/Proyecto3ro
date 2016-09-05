
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class Puesto {
    //Atributos
    private int idPuesto;
    private String puesto;

    //Metodos

    //Constructor
    public Puesto() {
    }
    
    public Puesto(String puesto) {
        this.puesto = puesto;
    }

    //Seccion de metodos gettes and settes
    public int getIdPuesto() {
        return idPuesto;
    }
    
    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }
    
    public String getPuesto() {
        return puesto;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}//fin de la clase, despues de esta linea no va nada