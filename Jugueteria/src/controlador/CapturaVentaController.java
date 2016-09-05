
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.commons.Globals;
import org.si301.jugueteria.core.ModuloClientes;
import org.si301.jugueteria.core.ModuloProductos;
import org.si301.jugueteria.core.ModuloVentas;
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Empleado;
import org.si301.jugueteria.model.Producto;
import org.si301.jugueteria.model.Venta;
import org.si301.jugueteria.model.VentaProducto;
import vista.CapturarVenta;

/**
 *
 * @author Hugo
 */
public class CapturaVentaController implements ActionListener {
    //Atributos
    private CapturarVenta capturaVenta;
    private ModuloVentas moduloVentas;
    private ModuloProductos moduloProductos;
    private ModuloClientes moduloClientes;
    private DefaultTableModel tabla;
    private Empleado empleado;
    private double total;
    private int idC;
    private Calendar c2;
    private Timer reloj;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.capturaVenta.getBtnAgregar() == e.getSource()) {
            if (!this.capturaVenta.getTxtCantidad().getText().equals("")) {
                if (this.capturaVenta.getCmbxProducto().getSelectedIndex() >= 0) {
                    if (comprobarExistencia(Integer.parseInt(this.capturaVenta.getTxtCantidad().getText()))) {
                        agregarProducto(this.capturaVenta.getCmbxProducto().getSelectedItem().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Productos insuficientes", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto", "Imagin", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escriba una cantidad", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturaVenta.getBtnCancelar() == e.getSource()) {
            reinicio();
        } else if (this.capturaVenta.getBtnGuardar() == e.getSource()) {
            if (this.capturaVenta.getTblProductos().getRowCount() > 0) {
                sacarId();
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idC);
                Venta venta = new Venta(this.capturaVenta.getDtchFecha().getDate(), this.capturaVenta.getTxtHora().getText(), cliente, this.empleado);
                if (this.moduloVentas.insertarVenta(venta)) {
                    for (int i = 0; i < this.capturaVenta.getTblProductos().getRowCount(); i++) {
                        VentaProducto ventaProducto = new VentaProducto();
                        Producto producto = new Producto();
                        producto.setIdProducto(Integer.parseInt(this.capturaVenta.getTblProductos().getValueAt(i, 0).toString()));
                        ventaProducto.setVenta(venta);
                        ventaProducto.setProducto(producto);
                        ventaProducto.setCantidad(Integer.parseInt(this.capturaVenta.getTblProductos().getValueAt(i, 2).toString()));
                        if (this.moduloVentas.insertarDetalle(ventaProducto)) {
                            System.out.println("Se registró el producto correctamente");
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Venta registrada con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                    reinicio();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un producto para vender", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturaVenta.getBtnNueva() == e.getSource()) {
            reinicio();
        } else if (this.capturaVenta.getBtnSalir() == e.getSource()) {
            this.capturaVenta.dispose();
        } else {
            
        }
    }
    
    public void iniciarVista() {
        reinicio();
        cargarCmbxCliente();
        cargarCmbxProducto();
        this.capturaVenta.getBtnGuardar().setEnabled(false);
        cargarTabla();
        this.capturaVenta.getTxtEmpleado().setText(this.empleado.getNombre());
        this.capturaVenta.getDtchFecha().setCalendar(c2);
    }
    
    public void reinicio() {
        this.capturaVenta.getTxtCantidad().setText(null);
        this.total = 0;
        this.capturaVenta.getCmbxCliente().setSelectedIndex(0);
        this.capturaVenta.getCmbxProducto().setSelectedIndex(0);
        while (this.capturaVenta.getTblProductos().getRowCount() > 0) {
            ((DefaultTableModel) this.capturaVenta.getTblProductos().getModel()).removeRow(0);
        }
    }
    
    public void cargarCmbxCliente() {
        this.capturaVenta.getCmbxCliente().removeAllItems();
        this.capturaVenta.getCmbxCliente().addItem("Seleccione un cliente...");
        ArrayList<Cliente> clientes = this.moduloClientes.clienteActivos();
        for (Cliente cliente : clientes) {
            this.capturaVenta.getCmbxCliente().addItem(cliente.getNombre());
        }
    }
    
    public void cargarCmbxProducto() {
        this.capturaVenta.getCmbxProducto().removeAllItems();
        this.capturaVenta.getCmbxProducto().addItem("Seleccione un producto...");
        ArrayList<Producto> productos = this.moduloProductos.productosActivos();
        for (Producto producto : productos) {
            this.capturaVenta.getCmbxProducto().addItem(producto.getNombre());
        }
    }
    
    public boolean comprobarExistencia(int cantidad) {
        boolean si = false;
        ArrayList<Producto> productos = this.moduloProductos.productosActivos();
        for (Producto producto : productos) {
            if (producto.getNombre().equals(this.capturaVenta.getCmbxProducto().getSelectedItem())) {
                if (producto.getExistencia() > cantidad) {
                    si = true;
                    break;
                }
            }
        }
        return si;
    }
    
    public void quitarProducto() {
        int fila = this.capturaVenta.getTblProductos().getSelectedRow();
        if (fila >= 0) {
            this.total = this.total - Double.parseDouble(this.capturaVenta.getTblProductos().getValueAt(fila, 4).toString());
            this.capturaVenta.getTxtTotal().setText(String.valueOf(this.total));
            this.tabla.removeRow(fila);
        }
    }
    
    public void agregarProducto(String nombre) {
        ArrayList<Producto> productos = this.moduloProductos.productosActivos();
        for (Producto producto : productos) {
            if (nombre.equals(producto.getNombre())) {
                double tot = Double.parseDouble(this.capturaVenta.getTxtCantidad().getText()) * producto.getPrecio();
                Object[] fila = {producto.getIdProducto(), producto.getNombre(), this.capturaVenta.getTxtCantidad().getText(), 
                                producto.getPrecio(), tot};
                this.tabla.addRow(fila);
                this.total += tot;
                this.capturaVenta.getTxtTotal().setText(String.valueOf(total));
                this.capturaVenta.getCmbxProducto().setSelectedIndex(0);
                this.capturaVenta.getTxtCantidad().setText(null);
                this.capturaVenta.getBtnGuardar().setEnabled(true);
                break;
            }
        }
    }
    
    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("IdProducto");
        this.tabla.addColumn("Nombre");
        this.tabla.addColumn("Cantidad");
        this.tabla.addColumn("Precio del producto");
        this.tabla.addColumn("Total");
        this.capturaVenta.getTblProductos().setModel(tabla);
    }
    
    public void hora(ActionEvent e) {
        this.capturaVenta.getTxtHora().setText(Globals.TIME_FORMAT.format(new Date()));
    }
    
    public void sacarId() {
        ArrayList<Cliente> clientes = this.moduloClientes.clienteActivos();
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(this.capturaVenta.getCmbxCliente().getSelectedItem())) {
                this.idC = cliente.getIdCliente();
                break;
            }
        }
    }

    //Constructor
    public CapturaVentaController(CapturarVenta capturaVenta, ModuloVentas moduloVentas, ModuloProductos moduloProductos, ModuloClientes moduloClientes, Empleado emleado) {
        this.capturaVenta = capturaVenta;
        this.moduloVentas = moduloVentas;
        this.moduloClientes = moduloClientes;
        this.moduloProductos = moduloProductos;
        this.empleado = emleado;
        this.c2 = new GregorianCalendar();
        
        this.capturaVenta.getBtnAgregar().addActionListener(this);
        this.capturaVenta.getBtnCancelar().addActionListener(this);
        this.capturaVenta.getBtnGuardar().addActionListener(this);
        this.capturaVenta.getBtnNueva().addActionListener(this);
        this.capturaVenta.getBtnSalir().addActionListener(this);
        this.capturaVenta.getMniQuitar().addActionListener(this);
        
        this.reloj = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hora(e);
            }
        });
        this.reloj.start();
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada