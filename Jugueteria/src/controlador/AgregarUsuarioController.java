package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.core.ModuloEmpleados;
import org.si301.jugueteria.core.ModuloPrivilegios;
import org.si301.jugueteria.model.Empleado;
import org.si301.jugueteria.model.Privilegios;
import vista.AgregarUsuario;

/**
 *
 * @author Hugo
 */
public class AgregarUsuarioController implements ActionListener {

    //Atributos

    private ModuloPrivilegios moduloPrivilegios;
    private ModuloEmpleados moduloEmpleados;
    private Empleado empleado;
    private Privilegios privilegios;
    private AgregarUsuario agregarUsuario;
    private DefaultTableModel tabla;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.agregarUsuario.getBtnGuardar() == e.getSource()) {
            Privilegios pri = new Privilegios(
                    this.agregarUsuario.getChBxABCC().isSelected(),
                    this.agregarUsuario.getChBxInfC().isSelected(),
                    this.agregarUsuario.getChBxABCE().isSelected(),
                    this.agregarUsuario.getChBxInfE().isSelected(),
                    this.agregarUsuario.getChBxABCP().isSelected(),
                    this.agregarUsuario.getChBxInfP().isSelected(),
                    this.agregarUsuario.getChBxABCV().isSelected(),
                    this.agregarUsuario.getChBxInfV().isSelected(),
                    this.agregarUsuario.getChBxInfCo().isSelected(),
                    this.agregarUsuario.getChBxABCPe().isSelected(),
                    this.agregarUsuario.getChBxInfPe().isSelected(),
                    this.agregarUsuario.getChBxABCU().isSelected(),
                    this.agregarUsuario.getChBxABCM().isSelected(),
                    this.agregarUsuario.getChBxABCPu().isSelected(),
                    this.agregarUsuario.getChBxABCCa().isSelected(),
                    this.agregarUsuario.getChBxABCCo().isSelected(),
                    this.agregarUsuario.getChBxInfA().isSelected());
            pri.setIdPrivilegio(this.privilegios.getIdPrivilegio());
            if (this.moduloPrivilegios.modificarPrivilegios(pri)) {
                JOptionPane.showMessageDialog(null, "Usuario modificado", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
                limpiar();
                actualizarTabla();
            }
        } else if (this.agregarUsuario.getBtnReestablecer() == e.getSource()) {
            this.empleado.getUsuario().setContrasenia(this.agregarUsuario.getTblUsuarios().getValueAt(this.agregarUsuario.getTblUsuarios().getSelectedRow(), 4).toString());
            if (this.moduloEmpleados.modificarEmpleado(empleado)) {
                JOptionPane.showMessageDialog(null, "La contraseña se ha reestablecido exitosamente", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.agregarUsuario.dispose();
        }
    }

    public void iniciarVista() {
        cargarTabla();
        actualizarTabla();
    }

    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("IdEmpleado");
        this.tabla.addColumn("Nombre");
        this.tabla.addColumn("Apellido paterno");
        this.tabla.addColumn("Apellido materno");
        this.tabla.addColumn("Usuario");
        this.tabla.addColumn("Contrasenia");
        this.tabla.addColumn("IdPrivilegios");
        this.agregarUsuario.getTblUsuarios().setModel(tabla);
    }

    public void actualizarTabla() {
        while (this.agregarUsuario.getTblUsuarios().getRowCount() > 0) {
            ((DefaultTableModel) this.agregarUsuario.getTblUsuarios().getModel()).removeRow(0);
        }
        ArrayList<Empleado> empleados = this.moduloEmpleados.empleadosActivos();
        for (Empleado empleado1 : empleados) {
            Object[] fila = {empleado1.getIdEmpleado(), empleado1.getNombre(), empleado1.getApellidoPateno(),
                empleado1.getApellidoMaterno(), empleado1.getUsuario().getUsuario(), empleado1.getUsuario().getContrasenia(),
                empleado1.getPrivilegios().getIdPrivilegio()};
            this.tabla.addRow(fila);
        }
    }

    public void tablaMouseClicked(MouseEvent e) {
        this.privilegios = new Privilegios();
        this.privilegios.setIdPrivilegio(Integer.parseInt(this.agregarUsuario.getTblUsuarios().getValueAt(this.agregarUsuario.getTblUsuarios().getSelectedRow(), 6).toString()));
        ArrayList<Privilegios> privilegiosC = this.moduloPrivilegios.privilegios();
        for (Privilegios privilegiosC1 : privilegiosC) {
            if (this.privilegios.getIdPrivilegio() == privilegiosC1.getIdPrivilegio()) {
                this.privilegios = privilegiosC1;
                setPrivilegios();
                restablecerDatos();
                break;
            }
        }
    }

    public void setPrivilegios() {
        this.agregarUsuario.getTxtEmpleado().setText(this.agregarUsuario.getTblUsuarios().getValueAt(this.agregarUsuario.getTblUsuarios().getSelectedRow(), 1).toString());
        this.agregarUsuario.getTxtPassword().setText(this.agregarUsuario.getTblUsuarios().getValueAt(this.agregarUsuario.getTblUsuarios().getSelectedRow(), 5).toString());
        this.agregarUsuario.getTxtUsuarios().setText(this.agregarUsuario.getTblUsuarios().getValueAt(this.agregarUsuario.getTblUsuarios().getSelectedRow(), 4).toString());
        this.agregarUsuario.getChBxInfE().setSelected(this.privilegios.isRep_empleado());
        this.agregarUsuario.getChBxInfC().setSelected(this.privilegios.isRep_cliente());
        this.agregarUsuario.getChBxInfP().setSelected(this.privilegios.isRep_producto());
        this.agregarUsuario.getChBxInfV().setSelected(this.privilegios.isRep_venta());
        this.agregarUsuario.getChBxInfCo().setSelected(this.privilegios.isRep_compra());
        this.agregarUsuario.getChBxInfPe().setSelected(this.privilegios.isRep_pedido());
        this.agregarUsuario.getChBxInfA().setSelected(this.privilegios.isRep_almacen());
        this.agregarUsuario.getChBxABCE().setSelected(this.privilegios.isABC_empleado());
        this.agregarUsuario.getChBxABCC().setSelected(this.privilegios.isABC_cliente());
        this.agregarUsuario.getChBxABCP().setSelected(this.privilegios.isABC_producto());
        this.agregarUsuario.getChBxABCPu().setSelected(this.privilegios.isAdd_puesto());
        this.agregarUsuario.getChBxABCU().setSelected(this.privilegios.isAdd_user());
        this.agregarUsuario.getChBxABCM().setSelected(this.privilegios.isAdd_marca());
        this.agregarUsuario.getChBxABCV().setSelected(this.privilegios.isABC_venta());
        this.agregarUsuario.getChBxABCPe().setSelected(this.privilegios.isABC_pedido());
        this.agregarUsuario.getChBxABCCo().setSelected(this.privilegios.isAbastecer_almacen());
        this.agregarUsuario.getChBxABCCa().setSelected(this.privilegios.isAdd_categoria());
    }

    public void limpiar() {
        this.agregarUsuario.getTxtEmpleado().setText(null);
        this.agregarUsuario.getTxtPassword().setText(null);
        this.agregarUsuario.getTxtUsuarios().setText(null);
        this.agregarUsuario.getChBxInfE().setSelected(false);
        this.agregarUsuario.getChBxInfC().setSelected(false);
        this.agregarUsuario.getChBxInfP().setSelected(false);
        this.agregarUsuario.getChBxInfV().setSelected(false);
        this.agregarUsuario.getChBxInfCo().setSelected(false);
        this.agregarUsuario.getChBxInfPe().setSelected(false);
        this.agregarUsuario.getChBxInfA().setSelected(false);
        this.agregarUsuario.getChBxABCE().setSelected(false);
        this.agregarUsuario.getChBxABCC().setSelected(false);
        this.agregarUsuario.getChBxABCP().setSelected(false);
        this.agregarUsuario.getChBxABCPu().setSelected(false);
        this.agregarUsuario.getChBxABCU().setSelected(false);
        this.agregarUsuario.getChBxABCM().setSelected(false);
        this.agregarUsuario.getChBxABCV().setSelected(false);
        this.agregarUsuario.getChBxABCPe().setSelected(false);
        this.agregarUsuario.getChBxABCCo().setSelected(false);
        this.agregarUsuario.getChBxABCCa().setSelected(false);
    }

    public void restablecerDatos() {
        ArrayList<Empleado> datos = this.moduloEmpleados.empleadosActivos();
        for (Empleado dato : datos) {
            if (dato.getIdEmpleado() == this.empleado.getIdEmpleado()) {
                this.empleado = dato;
                break;
            }
        }
    }

    //Constructor
    public AgregarUsuarioController(ModuloPrivilegios moduloPrivilegios, ModuloEmpleados moduloEmpleados, Empleado empleado, AgregarUsuario agregarUsuario) {
        this.moduloPrivilegios = moduloPrivilegios;
        this.moduloEmpleados = moduloEmpleados;
        this.empleado = empleado;
        this.agregarUsuario = agregarUsuario;

        this.agregarUsuario.getBtnGuardar().addActionListener(this);
        this.agregarUsuario.getBtnReestablecer().addActionListener(this);
        this.agregarUsuario.getBtnSalir().addActionListener(this);

        this.agregarUsuario.getTblUsuarios().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evento) {
                tablaMouseClicked(evento);
            }
        });
    }

    //Seccion de metodos gettes and settes
}//fin de la clase, despues de esta linea no va nada
