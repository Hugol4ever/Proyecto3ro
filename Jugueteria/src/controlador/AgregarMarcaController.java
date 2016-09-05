
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.core.ModuloMarca;
import org.si301.jugueteria.model.Marca;
import vista.AgregarMarca;

/**
 *
 * @author Hugo
 */
public class AgregarMarcaController implements ActionListener {
    //Atributos
    private AgregarMarca agregarMarca;
    private ModuloMarca moduloMarca;
    private DefaultTableModel tabla;

    //Metodos
    public void iniciarVista() {
        cargarTabla();
        limpiar();
        actualizarTabla();
        this.agregarMarca.getBtnModificar().setEnabled(false);
        this.agregarMarca.getBtnCancelar().setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.agregarMarca.getBtnCancelar() == e.getSource()) {
            limpiar();
        } else if (this.agregarMarca.getBtnGuardar() == e.getSource()) {
            if (!this.agregarMarca.getTxtMarca().getText().equals("")) {
                Marca marca = new Marca(this.agregarMarca.getTxtMarca().getText());
                if (this.moduloMarca.insertarMarca(marca)) {
                    JOptionPane.showMessageDialog(null, "Marca registrada con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                }
            actualizarTabla();
            limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Escriba una marca", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.agregarMarca.getBtnModificar() == e.getSource()) {
            if (!this.agregarMarca.getTxtMarca().getText().equals("")) {
                Marca marca = new Marca(this.agregarMarca.getTxtMarca().getText());
                marca.setIdMarca(Integer.parseInt(this.agregarMarca.getTxtId().getText()));
                if (this.moduloMarca.modificarMarca(marca)) {
                    JOptionPane.showMessageDialog(null, "Marca modificada con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                }
            actualizarTabla();
            limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Escriba una marca", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.agregarMarca.dispose();
        }
    }
    
    public void limpiar() {
        this.agregarMarca.getTxtId().setText(null);
        this.agregarMarca.getTxtMarca().setText(null);
        this.agregarMarca.getBtnModificar().setEnabled(false);
        this.agregarMarca.getBtnCancelar().setEnabled(false);
        this.agregarMarca.getBtnGuardar().setEnabled(true);
    }
    
    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        this.tabla.addColumn("IdMarca");
        this.tabla.addColumn("Marca");
        this.agregarMarca.getTblMarcas().setModel(tabla);
    }
    
    public void actualizarTabla() {
        while (this.agregarMarca.getTblMarcas().getRowCount() > 0) {
            ((DefaultTableModel) this.agregarMarca.getTblMarcas().getModel()).removeRow(0);
        }
        ArrayList<Marca> marcas = this.moduloMarca.marcas();
        for (Marca marca : marcas) {
            Object[] fila = {marca.getIdMarca(), marca.getMarca()};
            this.tabla.addRow(fila);
        }
    }
    
    public void tablaMouseClicked(MouseEvent e) {
        this.agregarMarca.getBtnModificar().setEnabled(true);
        this.agregarMarca.getBtnCancelar().setEnabled(true);
        this.agregarMarca.getBtnGuardar().setEnabled(false);
        this.agregarMarca.getTxtId().setText(this.agregarMarca.getTblMarcas().getValueAt(this.agregarMarca.getTblMarcas().getSelectedRow(), 0).toString());
        this.agregarMarca.getTxtMarca().setText(this.agregarMarca.getTblMarcas().getValueAt(this.agregarMarca.getTblMarcas().getSelectedRow(), 1).toString());
    }

    //Constructor
    public AgregarMarcaController(AgregarMarca agregarMarca, ModuloMarca moduloMarca) {
        this.agregarMarca = agregarMarca;
        this.moduloMarca = moduloMarca;
        
        this.agregarMarca.getBtnCancelar().addActionListener(this);
        this.agregarMarca.getBtnGuardar().addActionListener(this);
        this.agregarMarca.getBtnModificar().addActionListener(this);
        this.agregarMarca.getBtnSalir().addActionListener(this);
        
        this.agregarMarca.getTblMarcas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evento) {
                tablaMouseClicked(evento);
            }
        });
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada