package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.commons.Globals;
import org.si301.jugueteria.core.ModuloClientes;
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Usuario;
import vista.CapturaClientes;

/**
 *
 * @author Hugo
 */
public class CapturaClientesController implements ActionListener {

    //Atributos

    private ModuloClientes moduloClientes;
    private CapturaClientes capturaClientes;
    private DefaultTableModel tabla;
    private Timer reloj;
    private Calendar c2;
    private int id;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.capturaClientes.getBtnCancelar() == e.getSource()) {
            reinicio();
        } else if (this.capturaClientes.getBtnModificar() == e.getSource()) {
            Cliente cliente = new Cliente(this.capturaClientes.getDtchRegistro().getDate(),
                    this.capturaClientes.getLblHora().getText(), true,
                    this.capturaClientes.getTxtEmail().getText(), new Usuario(),
                    this.capturaClientes.getTxtNombres().getText(),
                    this.capturaClientes.getTxtApellidoPaterno().getText(),
                    this.capturaClientes.getTxtApellidoMaterno().getText(),
                    this.capturaClientes.getDtchFechaNac().getDate(),
                    this.capturaClientes.getTxtRFC().getText(),
                    this.capturaClientes.getTxtCurp().getText(),
                    this.capturaClientes.getCmbxGenero().getSelectedItem().toString(),
                    this.capturaClientes.getTxtDomicilio().getText(),
                    this.capturaClientes.getTxtCP().getText(),
                    Long.parseLong(this.capturaClientes.getTxtTelefono().getText()),
                    this.capturaClientes.getTxtEstado().getText(),
                    this.capturaClientes.getTxtCiudad().getText());
            cliente.setIdCliente(id);
            cliente.getUsuario().setContrasenia(new String(this.capturaClientes.getPswdContrasenia().getPassword()));
            if (this.moduloClientes.modificarCliente(cliente)) {
                JOptionPane.showMessageDialog(null, "Cliente modificado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                reinicio();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el cliente", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturaClientes.getBtnNuevo() == e.getSource()) {
            reinicio();
        } else if (this.capturaClientes.getBtnRegistrar() == e.getSource()) {
            Cliente cliente = new Cliente(this.capturaClientes.getDtchRegistro().getDate(),
                    this.capturaClientes.getLblHora().getText(), true,
                    this.capturaClientes.getTxtEmail().getText(), new Usuario(),
                    this.capturaClientes.getTxtNombres().getText(),
                    this.capturaClientes.getTxtApellidoPaterno().getText(),
                    this.capturaClientes.getTxtApellidoMaterno().getText(),
                    this.capturaClientes.getDtchFechaNac().getDate(),
                    this.capturaClientes.getTxtRFC().getText(),
                    this.capturaClientes.getTxtCurp().getText(),
                    this.capturaClientes.getCmbxGenero().getSelectedItem().toString(),
                    this.capturaClientes.getTxtDomicilio().getText(),
                    this.capturaClientes.getTxtCP().getText(),
                    Long.parseLong(this.capturaClientes.getTxtTelefono().getText()),
                    this.capturaClientes.getTxtEstado().getText(),
                    this.capturaClientes.getTxtCiudad().getText());
            cliente.getUsuario().setUsuario(this.capturaClientes.getTxtUsuario().getText());
            cliente.getUsuario().setContrasenia(new String(this.capturaClientes.getPswdContrasenia().getPassword()));
            cliente.getUsuario().setPerfil("Cliente");
            if (this.moduloClientes.insertarCliente(cliente)) {
                JOptionPane.showMessageDialog(null, "Cliente registrado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                reinicio();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar el cliente", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturaClientes.getBtnEliminar() == e.getSource()) {
            if (this.capturaClientes.getTblClientes().getSelectedRow() >= 0) {
                int id = Integer.parseInt(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 0).toString());
                int desicion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar al cliente?", "Imagin", JOptionPane.YES_NO_OPTION);
                if (JOptionPane.YES_OPTION == desicion) {
                    if (this.moduloClientes.bajaCliente(id)) {
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
            this.capturaClientes.dispose();
        }
    }

    public void iniciarVista() {
        cargarTabla();
        actualizarTabla();
        cargarCmbxGenero();
        this.reloj.start();
        this.capturaClientes.getDtchRegistro().setEnabled(false);
        reinicio();
        this.capturaClientes.getBtnEliminar().setVisible(false);
    }

    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("Id Cliente");
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
        this.tabla.addColumn("Ciudad");
        this.tabla.addColumn("Estado");
        this.tabla.addColumn("Fecha de registro");
        this.tabla.addColumn("Hora de registro");
        this.tabla.addColumn("e-mail");
        this.tabla.addColumn("Usuario");
        this.tabla.addColumn("Contraseña");
        this.capturaClientes.getTblClientes().setModel(tabla);
    }

    public void reinicio() {
        this.reloj.start();
        this.capturaClientes.getDtchRegistro().setCalendar(c2);

        this.capturaClientes.getBtnCancelar().setEnabled(false);
        this.capturaClientes.getBtnModificar().setEnabled(false);
        this.capturaClientes.getBtnRegistrar().setEnabled(true);
        this.capturaClientes.getBtnEliminar().setVisible(false);

        this.capturaClientes.getTxtNombres().setText(null);
        this.capturaClientes.getTxtApellidoPaterno().setText(null);
        this.capturaClientes.getTxtApellidoMaterno().setText(null);
        this.capturaClientes.getDtchFechaNac().setDate(null);
        this.capturaClientes.getTxtRFC().setText(null);
        this.capturaClientes.getTxtCurp().setText(null);
        this.capturaClientes.getCmbxGenero().setSelectedIndex(0);
        this.capturaClientes.getTxtDomicilio().setText(null);
        this.capturaClientes.getTxtCP().setText(null);
        this.capturaClientes.getTxtTelefono().setText(null);
        this.capturaClientes.getTxtCiudad().setText(null);
        this.capturaClientes.getTxtEstado().setText(null);
        this.capturaClientes.getTxtEmail().setText(null);
        this.capturaClientes.getTxtUsuario().setText(null);
        this.capturaClientes.getPswdContrasenia().setText(null);
    }

    public void actualizarTabla() {
        while (this.capturaClientes.getTblClientes().getRowCount() > 0) {
            ((DefaultTableModel) this.capturaClientes.getTblClientes().getModel()).removeRow(0);
        }
        ArrayList<Cliente> clientes = this.moduloClientes.clienteActivos();
        for (Cliente cliente1 : clientes) {
            Object[] res = {cliente1.getIdCliente(), cliente1.getNombre(), cliente1.getApellidoPateno(),
                cliente1.getApellidoMaterno(), cliente1.getFechaNacimiento(), cliente1.getRFC(),
                cliente1.getCurp(), cliente1.getGenero(), cliente1.getDomicilio(),
                cliente1.getCp(), cliente1.getTelefono(), cliente1.getCiudad(), cliente1.getEstado(),
                cliente1.getFechaRegistro(), cliente1.getHoraRegistro(), cliente1.getEmail(),
                cliente1.getUsuario().getUsuario(), cliente1.getUsuario().getContrasenia()};
            this.tabla.addRow(res);
        }
    }

    public void tablaMouseClicked(MouseEvent e) {
        this.capturaClientes.getBtnCancelar().setEnabled(true);
        this.capturaClientes.getBtnModificar().setEnabled(true);
        this.capturaClientes.getBtnRegistrar().setEnabled(false);
        this.reloj.stop();
        this.capturaClientes.getBtnEliminar().setVisible(true);
        this.id = (int) this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 0);
        this.capturaClientes.getTxtNombres().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 1).toString());
        this.capturaClientes.getTxtApellidoPaterno().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 2).toString());
        this.capturaClientes.getTxtApellidoMaterno().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 3).toString());
        this.capturaClientes.getDtchFechaNac().setDate((Date) this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 4));
        this.capturaClientes.getTxtRFC().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 5).toString());
        this.capturaClientes.getTxtCurp().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 6).toString());
        this.capturaClientes.getCmbxGenero().setSelectedItem(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 7).toString());
        this.capturaClientes.getTxtDomicilio().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 8).toString());
        this.capturaClientes.getTxtCP().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 9).toString());
        this.capturaClientes.getTxtTelefono().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 10).toString());
        this.capturaClientes.getTxtCiudad().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 11).toString());
        this.capturaClientes.getTxtEstado().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 12).toString());
        this.capturaClientes.getDtchRegistro().setDate((Date) this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 13));
        this.capturaClientes.getLblHora().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 14).toString());
        this.capturaClientes.getTxtEmail().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 15).toString());
        this.capturaClientes.getTxtUsuario().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 16).toString());
        this.capturaClientes.getPswdContrasenia().setText(this.capturaClientes.getTblClientes().getValueAt(this.capturaClientes.getTblClientes().getSelectedRow(), 17).toString());
    }

    public void cargarCmbxGenero() {
        this.capturaClientes.getCmbxGenero().removeAllItems();
        this.capturaClientes.getCmbxGenero().addItem("Seleccione un genero...");
        this.capturaClientes.getCmbxGenero().addItem("Masculino");
        this.capturaClientes.getCmbxGenero().addItem("Femenino");
    }

    public void horaFecha() {
        this.reloj = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hora(e);
            }
        });

        this.capturaClientes.getDtchRegistro().setCalendar(c2);
    }

    public void hora(ActionEvent e) {
        this.capturaClientes.getLblHora().setText(Globals.TIME_FORMAT.format(new Date()));
    }
    
    public void usuarioCorreo(FocusEvent evt) {
        this.capturaClientes.getTxtUsuario().setText(this.capturaClientes.getTxtEmail().getText());
    }

    //Constructor
    public CapturaClientesController(ModuloClientes moduloClientes, CapturaClientes capturaClientes) {
        this.c2 = new GregorianCalendar();
        this.moduloClientes = moduloClientes;
        this.capturaClientes = capturaClientes;

        this.capturaClientes.getBtnCancelar().addActionListener(this);
        this.capturaClientes.getBtnModificar().addActionListener(this);
        this.capturaClientes.getBtnNuevo().addActionListener(this);
        this.capturaClientes.getBtnRegistrar().addActionListener(this);
        this.capturaClientes.getBtnSalir().addActionListener(this);
        this.capturaClientes.getBtnEliminar().addActionListener(this);

        this.capturaClientes.getTblClientes().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evento) {
                tablaMouseClicked(evento);
            }
        });

        horaFecha();
        
        this.capturaClientes.getTxtEmail().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent evt) {
                usuarioCorreo(evt);
            }
        });
    }

    //Seccion de metodos gettes and settes
}//fin de la clase, despues de esta linea no va nada
