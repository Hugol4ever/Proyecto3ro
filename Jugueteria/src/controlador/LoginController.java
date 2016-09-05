package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.si301.jugueteria.core.InicioSesion;
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Empleado;
import org.si301.jugueteria.model.Usuario;
import vista.Login;
import vista.Principal;

/**
 *
 * @author Hugo
 */
public class LoginController implements ActionListener {

    //Atributos
    private Login login;
    private Empleado empleado;
    private InicioSesion iniciarSesion;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.login.getBtnEntrar() == e.getSource()) {
            this.empleado.getUsuario().setUsuario(this.login.getTxtUsuario().getText());
            this.empleado.getUsuario().setContrasenia(new String(this.login.getPswdPassword().getPassword()));
            this.iniciarSesion = new InicioSesion(this.empleado, new Cliente());
            if (this.iniciarSesion.empleadoActivo()) {
                this.empleado.setPrivilegios(this.iniciarSesion.privilegios());
                PrincipalController principalC = new PrincipalController(new Principal(), this.empleado);
                principalC.iniciarVista();
                this.login.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Imagin", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void iniciarVista() {
        this.login.setLocationRelativeTo(null);
        this.login.setVisible(true);
    }

    //Constructor
    public LoginController(Login login, Empleado empleado) {
        this.login = login;
        this.empleado = empleado;
        this.empleado.setUsuario(new Usuario());

        this.login.getBtnEntrar().addActionListener(this);
        this.login.getBtnSalir().addActionListener(this);
    }

    //Seccion de metodos gettes and settes
}//fin de la clase, despues de esta linea no va nada
