
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.core.ModuloClientes;
import org.si301.jugueteria.core.ModuloPedidos;
import org.si301.jugueteria.core.ModuloProductos;
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Pedido;
import org.si301.jugueteria.model.PedidoProducto;
import org.si301.jugueteria.model.Producto;
import vista.CapturarPedidos;

/**
 *
 * @author Hugo
 */
public class CapturaPedidosController implements ActionListener {
    //Atributos
    private CapturarPedidos capturarPedidos;
    private ModuloPedidos moduloPedidos;
    private ModuloClientes moduloClientes;
    private ModuloProductos moduloProductos;
    private DefaultTableModel tabla;
    private double total;
    private int idC;
    private Calendar c2;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.capturarPedidos.getBtnAgregar() == e.getSource()) {
            if (this.capturarPedidos.getCmbxProducto().getSelectedIndex() > 0) {
                if (this.capturarPedidos.getCmbxCliente().getSelectedIndex() > 0) {
                    if (!this.capturarPedidos.getTxtCantidad().getText().equals("")) {
                        agregarProducto(this.capturarPedidos.getCmbxProducto().getSelectedItem().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Escriba una cantidad", "Imagin", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente", "Imagin", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturarPedidos.getBtnCancelar() == e.getSource()) {
            
        } else if (this.capturarPedidos.getBtnNuevo() == e.getSource()) {
            
        } else if (this.capturarPedidos.getBtnRegistrar() == e.getSource()) {
            if (this.capturarPedidos.getCmbxCliente().getSelectedIndex() > 0) {
                sacarId();
                if (this.idC > 0) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(idC);
                    Pedido pedido = new Pedido(this.capturarPedidos.getDtchFecha().getDate(), cliente);
                    if (this.moduloPedidos.insertarPedido(pedido)) {
                        for (int i = 0; i < this.capturarPedidos.getTblProductos().getRowCount(); i++) {
                            Producto producto = new Producto();
                            producto.setIdProducto(Integer.parseInt(this.capturarPedidos.getTblProductos().getValueAt(i, 0).toString()));
                            PedidoProducto pedidoProducto = new PedidoProducto(Integer.parseInt(this.capturarPedidos.getTblProductos().getValueAt(i, 2).toString()), pedido, producto, total);
                            if (this.moduloPedidos.insertarDetalle(pedidoProducto)) {
                                System.out.println("Producto registrado con éxito");
                            } else {
                                System.out.println("Ocurrió un error");
                            }
                        }
                        reinicio();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente", "Imagin", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un cliente", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturarPedidos.getBtnSalir() == e.getSource()) {
            this.capturarPedidos.dispose();
        } else {
            quitarProducto();
        }
    }
    
    public void iniciarVista() {
        cargarTabla();
        reinicio();
        cargarCmbxCliente();
        cargarCmbxProducto();
        this.capturarPedidos.getDtchFecha().setCalendar(c2);
    }
    
    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("IdProducto");
        this.tabla.addColumn("Nombre");
        this.tabla.addColumn("Cantidad");
        this.tabla.addColumn("Precio del producto");
        this.tabla.addColumn("Total");
        this.capturarPedidos.getTblProductos().setModel(tabla);
    }
    
    public void reinicio() {
        this.capturarPedidos.getBtnRegistrar().setEnabled(false);
        while (this.capturarPedidos.getTblProductos().getRowCount() > 0) {
            ((DefaultTableModel) this.capturarPedidos.getTblProductos().getModel()).removeRow(0);
        }
    }
    
    public void cargarCmbxCliente() {
        this.capturarPedidos.getCmbxCliente().removeAllItems();
        this.capturarPedidos.getCmbxCliente().addItem("Seleccione un cliente...");
        ArrayList<Cliente> clientes = this.moduloClientes.clienteActivos();
        for (Cliente cliente : clientes) {
            this.capturarPedidos.getCmbxCliente().addItem(cliente.getNombre());
        }
    }
    
    public void sacarId() {
        ArrayList<Cliente> clientes = this.moduloClientes.clienteActivos();
        for (Cliente cliente : clientes) {
            if (this.capturarPedidos.getCmbxCliente().getSelectedItem().toString().equals(cliente.getNombre())) {
                this.idC = cliente.getIdCliente();
                break;
            }
        }
    }
    
    public void cargarCmbxProducto() {
        this.capturarPedidos.getCmbxProducto().removeAllItems();
        this.capturarPedidos.getCmbxProducto().addItem("Seleccione un producto...");
        ArrayList<Producto> productos = this.moduloProductos.productosActivos();
        for (Producto producto : productos) {
            this.capturarPedidos.getCmbxProducto().addItem(producto.getNombre());
        }
    }
    
    public void quitarProducto() {
        int fila = this.capturarPedidos.getTblProductos().getSelectedRow();
        if (fila >= 0) {
            this.total = this.total - Double.parseDouble(this.capturarPedidos.getTblProductos().getValueAt(fila, 4).toString());
            this.capturarPedidos.getTxtTotal().setText(String.valueOf(this.total));
            this.tabla.removeRow(fila);
        }
    }
    
    public void agregarProducto(String nombre) {
        ArrayList<Producto> productos = this.moduloProductos.productosActivos();
        for (Producto producto : productos) {
            if (nombre.equals(producto.getNombre())) {
                double tot = Double.parseDouble(this.capturarPedidos.getTxtCantidad().getText()) * producto.getPrecio();
                Object[] fila = {producto.getIdProducto(), producto.getNombre(), this.capturarPedidos.getTxtCantidad().getText(), 
                                producto.getPrecio(), tot};
                this.tabla.addRow(fila);
                this.total += tot;
                this.capturarPedidos.getTxtTotal().setText(String.valueOf(total));
                this.capturarPedidos.getCmbxProducto().setSelectedIndex(0);
                this.capturarPedidos.getTxtCantidad().setText(null);
                this.capturarPedidos.getBtnRegistrar().setEnabled(true);
                break;
            }
        }
    }

    //Constructor
    public CapturaPedidosController(CapturarPedidos capturarPedidos, ModuloPedidos moduloPedidos, ModuloClientes moduloClientes, ModuloProductos moduloProductos) {
        this.capturarPedidos = capturarPedidos;
        this.moduloPedidos = moduloPedidos;
        this.moduloClientes = moduloClientes;
        this.moduloProductos = moduloProductos;
        this.total = 0;
        this.c2 = new GregorianCalendar();
        
        this.capturarPedidos.getBtnAgregar().addActionListener(this);
        this.capturarPedidos.getBtnCancelar().addActionListener(this);
        this.capturarPedidos.getBtnNuevo().addActionListener(this);
        this.capturarPedidos.getBtnRegistrar().addActionListener(this);
        this.capturarPedidos.getBtnSalir().addActionListener(this);
        this.capturarPedidos.getMniQuitar().addActionListener(this);
        this.capturarPedidos.getTblProductos().setComponentPopupMenu(this.capturarPedidos.getPopupMenu());
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada