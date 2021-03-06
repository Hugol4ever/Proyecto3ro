/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hugo
 */
public class CapturarPedidos extends javax.swing.JInternalFrame {

    /**
     * Creates new form CapturarPedidos
     */
    public CapturarPedidos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        mniQuitar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dtchFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cmbxCliente = new javax.swing.JComboBox();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        cmbxProducto = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        mniQuitar.setText("Quitar");
        popupMenu.add(mniQuitar);

        setClosable(true);
        setIconifiable(true);
        setTitle("Capturar pedidos");
        setToolTipText("");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Altas/Cambios/Bajas de pedidos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Fecha:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        dtchFecha.setEnabled(false);
        jPanel2.add(dtchFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 170, -1));

        jLabel3.setText("Cliente:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        cmbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un cliente..." }));
        jPanel2.add(cmbxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 170, -1));

        btnNuevo.setText("Nuevo pedido");
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        btnCancelar.setText("Cancelar");
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 780, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 710, 190));

        jLabel5.setText("Producto:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        btnAgregar.setText("Agregar");
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        cmbxProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un producto" }));
        jPanel3.add(cmbxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, -1));

        jLabel6.setText("Total:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));

        txtTotal.setEditable(false);
        jPanel3.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 100, -1));

        jLabel7.setText("Cantidad:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 110, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 750, 330));

        btnSalir.setText("Salir");
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));

        btnRegistrar.setText("Registrar pedido");
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbxCliente;
    private javax.swing.JComboBox cmbxProducto;
    private com.toedter.calendar.JDateChooser dtchFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mniQuitar;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JComboBox getCmbxCliente() {
        return cmbxCliente;
    }

    public void setCmbxCliente(JComboBox cmbxCliente) {
        this.cmbxCliente = cmbxCliente;
    }

    public JComboBox getCmbxProducto() {
        return cmbxProducto;
    }

    public void setCmbxProducto(JComboBox cmbxProducto) {
        this.cmbxProducto = cmbxProducto;
    }

    public JDateChooser getDtchFecha() {
        return dtchFecha;
    }

    public void setDtchFecha(JDateChooser dtchFecha) {
        this.dtchFecha = dtchFecha;
    }

    public JMenuItem getMniQuitar() {
        return mniQuitar;
    }

    public void setMniQuitar(JMenuItem mniQuitar) {
        this.mniQuitar = mniQuitar;
    }

    public JTable getTblProductos() {
        return tblProductos;
    }

    public void setTblProductos(JTable tblProductos) {
        this.tblProductos = tblProductos;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(JTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(JTextField txtTotal) {
        this.txtTotal = txtTotal;
    }

    public JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    public void setPopupMenu(JPopupMenu popupMenu) {
        this.popupMenu = popupMenu;
    }

}