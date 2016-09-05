package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.core.ModuloCategoria;
import org.si301.jugueteria.core.ModuloMarca;
import org.si301.jugueteria.core.ModuloProductos;
import org.si301.jugueteria.model.Categoria;
import org.si301.jugueteria.model.Marca;
import org.si301.jugueteria.model.Producto;
import vista.CapturarProductos;

/**
 *
 * @author Hugo
 */
public class CapturaProductosController implements ActionListener {

    //Atributos

    private ModuloProductos moduloProducto;
    private CapturarProductos capturarProductos;
    private ModuloCategoria moduloCategoria;
    private ModuloMarca moduloMarcas;
    private DefaultTableModel tabla;
    private int id;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.capturarProductos.getBtnCancelar() == e.getSource()) {
            reinicio();
        } else if (this.capturarProductos.getBtnEliminar() == e.getSource()) {
            int desicion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar el producto?", "Imagin", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == desicion) {
                this.id = Integer.parseInt(this.capturarProductos.getTblProductos().getValueAt(this.capturarProductos.getTblProductos().getSelectedRow(), 0).toString());
                if (this.moduloProducto.eliminarProducto(id)) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                    reinicio();
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (this.capturarProductos.getBtnFoto() == e.getSource()) {
            JFileChooser dlg = new JFileChooser();
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
            dlg.setFileFilter(filtroImagen);
            int option = dlg.showOpenDialog(dlg);

            if (option == JFileChooser.APPROVE_OPTION) {
                File f = dlg.getSelectedFile();
                String f1 = f.toString();
                this.capturarProductos.getTxtRuta().setText(f1);
            }
        } else if (this.capturarProductos.getBtnModificar() == e.getSource()) {
            Producto producto = new Producto(this.capturarProductos.getTxtNombre().getText(),
                    this.capturarProductos.getTxtModelo().getText(),
                    new Marca(),
                    0.0,
                    "",
                    0,
                    new Categoria(),
                    true);
            producto.getMarca().setMarca(this.capturarProductos.getCmbx().getSelectedItem().toString());
            producto.getCategoria().setCategoria(this.capturarProductos.getCmbxCategoria().getSelectedItem().toString());
            producto.setIdProducto(id);
            if (this.moduloProducto.modificarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto modificado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                reinicio();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.capturarProductos.getBtnNuevo() == e.getSource()) {
            reinicio();
        } else if (this.capturarProductos.getBtnRegistrar() == e.getSource()) {
            Producto producto = new Producto(this.capturarProductos.getTxtNombre().getText(),
                    this.capturarProductos.getTxtModelo().getText(),
                    new Marca(),
                    0.0,
                    "",
                    0,
                    new Categoria(),
                    true);
            producto.getMarca().setMarca(this.capturarProductos.getCmbx().getSelectedItem().toString());
            producto.getCategoria().setCategoria(this.capturarProductos.getCmbxCategoria().getSelectedItem().toString());
            if (this.moduloProducto.insertarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto registrado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                reinicio();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error\nIntentelo más tarde...", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.capturarProductos.dispose();
        }
    }

    public void iniciarVista() {
        cargarTabla();
        actualizarTabla();
        cargarCmbxCategoria();
        cargarCmbxMarca();
        reinicio();
    }

    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("IdProducto");
        this.tabla.addColumn("Nombre");
        this.tabla.addColumn("Modelo");
        this.tabla.addColumn("Marca");
        this.tabla.addColumn("Categoria");
        this.tabla.addColumn("Foto");
        this.capturarProductos.getTblProductos().setModel(tabla);
    }

    public void actualizarTabla() {
        while (this.capturarProductos.getTblProductos().getRowCount() > 0) {
            ((DefaultTableModel) this.capturarProductos.getTblProductos().getModel()).removeRow(0);
        }
        ArrayList<Producto> productos = this.moduloProducto.productosActivos();
        for (Producto producto : productos) {
            Object[] fila = {producto.getIdProducto(), producto.getNombre(), producto.getModelo(), producto.getMarca().getMarca(),
                producto.getCategoria().getCategoria(), producto.getFoto()};
            this.tabla.addRow(fila);
        }
    }

    public void cargarCmbxCategoria() {
        this.capturarProductos.getCmbxCategoria().removeAllItems();
        this.capturarProductos.getCmbxCategoria().addItem("Seleccione una categoría...");
        ArrayList<Categoria> categorias = this.moduloCategoria.categorias();
        for (Categoria categoria : categorias) {
            this.capturarProductos.getCmbxCategoria().addItem(categoria.getCategoria());
        }
    }

    public void cargarCmbxMarca() {
        this.capturarProductos.getCmbx().removeAllItems();
        this.capturarProductos.getCmbx().addItem("Seleccione una marca...");
        ArrayList<Marca> marcas = this.moduloMarcas.marcas();
        for (Marca marca : marcas) {
            this.capturarProductos.getCmbx().addItem(marca.getMarca());
        }
    }

    public void reinicio() {
        this.capturarProductos.getBtnEliminar().setVisible(false);
        this.capturarProductos.getBtnCancelar().setEnabled(false);
        this.capturarProductos.getBtnModificar().setEnabled(false);
        this.capturarProductos.getBtnNuevo().setEnabled(true);
        this.id = 0;
        this.capturarProductos.getTxtNombre().setText(null);
        this.capturarProductos.getTxtModelo().setText(null);
        this.capturarProductos.getCmbx().setSelectedItem(null);
        this.capturarProductos.getCmbxCategoria().setSelectedItem(null);

    }

    public void tablaMouseClicked(MouseEvent evt) {
        int fila = this.capturarProductos.getTblProductos().getSelectedRow();
        this.id = Integer.parseInt(this.capturarProductos.getTblProductos().getValueAt(fila, 0).toString());
        this.capturarProductos.getTxtNombre().setText(this.capturarProductos.getTblProductos().getValueAt(fila, 1).toString());
        this.capturarProductos.getTxtModelo().setText(this.capturarProductos.getTblProductos().getValueAt(fila, 2).toString());
        this.capturarProductos.getCmbx().setSelectedItem(this.capturarProductos.getTblProductos().getValueAt(fila, 3));
        this.capturarProductos.getCmbxCategoria().setSelectedItem(this.capturarProductos.getTblProductos().getValueAt(fila, 4));
        cargarImagen(this.capturarProductos.getTblProductos().getValueAt(fila, 5).toString());
        this.capturarProductos.getBtnEliminar().setVisible(true);
        this.capturarProductos.getBtnCancelar().setEnabled(true);
        this.capturarProductos.getBtnModificar().setEnabled(true);
        this.capturarProductos.getBtnNuevo().setEnabled(false);
    }

    public void cargarImagen(String ruta) {

    }

    //Constructor
    public CapturaProductosController(ModuloProductos moduloProducto, CapturarProductos capturarProductos, ModuloCategoria moduloCategoria, ModuloMarca moduloMarcas) {
        this.moduloProducto = moduloProducto;
        this.capturarProductos = capturarProductos;
        this.moduloCategoria = moduloCategoria;
        this.moduloMarcas = moduloMarcas;

        this.capturarProductos.getBtnCancelar().addActionListener(this);
        this.capturarProductos.getBtnEliminar().addActionListener(this);
        this.capturarProductos.getBtnFoto().addActionListener(this);
        this.capturarProductos.getBtnModificar().addActionListener(this);
        this.capturarProductos.getBtnNuevo().addActionListener(this);
        this.capturarProductos.getBtnRegistrar().addActionListener(this);
        this.capturarProductos.getBtnSalir().addActionListener(this);

        this.capturarProductos.getTblProductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evento) {
                tablaMouseClicked(evento);
            }
        });
    }

    //Seccion de metodos gettes and settes
}//fin de la clase, despues de esta linea no va nada
