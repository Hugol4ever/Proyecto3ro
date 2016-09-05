
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.si301.jugueteria.core.ModuloEmpleados;
import org.si301.jugueteria.model.Empleado;
import vista.CambiarPassword;

/**
 *
 * @author Hugo
 */
public class CambiarPasswordController implements ActionListener {
    //Atributos
    private CambiarPassword cambiarPassword;
    private ModuloEmpleados moduloEmpleado;
    private Empleado empleado;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.cambiarPassword.getBtnGuardar() == e.getSource()) {
            int desicion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar su contraseña?", "Imagin", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == desicion) {
                if (new String(this.cambiarPassword.getPwdAnterior().getPassword()).equals(this.empleado.getUsuario().getContrasenia())) {
                    if (new String(this.cambiarPassword.getPwdNueva().getPassword()).equals(new String(this.cambiarPassword.getPwdRepetir().getPassword()))) {
                        this.empleado.getUsuario().setContrasenia(new String(this.cambiarPassword.getPwdNueva().getPassword()));
                        if (this.moduloEmpleado.modificarEmpleado(empleado)) {
                            JOptionPane.showMessageDialog(null, "La contraseña se ha modificado exitosamente", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden\nPor favor, introduzca la misma contraseña", "Imagin", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña anterior no coincide\nPor favor, introduzca su contraeña anteriror", "Imagin", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            this.cambiarPassword.dispose();
        }
    }
    
    public void restablecerDatos() {
        ArrayList<Empleado> datos = this.moduloEmpleado.empleadosActivos();
        for (Empleado dato : datos) {
            if (dato.getIdEmpleado() == this.empleado.getIdEmpleado()) {
                this.empleado = dato;
                break;
            }
        }
    }
    
    public void iniciarVista() {
        restablecerDatos();
    }
    
    public void limpiar() {
        restablecerDatos();
        this.cambiarPassword.getPwdAnterior().setText(null);
        this.cambiarPassword.getPwdNueva().setText(null);
        this.cambiarPassword.getPwdRepetir().setText(null);
    }

    //Constructor
    public CambiarPasswordController(CambiarPassword CambiarPassword, ModuloEmpleados moduloEmpleado, Empleado empleado) {
        this.cambiarPassword = CambiarPassword;
        this.moduloEmpleado = moduloEmpleado;
        this.empleado = empleado;
        
        this.cambiarPassword.getBtnGuardar().addActionListener(this);
        this.cambiarPassword.getBtnSalir().addActionListener(this);
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada