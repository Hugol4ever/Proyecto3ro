
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.si301.jugueteria.core.ModuloPuesto;
import org.si301.jugueteria.model.Puesto;
import vista.AgregarPuesto;

/**
 *
 * @author Hugo
 */
public class AgregarPuestoController implements ActionListener {
    //Atributos
    private AgregarPuesto agregarPuesto;
    private ModuloPuesto moduloPuesto;
    private DefaultTableModel tabla;

    //Metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.agregarPuesto.getBtnGuardar()== e.getSource()) {
            if (!this.agregarPuesto.getTxtPuesto().getText().equals("")) {
                Puesto puesto = new Puesto(this.agregarPuesto.getTxtPuesto().getText());
                if (this.moduloPuesto.insertarPuesto(puesto)) {
                    JOptionPane.showMessageDialog(null, "Puesto registrado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                }
            actualizarTabla();
            limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Escriba un puesto", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else if (this.agregarPuesto.getBtnCancelar() == e.getSource()) {
            limpiar();
        } else if (this.agregarPuesto.getBtnModificar() == e.getSource()) {
            if (!this.agregarPuesto.getTxtPuesto().getText().equals("")) {
                Puesto puesto = new Puesto(this.agregarPuesto.getTxtPuesto().getText());
                puesto.setIdPuesto(Integer.parseInt(this.agregarPuesto.getTxtId().getText()));
                if (this.moduloPuesto.modificarPuesto(puesto)) {
                    JOptionPane.showMessageDialog(null, "Puesto registrado con éxito", "Imagin", JOptionPane.INFORMATION_MESSAGE);
                }
            actualizarTabla();
            limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Escriba un puesto", "Imagin", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.agregarPuesto.dispose();
        }
    }
    
    public void iniciarVista() {
        cargarTabla();
        limpiar();
        actualizarTabla();
        this.agregarPuesto.getBtnModificar().setEnabled(false);
        this.agregarPuesto.getBtnCancelar().setEnabled(false);
    }
    
    public void cargarTabla() {
        this.tabla = new DefaultTableModel();
        tabla.addColumn("IdPuesto");
        tabla.addColumn("Puesto");
        this.agregarPuesto.getTblPuesto().setModel(tabla);
    }
    
    public void limpiar() {
        this.agregarPuesto.getTxtId().setText(null);
        this.agregarPuesto.getTxtPuesto().setText(null);
        this.agregarPuesto.getBtnModificar().setEnabled(false);
        this.agregarPuesto.getBtnCancelar().setEnabled(false);
        this.agregarPuesto.getBtnGuardar().setEnabled(true);
    }
    
    public void tablaMouseClicked(MouseEvent e) {
        this.agregarPuesto.getBtnModificar().setEnabled(true);
        this.agregarPuesto.getBtnCancelar().setEnabled(true);
        this.agregarPuesto.getBtnGuardar().setEnabled(false);
        this.agregarPuesto.getTxtId().setText(this.agregarPuesto.getTblPuesto().getValueAt(this.agregarPuesto.getTblPuesto().getSelectedRow(), 0).toString());
        this.agregarPuesto.getTxtPuesto().setText(this.agregarPuesto.getTblPuesto().getValueAt(this.agregarPuesto.getTblPuesto().getSelectedRow(), 1).toString());
    }
    
    public void actualizarTabla() {
        while (this.agregarPuesto.getTblPuesto().getRowCount() > 0) {
            ((DefaultTableModel) this.agregarPuesto.getTblPuesto().getModel()).removeRow(0);
        }
        ArrayList<Puesto> puestos = this.moduloPuesto.puestos();
        for (Puesto puesto : puestos) {
            Object[] fila = {puesto.getIdPuesto(), puesto.getPuesto()};
            this.tabla.addRow(fila);
        }
    }

    //Constructor
    public AgregarPuestoController(AgregarPuesto agregarPuesto, ModuloPuesto moduloPuesto) {
        this.agregarPuesto = agregarPuesto;
        this.moduloPuesto = moduloPuesto;
        
        this.agregarPuesto.getBtnGuardar().addActionListener(this);
        this.agregarPuesto.getBtnCancelar().addActionListener(this);
        this.agregarPuesto.getBtnModificar().addActionListener(this);
        this.agregarPuesto.getBtnSalir().addActionListener(this);
        
        this.agregarPuesto.getTblPuesto().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evento) {
                tablaMouseClicked(evento);
            }
        });
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada