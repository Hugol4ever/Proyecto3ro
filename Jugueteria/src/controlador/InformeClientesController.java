 
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.commons.Globals;
import org.si301.jugueteria.core.ModuloClientes;
import org.si301.jugueteria.model.Cliente;
import vista.InformeClientes;

/**
 *
 * @author Hugo
 */
public class InformeClientesController implements ActionListener {
    //Atributos
    private ModuloClientes moduloClientes;
    private InformeClientes informeClientes;
    private DefaultTableModel tabla;
    private ArrayList<Cliente> clientes;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.informeClientes.getBtnBuscar() == e.getSource()) {
            while (this.informeClientes.getTblClientes().getRowCount() > 0) {
                ((DefaultTableModel) this.informeClientes.getTblClientes().getModel()).removeRow(0);
            }
            if (this.informeClientes.getRdbtnTodos().isSelected()) {
                switch (this.informeClientes.getCmbxTipos().getSelectedIndex()) {
                    case 0:
                        cargarTabla1();
                        actualizarTablaActivos();
                        break;
                    case 1:
                        cargarTabla1();
                        actualizarTablaInactivos();
                        break;
                    case 2:
                        cargarTabla2();
                        actualizarTablaTodos();
                        break;
                    default:
                        cargarTabla1();
                        actualizarTablaActivos();
                        break;
                }
            } else {
                if (!this.informeClientes.getTxtBusqueda().getText().equals("")) {
                    if (this.informeClientes.getRdbtnCodigo().isSelected()) {
                        ArrayList<Cliente> clientesC = this.clientes;
                        if (this.informeClientes.getCmbxTipos().getSelectedIndex() == 2) {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getIdCliente() == Integer.parseInt(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia(), clientesC1.isEstatus()};
                                    this.tabla.addRow(res);
                                }
                            }
                        } else {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getIdCliente()== Integer.parseInt(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia()};
                                    this.tabla.addRow(res);
                                }
                            }
                        }
                    } else if (this.informeClientes.getRdbtnNombre().isSelected()) {
                        ArrayList<Cliente> clientesC = this.clientes;
                        if (this.informeClientes.getCmbxTipos().getSelectedIndex() == 2) {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getNombre().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia(), clientesC1.isEstatus()};
                                    this.tabla.addRow(res);
                                }
                            }
                        } else {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getNombre().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia()};
                                    this.tabla.addRow(res);
                                }
                            }
                        }
                    } else if (this.informeClientes.getRdbtnDomicilio().isSelected()) {
                        ArrayList<Cliente> clientesC = this.clientes;
                        if (this.informeClientes.getCmbxTipos().getSelectedIndex() == 2) {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getDomicilio().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia(), clientesC1.isEstatus()};
                                    this.tabla.addRow(res);
                                }
                            }
                        } else {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getDomicilio().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia()};
                                    this.tabla.addRow(res);
                                }
                            }
                        }
                    } else if (this.informeClientes.getRdbtnCiudad().isSelected()) {
                        ArrayList<Cliente> clientesC = this.clientes;
                        if (this.informeClientes.getCmbxTipos().getSelectedIndex() == 2) {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getCiudad().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia(), clientesC1.isEstatus()};
                                    this.tabla.addRow(res);
                                }
                            }
                        } else {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getCiudad().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia()};
                                    this.tabla.addRow(res);
                                }
                            }
                        }
                    } else if (this.informeClientes.getRdbtnAnio().isSelected()) {
                        ArrayList<Cliente> clientesC = this.clientes;
                        if (this.informeClientes.getCmbxTipos().getSelectedIndex() == 2) {
                            for (Cliente clientesC1 : clientesC) {
                                if (Globals.YEAR_FORMAT.format(clientesC1.getFechaRegistro()).equals(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia(), clientesC1.isEstatus()};
                                    this.tabla.addRow(res);
                                }
                            }
                        } else {
                            for (Cliente clientesC1 : clientesC) {
                                if (Globals.YEAR_FORMAT.format(clientesC1.getFechaRegistro()).equals(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia()};
                                    this.tabla.addRow(res);
                                }
                            }
                        }
                    } else if (this.informeClientes.getRdbtnEstado().isSelected()) {
                        ArrayList<Cliente> clientesC = this.clientes;
                        if (this.informeClientes.getCmbxTipos().getSelectedIndex() == 2) {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getEstado().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia(), clientesC1.isEstatus()};
                                    this.tabla.addRow(res);
                                }
                            }
                        } else {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getEstado().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia()};
                                    this.tabla.addRow(res);
                                }
                            }
                        }
                    } else {
                        ArrayList<Cliente> clientesC = this.clientes;
                        if (this.informeClientes.getCmbxTipos().getSelectedIndex() == 2) {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getCp().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia(), clientesC1.isEstatus()};
                                    this.tabla.addRow(res);
                                }
                            }
                        } else {
                            for (Cliente clientesC1 : clientesC) {
                                if (clientesC1.getCp().equalsIgnoreCase(this.informeClientes.getTxtBusqueda().getText())) {
                                    Object[] res = {clientesC1.getIdCliente(), clientesC1.getNombre(), clientesC1.getApellidoPateno(),
                                        clientesC1.getApellidoMaterno(), clientesC1.getFechaNacimiento(), clientesC1.getRFC(),
                                        clientesC1.getCurp(), clientesC1.getGenero(), clientesC1.getDomicilio(),
                                        clientesC1.getCp(), clientesC1.getTelefono(), clientesC1.getCiudad(), clientesC1.getEstado(),
                                        clientesC1.getFechaRegistro(), clientesC1.getHoraRegistro(), clientesC1.getEmail(),
                                        clientesC1.getUsuario().getUsuario(), clientesC1.getUsuario().getContrasenia()};
                                    this.tabla.addRow(res);
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Escriba el prámetro de búsqueda", "Imagin", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            this.informeClientes.dispose();
        }
    }
    
    public void iniciarVista() {
        cargarTabla1();
        actualizarTablaActivos();
    }
    
    public void cargarTabla1() {
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
        this.informeClientes.getTblClientes().setModel(tabla);
    }
    
    public void cargarTabla2() {
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
        this.tabla.addColumn("Estatus");
        this.informeClientes.getTblClientes().setModel(tabla);
    }
    
    public void tipos(ItemEvent evt) {
        if (evt.getStateChange() == evt.DESELECTED) {
            switch (this.informeClientes.getCmbxTipos().getSelectedIndex()) {
                case 0:
                    cargarTabla1();
                    actualizarTablaActivos();
                    break;
                case 1:
                    cargarTabla1();
                    actualizarTablaInactivos();
                    break;
                case 2:
                    cargarTabla2();
                    actualizarTablaTodos();
                    break;
                default:
                    cargarTabla1();
                    actualizarTablaActivos();
                    break;
            }
        }
    }
    
    public void actualizarTablaActivos() {
        while (this.informeClientes.getTblClientes().getRowCount() > 0) {
            ((DefaultTableModel) this.informeClientes.getTblClientes().getModel()).removeRow(0);
        }
        this.clientes = this.moduloClientes.clienteActivos();
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
    
    public void actualizarTablaInactivos() {
        while (this.informeClientes.getTblClientes().getRowCount() > 0) {
            ((DefaultTableModel) this.informeClientes.getTblClientes().getModel()).removeRow(0);
        }
        this.clientes = this.moduloClientes.clientesInactivos();
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
    
    public void actualizarTablaTodos() {
        while (this.informeClientes.getTblClientes().getRowCount() > 0) {
            ((DefaultTableModel) this.informeClientes.getTblClientes().getModel()).removeRow(0);
        }
        this.clientes = this.moduloClientes.clientesTodos();
        for (Cliente cliente1 : clientes) {
            Object[] res = {cliente1.getIdCliente(), cliente1.getNombre(), cliente1.getApellidoPateno(),
                cliente1.getApellidoMaterno(), cliente1.getFechaNacimiento(), cliente1.getRFC(),
                cliente1.getCurp(), cliente1.getGenero(), cliente1.getDomicilio(),
                cliente1.getCp(), cliente1.getTelefono(), cliente1.getCiudad(), cliente1.getEstado(),
                cliente1.getFechaRegistro(), cliente1.getHoraRegistro(), cliente1.getEmail(),
                cliente1.getUsuario().getUsuario(), cliente1.getUsuario().getContrasenia(), cliente1.isEstatus()};
            this.tabla.addRow(res);
        }
    }

    //Constructor
    public InformeClientesController(ModuloClientes moduloClientes, InformeClientes informeClientes) {
        this.moduloClientes = moduloClientes;
        this.informeClientes = informeClientes;
        
        this.informeClientes.getBtnBuscar().addActionListener(this);
        this.informeClientes.getBtnSalir().addActionListener(this);
        
        this.informeClientes.getCmbxTipos().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                tipos(evt);
            }
        });
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada