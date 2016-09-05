
package lanzador;

import controlador.LoginController;
import vista.Login;
import org.si301.jugueteria.model.Empleado;

/**
 *
 * @author Hugo
 */
public class Principal {
    //Seccion de variables globales y de variables de clase

    //Seccion de constructor de la clase

    //Seccion de metodos generales

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginController loginC = new LoginController(new Login(), new Empleado());
        loginC.iniciarVista();
    }//fin main

    //Seccion de metodos Override

    //Seccion de gettes and settes

}//fin de la clase, no se escribe nada despues de esta linea