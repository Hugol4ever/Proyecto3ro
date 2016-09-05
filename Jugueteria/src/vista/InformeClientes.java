/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hugo
 */
public class InformeClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form InformeClientes
     */
    public InformeClientes() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdbtnCodigo = new javax.swing.JRadioButton();
        rdbtnNombre = new javax.swing.JRadioButton();
        rdbtnTodos = new javax.swing.JRadioButton();
        rdbtnAnio = new javax.swing.JRadioButton();
        rdbtnDomicilio = new javax.swing.JRadioButton();
        rdbtnCiudad = new javax.swing.JRadioButton();
        rdbtnEstado = new javax.swing.JRadioButton();
        rdbtnCodigoP = new javax.swing.JRadioButton();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        cmbxTipos = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Informe Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Informe de clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rdbtnCodigo);
        rdbtnCodigo.setText("Código");
        rdbtnCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(rdbtnCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        buttonGroup1.add(rdbtnNombre);
        rdbtnNombre.setText("Nombre");
        rdbtnNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(rdbtnNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        buttonGroup1.add(rdbtnTodos);
        rdbtnTodos.setSelected(true);
        rdbtnTodos.setText("Todos");
        rdbtnTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(rdbtnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        buttonGroup1.add(rdbtnAnio);
        rdbtnAnio.setText("Año de registro");
        jPanel2.add(rdbtnAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        buttonGroup1.add(rdbtnDomicilio);
        rdbtnDomicilio.setText("Domicilio");
        jPanel2.add(rdbtnDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        buttonGroup1.add(rdbtnCiudad);
        rdbtnCiudad.setText("Ciudad");
        jPanel2.add(rdbtnCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        buttonGroup1.add(rdbtnEstado);
        rdbtnEstado.setText("Estado");
        jPanel2.add(rdbtnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        buttonGroup1.add(rdbtnCodigoP);
        rdbtnCodigoP.setText("Código postal");
        jPanel2.add(rdbtnCodigoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 390, 100));
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 200, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);
        tblClientes.setFillsViewportHeight(true);
        tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 890, 260));

        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, -1, -1));

        cmbxTipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activos", "Inactivos", "Todos" }));
        jPanel1.add(cmbxTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbxTipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbtnAnio;
    private javax.swing.JRadioButton rdbtnCiudad;
    private javax.swing.JRadioButton rdbtnCodigo;
    private javax.swing.JRadioButton rdbtnCodigoP;
    private javax.swing.JRadioButton rdbtnDomicilio;
    private javax.swing.JRadioButton rdbtnEstado;
    private javax.swing.JRadioButton rdbtnNombre;
    private javax.swing.JRadioButton rdbtnTodos;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JComboBox getCmbxTipos() {
        return cmbxTipos;
    }

    public void setCmbxTipos(JComboBox cmbxTipos) {
        this.cmbxTipos = cmbxTipos;
    }

    public JRadioButton getRdbtnAnio() {
        return rdbtnAnio;
    }

    public void setRdbtnAnio(JRadioButton rdbtnAnio) {
        this.rdbtnAnio = rdbtnAnio;
    }

    public JRadioButton getRdbtnCiudad() {
        return rdbtnCiudad;
    }

    public void setRdbtnCiudad(JRadioButton rdbtnCiudad) {
        this.rdbtnCiudad = rdbtnCiudad;
    }

    public JRadioButton getRdbtnCodigo() {
        return rdbtnCodigo;
    }

    public void setRdbtnCodigo(JRadioButton rdbtnCodigo) {
        this.rdbtnCodigo = rdbtnCodigo;
    }

    public JRadioButton getRdbtnCodigoP() {
        return rdbtnCodigoP;
    }

    public void setRdbtnCodigoP(JRadioButton rdbtnCodigoP) {
        this.rdbtnCodigoP = rdbtnCodigoP;
    }

    public JRadioButton getRdbtnDomicilio() {
        return rdbtnDomicilio;
    }

    public void setRdbtnDomicilio(JRadioButton rdbtnDomicilio) {
        this.rdbtnDomicilio = rdbtnDomicilio;
    }

    public JRadioButton getRdbtnEstado() {
        return rdbtnEstado;
    }

    public void setRdbtnEstado(JRadioButton rdbtnEstado) {
        this.rdbtnEstado = rdbtnEstado;
    }

    public JRadioButton getRdbtnNombre() {
        return rdbtnNombre;
    }

    public void setRdbtnNombre(JRadioButton rdbtnNombre) {
        this.rdbtnNombre = rdbtnNombre;
    }

    public JRadioButton getRdbtnTodos() {
        return rdbtnTodos;
    }

    public void setRdbtnTodos(JRadioButton rdbtnTodos) {
        this.rdbtnTodos = rdbtnTodos;
    }

    public JTable getTblClientes() {
        return tblClientes;
    }

    public void setTblClientes(JTable tblClientes) {
        this.tblClientes = tblClientes;
    }

    public JTextField getTxtBusqueda() {
        return txtBusqueda;
    }

    public void setTxtBusqueda(JTextField txtBusqueda) {
        this.txtBusqueda = txtBusqueda;
    }

}