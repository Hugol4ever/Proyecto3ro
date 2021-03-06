/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hugo
 */
public class AgregarUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarUsuario
     */
    public AgregarUsuario() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuarios = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnReestablecer = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        chBxInfE = new javax.swing.JCheckBox();
        chBxInfC = new javax.swing.JCheckBox();
        chBxInfP = new javax.swing.JCheckBox();
        chBxInfV = new javax.swing.JCheckBox();
        chBxInfCo = new javax.swing.JCheckBox();
        chBxInfPe = new javax.swing.JCheckBox();
        chBxInfA = new javax.swing.JCheckBox();
        chBxABCE = new javax.swing.JCheckBox();
        chBxABCC = new javax.swing.JCheckBox();
        chBxABCP = new javax.swing.JCheckBox();
        chBxABCPu = new javax.swing.JCheckBox();
        chBxABCU = new javax.swing.JCheckBox();
        chBxABCM = new javax.swing.JCheckBox();
        chBxABCV = new javax.swing.JCheckBox();
        chBxABCPe = new javax.swing.JCheckBox();
        chBxABCCo = new javax.swing.JCheckBox();
        chBxABCCa = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Agregar usuarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Cambios/Bajas de usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 660, 200));

        jLabel2.setText("Empleado:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        txtEmpleado.setEditable(false);
        jPanel1.add(txtEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 130, -1));

        jLabel3.setText("Usuario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));
        jPanel1.add(txtUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 130, -1));

        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 150, -1));

        btnReestablecer.setText("Reestablecer contraseña");
        jPanel1.add(btnReestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, -1, -1));

        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, -1, -1));

        btnSalir.setText("Salir");
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Privilegios"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chBxInfE.setText("Informe de empleados");
        jPanel2.add(chBxInfE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        chBxInfC.setText("Informe de clientes");
        jPanel2.add(chBxInfC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        chBxInfP.setText("Informe de productos");
        jPanel2.add(chBxInfP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        chBxInfV.setText("Informe de ventas");
        jPanel2.add(chBxInfV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        chBxInfCo.setText("Informe de compras");
        jPanel2.add(chBxInfCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        chBxInfPe.setText("Informe de pedidos");
        jPanel2.add(chBxInfPe, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        chBxInfA.setText("Informe de almacen");
        jPanel2.add(chBxInfA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        chBxABCE.setText("ABC empleados");
        jPanel2.add(chBxABCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        chBxABCC.setText("ABC clientes");
        jPanel2.add(chBxABCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        chBxABCP.setText("ABC productos");
        jPanel2.add(chBxABCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        chBxABCPu.setText("ABC puesto");
        jPanel2.add(chBxABCPu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        chBxABCU.setText("ABC usuarios");
        jPanel2.add(chBxABCU, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        chBxABCM.setText("ABC marcas");
        jPanel2.add(chBxABCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        chBxABCV.setText("ABC ventas");
        jPanel2.add(chBxABCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        chBxABCPe.setText("ABC pedidos");
        jPanel2.add(chBxABCPe, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        chBxABCCo.setText("ABC compra");
        jPanel2.add(chBxABCCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        chBxABCCa.setText("ABC categoria");
        jPanel2.add(chBxABCCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 650, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnReestablecer;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chBxABCC;
    private javax.swing.JCheckBox chBxABCCa;
    private javax.swing.JCheckBox chBxABCCo;
    private javax.swing.JCheckBox chBxABCE;
    private javax.swing.JCheckBox chBxABCM;
    private javax.swing.JCheckBox chBxABCP;
    private javax.swing.JCheckBox chBxABCPe;
    private javax.swing.JCheckBox chBxABCPu;
    private javax.swing.JCheckBox chBxABCU;
    private javax.swing.JCheckBox chBxABCV;
    private javax.swing.JCheckBox chBxInfA;
    private javax.swing.JCheckBox chBxInfC;
    private javax.swing.JCheckBox chBxInfCo;
    private javax.swing.JCheckBox chBxInfE;
    private javax.swing.JCheckBox chBxInfP;
    private javax.swing.JCheckBox chBxInfPe;
    private javax.swing.JCheckBox chBxInfV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuarios;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnReestablecer() {
        return btnReestablecer;
    }

    public void setBtnReestablecer(JButton btnReestablecer) {
        this.btnReestablecer = btnReestablecer;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JTable getTblUsuarios() {
        return tblUsuarios;
    }

    public void setTblUsuarios(JTable tblUsuarios) {
        this.tblUsuarios = tblUsuarios;
    }

    public JTextField getTxtEmpleado() {
        return txtEmpleado;
    }

    public void setTxtEmpleado(JTextField txtEmpleado) {
        this.txtEmpleado = txtEmpleado;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JTextField getTxtUsuarios() {
        return txtUsuarios;
    }

    public void setTxtUsuarios(JTextField txtUsuarios) {
        this.txtUsuarios = txtUsuarios;
    }

    public JCheckBox getChBxABCC() {
        return chBxABCC;
    }

    public void setChBxABCC(JCheckBox chBxABCC) {
        this.chBxABCC = chBxABCC;
    }

    public JCheckBox getChBxABCCa() {
        return chBxABCCa;
    }

    public void setChBxABCCa(JCheckBox chBxABCCa) {
        this.chBxABCCa = chBxABCCa;
    }

    public JCheckBox getChBxABCCo() {
        return chBxABCCo;
    }

    public void setChBxABCCo(JCheckBox chBxABCCo) {
        this.chBxABCCo = chBxABCCo;
    }

    public JCheckBox getChBxABCE() {
        return chBxABCE;
    }

    public void setChBxABCE(JCheckBox chBxABCE) {
        this.chBxABCE = chBxABCE;
    }

    public JCheckBox getChBxABCM() {
        return chBxABCM;
    }

    public void setChBxABCM(JCheckBox chBxABCM) {
        this.chBxABCM = chBxABCM;
    }

    public JCheckBox getChBxABCP() {
        return chBxABCP;
    }

    public void setChBxABCP(JCheckBox chBxABCP) {
        this.chBxABCP = chBxABCP;
    }

    public JCheckBox getChBxABCPe() {
        return chBxABCPe;
    }

    public void setChBxABCPe(JCheckBox chBxABCPe) {
        this.chBxABCPe = chBxABCPe;
    }

    public JCheckBox getChBxABCPu() {
        return chBxABCPu;
    }

    public void setChBxABCPu(JCheckBox chBxABCPu) {
        this.chBxABCPu = chBxABCPu;
    }

    public JCheckBox getChBxABCU() {
        return chBxABCU;
    }

    public void setChBxABCU(JCheckBox chBxABCU) {
        this.chBxABCU = chBxABCU;
    }

    public JCheckBox getChBxABCV() {
        return chBxABCV;
    }

    public void setChBxABCV(JCheckBox chBxABCV) {
        this.chBxABCV = chBxABCV;
    }

    public JCheckBox getChBxInfA() {
        return chBxInfA;
    }

    public void setChBxInfA(JCheckBox chBxInfA) {
        this.chBxInfA = chBxInfA;
    }

    public JCheckBox getChBxInfC() {
        return chBxInfC;
    }

    public void setChBxInfC(JCheckBox chBxInfC) {
        this.chBxInfC = chBxInfC;
    }

    public JCheckBox getChBxInfCo() {
        return chBxInfCo;
    }

    public void setChBxInfCo(JCheckBox chBxInfCo) {
        this.chBxInfCo = chBxInfCo;
    }

    public JCheckBox getChBxInfE() {
        return chBxInfE;
    }

    public void setChBxInfE(JCheckBox chBxInfE) {
        this.chBxInfE = chBxInfE;
    }

    public JCheckBox getChBxInfP() {
        return chBxInfP;
    }

    public void setChBxInfP(JCheckBox chBxInfP) {
        this.chBxInfP = chBxInfP;
    }

    public JCheckBox getChBxInfPe() {
        return chBxInfPe;
    }

    public void setChBxInfPe(JCheckBox chBxInfPe) {
        this.chBxInfPe = chBxInfPe;
    }

    public JCheckBox getChBxInfV() {
        return chBxInfV;
    }

    public void setChBxInfV(JCheckBox chBxInfV) {
        this.chBxInfV = chBxInfV;
    }
    
}
