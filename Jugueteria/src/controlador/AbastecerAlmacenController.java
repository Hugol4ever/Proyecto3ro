
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.core.ModuloCompras;
import org.si301.jugueteria.core.ModuloProductos;
import org.si301.jugueteria.model.Compra;
import org.si301.jugueteria.model.CompraProducto;
import org.si301.jugueteria.model.Empleado;
import org.si301.jugueteria.model.Producto;
import vista.AbastecerAlmacen;

/**
 *
 * @author Hugo
 */
public class AbastecerAlmacenController implements ActionListener {
    //Atributos
    private AbastecerAlmacen abA;
    private ModuloProductos moduloProductos;
    private ModuloCompras moduloCompras;
    private Empleado empleado;
    private DefaultTableModel tabla;
    private double total;
    private Calendar c2;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.abA.getBtnAgregar() == e.getSource()) {
            if (this.abA.getCmbxProducto().getSelectedIndex() > 0) {
                if (!this.abA.getTxtCantidad().getText().equals("")) {
                    if (!this.abA.getTxtPrecio().getText().equals("")) {
                        agregarProducto(this.abA.getCmbxProducto().getSelectedItem().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Teclee un precio para el producto", "Imagin", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Teclee una cantidad para el producto", "Imagin", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.abA.getBtnCancelar() == e.getSource()) {
            limpiar();
        } else if (this.abA.getBtnGuardar() == e.getSource()) {
            Compra compra = new Compra(this.abA.getDtchFecha().getDate(), this.empleado);
            if (this.moduloCompras.insertarCompra(compra)) {
                for (int i = 0; i < this.abA.getTblProductos().getRowCount(); i++) {
                    Producto producto = new Producto();
                    producto.setIdProducto(Integer.parseInt(this.abA.getTblProductos().getValueAt(i, 0).toString()));
                    CompraProducto compraProducto = new CompraProducto(Double.parseDouble(this.abA.getTblProductos().getValueAt(i, 7).toString()), Integer.parseInt(this.abA.getTblProductos().getValueAt(i, 6).toString()), compra, producto);
                    if (this.moduloCompras.insertarDetalle(compraProducto)) {
                        System.out.println("Producto registrado con éxito");
                    }
                }
                JOptionPane.showMessageDialog(null, "Compra registrada con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }
        } else if (this.abA.getMniQuitar() == e.getSource()) {
            quitarProducto();
        }else {
            this.abA.dispose();
        }
    }
    
    public void iniciarVista() {
        cargarCmbx();
        cargarTabla();
        this.abA.getBtnGuardar().setEnabled(false);
        this.abA.getTxtEmpleado().setText(this.empleado.getNombre());
        this.abA.getDtchFecha().setCalendar(c2);
        this.abA.getPopMenu().add(this.abA.getMniQuitar());
    }
    
    public void cargarCmbx() {
        this.abA.getCmbxProducto().removeAllItems();
        this.abA.getCmbxProducto().addItem("Seleccione un producto...");
        ArrayList<Producto> productos = this.moduloProductos.productosActivos();
        for (Producto producto : productos) {
            this.abA.getCmbxProducto().addItem(producto.getNombre());
        }
    }
    
    public void agregarProducto(String nombre) {
        ArrayList<Producto> productos = this.moduloProductos.productosActivos();
        for (Producto producto : productos) {
            if (nombre.equals(producto.getNombre())) {
                double tot = Double.parseDouble(this.abA.getTxtCantidad().getText()) * Double.parseDouble(this.abA.getTxtPrecio().getText());
                Object[] fila = {producto.getIdProducto(), producto.getNombre(), producto.getModelo(),
                                producto.getMarca().getMarca(), producto.getExistencia(), 
                                producto.getCategoria().getCategoria(), this.abA.getTxtCantidad().getText(), 
                                this.abA.getTxtPrecio().getText(), tot};
                this.tabla.addRow(fila);
                this.total += tot;
                this.abA.getTxtTotal().setText(String.valueOf(total));
                this.abA.getCmbxProducto().setSelectedIndex(0);
                this.abA.getTxtCantidad().setText(null);
                this.abA.getTxtPrecio().setText(null);
                this.abA.getBtnGuardar().setEnabled(true);
                break;
            }
        }
    }
    
    public void limpiar() {
        this.abA.getCmbxProducto().setSelectedIndex(0);
        this.abA.getTxtCantidad().setText(null);
        this.abA.getTxtPrecio().setText(null);
        this.abA.getBtnGuardar().setEnabled(false);
        while (this.abA.getTblProductos().getRowCount() > 0) {
            ((DefaultTableModel) this.abA.getTblProductos().getModel()).removeRow(0);
        }
        total = 0;
        this.abA.getTxtTotal().setText(null);
    }
    
    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("IdProducto");
        this.tabla.addColumn("Nombre");
        this.tabla.addColumn("Modelo");
        this.tabla.addColumn("Marca");
        this.tabla.addColumn("Existencia");
        this.tabla.addColumn("Categoría");
        this.tabla.addColumn("Cantidad");
        this.tabla.addColumn("Precio");
        this.tabla.addColumn("Total");
        this.abA.getTblProductos().setModel(tabla);
    }
    
    public void quitarProducto() {
        int fila = this.abA.getTblProductos().getSelectedRow();
        if (fila >= 0) {
            total = total - Double.parseDouble(this.abA.getTblProductos().getValueAt(fila, 8).toString());
            this.abA.getTxtTotal().setText(String.valueOf(total));
            this.tabla.removeRow(fila);
        }
    }

    //Constructor
    public AbastecerAlmacenController(ModuloProductos moduloProductos, AbastecerAlmacen abA, ModuloCompras moduloCompras, Empleado empleado) {
        this.abA = abA;
        this.moduloProductos = moduloProductos;
        this.moduloCompras = moduloCompras;
        this.empleado = empleado;
        this.c2 = new GregorianCalendar();
        
        this.total = 0;
        this.abA.getBtnAgregar().addActionListener(this);
        this.abA.getBtnCancelar().addActionListener(this);
        this.abA.getBtnGuardar().addActionListener(this);
        this.abA.getMniQuitar().addActionListener(this);
        this.abA.getBtnSalir().addActionListener(this);
        this.abA.getTblProductos().setComponentPopupMenu(this.abA.getPopMenu());
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada