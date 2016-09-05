
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.core.ModuloEmpleados;
import org.si301.jugueteria.core.ModuloPuesto;
import org.si301.jugueteria.model.Empleado;
import org.si301.jugueteria.model.Privilegios;
import org.si301.jugueteria.model.Puesto;
import org.si301.jugueteria.model.Usuario;
import vista.CapturarEmpleados;

/**
 *
 * @author Hugo
 */
public class CapturaEmpleadosController implements ActionListener {
    //Atributos
    private ModuloEmpleados moduloEmpleados;
    private CapturarEmpleados capturaEmpleados;
    private Calendar c2;
    private DefaultTableModel tabla;
    private int id;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.capturaEmpleados.getBtnCancelar() == e.getSource()) {
            reinicio();
        } else if (this.capturaEmpleados.getBtnModificar() == e.getSource()) {
            Empleado empleado = new Empleado(this.capturaEmpleados.getDtchFechaIngreso().getDate(), 
                    new Puesto(), 
                    0, 
                    Integer.parseInt(this.capturaEmpleados.getTxtSalario().getText()), 
                    true, 
                    new Usuario(), 
                    new Privilegios(), 
                    this.capturaEmpleados.getTxtNombres().getText(), 
                    this.capturaEmpleados.getTxtApellidoPaterno().getText(), 
                    this.capturaEmpleados.getTxtApellidoMaterno().getText(), 
                    this.capturaEmpleados.getDtchFechaNac().getDate(), 
                    this.capturaEmpleados.getTxtRFC().getText(), 
                    this.capturaEmpleados.getTxtCURP().getText(), 
                    this.capturaEmpleados.getCmbxGenero().getSelectedItem().toString(), 
                    this.capturaEmpleados.getTxtDomicilio().getText(), 
                    this.capturaEmpleados.getTxtCp().getText(), 
                    Long.parseLong(this.capturaEmpleados.getTxtTelefono().getText()), 
                    this.capturaEmpleados.getTxtEstado().getText(), 
                    this.capturaEmpleados.getTxtCiudad().getText());
            empleado.getPuesto().setPuesto(this.capturaEmpleados.getCmbxPuesto().getSelectedItem().toString());
            empleado.getUsuario().setContrasenia(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 18).toString());
            empleado.setIdEmpleado(id);
            if (this.moduloEmpleados.modificarEmpleado(empleado)) {
                JOptionPane.showMessageDialog(null, "Empleado modificado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                reinicio();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturaEmpleados.getBtnNuevo() == e.getSource()) {
            reinicio();
        } else if (this.capturaEmpleados.getBtnRegistrar() == e.getSource()) {
            Empleado empleado = new Empleado(this.capturaEmpleados.getDtchFechaIngreso().getDate(), 
                    new Puesto(), 
                    0, 
                    Integer.parseInt(this.capturaEmpleados.getTxtSalario().getText()), 
                    true, 
                    new Usuario(), 
                    new Privilegios(), 
                    this.capturaEmpleados.getTxtNombres().getText(), 
                    this.capturaEmpleados.getTxtApellidoPaterno().getText(), 
                    this.capturaEmpleados.getTxtApellidoMaterno().getText(), 
                    this.capturaEmpleados.getDtchFechaNac().getDate(), 
                    this.capturaEmpleados.getTxtRFC().getText(), 
                    this.capturaEmpleados.getTxtCURP().getText(), 
                    this.capturaEmpleados.getCmbxGenero().getSelectedItem().toString(), 
                    this.capturaEmpleados.getTxtDomicilio().getText(), 
                    this.capturaEmpleados.getTxtCp().getText(), 
                    Long.parseLong(this.capturaEmpleados.getTxtTelefono().getText()), 
                    this.capturaEmpleados.getTxtEstado().getText(), 
                    this.capturaEmpleados.getTxtCiudad().getText());
            empleado.getUsuario().setPerfil("Empleado");
            empleado.getPuesto().setPuesto(this.capturaEmpleados.getCmbxPuesto().getSelectedItem().toString());
            if (this.moduloEmpleados.insertarEmpleado(empleado)) {
                JOptionPane.showMessageDialog(null, "Empleado registrado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                reinicio();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturaEmpleados.getBtnEliminar() == e.getSource()) {
            if (this.capturaEmpleados.getTblEmpleados().getSelectedRow() >= 0) {
                int id = Integer.parseInt(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 0).toString());
                int desicion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar al cliente?", "Imagin", JOptionPane.YES_NO_OPTION);
                if (JOptionPane.YES_OPTION == desicion) {
                    if (this.moduloEmpleados.eliminarEmpleado(id)) {
                        JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                        reinicio();
                        actualizarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un empleado de la tabla", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.capturaEmpleados.dispose();
        }
    }
    
    public void iniciarVista() {
        cargarTabla();
        actualizarTabla();
        cargarCmbxPuesto();
        cargarCmbxGenero();
        this.capturaEmpleados.getBtnEliminar().setVisible(false);
        reinicio();
    }
    
    public void cargarTabla(){
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("Id Empleado");
        this.tabla.addColumn("Nombres");
        this.tabla.addColumn("Apellido paterno");
        this.tabla.addColumn("Apellido materno");
        this.tabla.addColumn("Fecha de nacimiento");
        this.tabla.addColumn("RFC");
        this.tabla.addColumn("Curp");
        this.tabla.addColumn("Genero");
        this.tabla.addColumn("Domicilio");
        this.tabla.addColumn("Código postal");
        this.tabla.addColumn("Teléfono");
        this.tabla.addColumn("Estado");
        this.tabla.addColumn("Ciudad");
        this.tabla.addColumn("Fecha de ingreso");
        this.tabla.addColumn("Puesto");
        this.tabla.addColumn("Código de empleado");
        this.tabla.addColumn("Salario");
        this.tabla.addColumn("Usuario");
        this.tabla.addColumn("Contraseña");
        this.capturaEmpleados.getTblEmpleados().setModel(tabla);
    }
    
    public void actualizarTabla() {
        while (this.capturaEmpleados.getTblEmpleados().getRowCount() > 0) {
            ((DefaultTableModel) this.capturaEmpleados.getTblEmpleados().getModel()).removeRow(0);
        }
        ArrayList<Empleado> empleados = this.moduloEmpleados.empleadosActivos();
        for (Empleado empleado1 : empleados) {
            Object[] res = {empleado1.getIdEmpleado(), empleado1.getNombre(), empleado1.getApellidoPateno(),
                empleado1.getApellidoMaterno(), empleado1.getFechaNacimiento(), empleado1.getRFC(),
                empleado1.getCurp(), empleado1.getGenero(), empleado1.getDomicilio(),
                empleado1.getCp(), empleado1.getTelefono(), empleado1.getEstado(), empleado1.getCiudad(),
                empleado1.getFechaIngreso(), empleado1.getPuesto().getPuesto(), empleado1.getCodigo(),
                empleado1.getSalario(), empleado1.getUsuario().getUsuario(), empleado1.getUsuario().getContrasenia()};
            this.tabla.addRow(res);
        }
    }
    
    public void tablaMouseClicked(MouseEvent evt) {
        this.capturaEmpleados.getBtnCancelar().setEnabled(true);
        this.capturaEmpleados.getBtnModificar().setEnabled(true);
        this.capturaEmpleados.getBtnRegistrar().setEnabled(false);
        
        this.capturaEmpleados.getBtnEliminar().setVisible(true);
        this.id = (int) this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 0);
        this.capturaEmpleados.getTxtNombres().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 1).toString());
        this.capturaEmpleados.getTxtApellidoPaterno().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 2).toString());
        this.capturaEmpleados.getTxtApellidoMaterno().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 3).toString());
        this.capturaEmpleados.getDtchFechaNac().setDate((Date) this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 4));
        this.capturaEmpleados.getTxtRFC().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 5).toString());
        this.capturaEmpleados.getTxtCURP().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 6).toString());
        this.capturaEmpleados.getCmbxGenero().setSelectedItem(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 7).toString());
        this.capturaEmpleados.getTxtDomicilio().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 8).toString());
        this.capturaEmpleados.getTxtCp().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 9).toString());
        this.capturaEmpleados.getTxtTelefono().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 10).toString());
        this.capturaEmpleados.getTxtCiudad().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 12).toString());
        this.capturaEmpleados.getTxtEstado().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 11).toString());
        this.capturaEmpleados.getCmbxPuesto().setSelectedItem(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 14).toString());
        this.capturaEmpleados.getTxtSalario().setText(this.capturaEmpleados.getTblEmpleados().getValueAt(this.capturaEmpleados.getTblEmpleados().getSelectedRow(), 16).toString());
    }
    
    public void cargarCmbxPuesto() {
        this.capturaEmpleados.getCmbxPuesto().removeAllItems();
        ModuloPuesto modPuesto = new ModuloPuesto();
        this.capturaEmpleados.getCmbxPuesto().addItem("Seleccione un puesto...");
        ArrayList<Puesto> puestos = modPuesto.puestos();
        for (Puesto puesto : puestos) {
            this.capturaEmpleados.getCmbxPuesto().addItem(puesto.getPuesto());
        }
    }
    
    public void cargarCmbxGenero() {
        this.capturaEmpleados.getCmbxGenero().removeAllItems();
        this.capturaEmpleados.getCmbxGenero().addItem("Seleccione un genero...");
        this.capturaEmpleados.getCmbxGenero().addItem("Masculino");
        this.capturaEmpleados.getCmbxGenero().addItem("Femenino");
    }
    
    public void reinicio(){
        this.capturaEmpleados.getDtchFechaIngreso().setCalendar(c2);

        this.capturaEmpleados.getBtnCancelar().setEnabled(false);
        this.capturaEmpleados.getBtnModificar().setEnabled(false);
        this.capturaEmpleados.getBtnRegistrar().setEnabled(true);
        this.capturaEmpleados.getBtnEliminar().setVisible(false);

        this.capturaEmpleados.getTxtNombres().setText(null);
        this.capturaEmpleados.getTxtApellidoPaterno().setText(null);
        this.capturaEmpleados.getTxtApellidoMaterno().setText(null);
        this.capturaEmpleados.getDtchFechaNac().setDate(null);
        this.capturaEmpleados.getTxtRFC().setText(null);
        this.capturaEmpleados.getTxtCURP().setText(null);
        this.capturaEmpleados.getCmbxGenero().setSelectedIndex(0);
        this.capturaEmpleados.getCmbxPuesto().setSelectedIndex(0);
        this.capturaEmpleados.getTxtDomicilio().setText(null);
        this.capturaEmpleados.getTxtCp().setText(null);
        this.capturaEmpleados.getTxtTelefono().setText(null);
        this.capturaEmpleados.getTxtCiudad().setText(null);
        this.capturaEmpleados.getTxtEstado().setText(null);
        this.capturaEmpleados.getTxtSalario().setText(null);
    }

    //Constructor
    public CapturaEmpleadosController(ModuloEmpleados moduloEmpleados, CapturarEmpleados capturaEmpleados) {
        this.c2 = new GregorianCalendar();
        this.moduloEmpleados = moduloEmpleados;
        this.capturaEmpleados = capturaEmpleados;
        
        this.capturaEmpleados.getBtnCancelar().addActionListener(this);
        this.capturaEmpleados.getBtnModificar().addActionListener(this);
        this.capturaEmpleados.getBtnNuevo().addActionListener(this);
        this.capturaEmpleados.getBtnRegistrar().addActionListener(this);
        this.capturaEmpleados.getBtnEliminar().addActionListener(this);
        this.capturaEmpleados.getBtnSalir().addActionListener(this);
        
        this.capturaEmpleados.getTblEmpleados().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evento) {
                tablaMouseClicked(evento);
            }
        });
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada