/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.si301.jugueteria.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.si301.jugueteria.bd.ConexionMySQL;
import org.si301.jugueteria.model.Privilegios;

/**
 *
 * @author hugo_
 */
public class ModuloPrivilegios {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<Privilegios> privilegios() {
        ArrayList<Privilegios> resPrivilegios = new ArrayList<Privilegios>();
        String query = "SELECT * FROM Privilegios";
        try {
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Privilegios privilegios = new Privilegios();
                privilegios.setIdPrivilegio(this.rs.getInt("IdPrivilegio"));
                privilegios.setABC_cliente(this.rs.getBoolean("ABC_cliente"));
                privilegios.setRep_cliente(this.rs.getBoolean("Rep_cliente"));
                privilegios.setABC_empleado(this.rs.getBoolean("ABC_empleado"));
                privilegios.setRep_empleado(this.rs.getBoolean("Rep_empleado"));
                privilegios.setABC_producto(this.rs.getBoolean("ABC_producto"));
                privilegios.setRep_producto(this.rs.getBoolean("Rep_producto"));
                privilegios.setABC_venta(this.rs.getBoolean("ABC_venta"));
                privilegios.setRep_venta(this.rs.getBoolean("Rep_venta"));
                privilegios.setRep_compra(this.rs.getBoolean("Rep_compra"));
                privilegios.setABC_pedido(this.rs.getBoolean("ABC_pedido"));
                privilegios.setRep_pedido(this.rs.getBoolean("Rep_pedido"));
                privilegios.setAdd_user(this.rs.getBoolean("Add_user"));
                privilegios.setAdd_marca(this.rs.getBoolean("Add_marca"));
                privilegios.setAdd_puesto(this.rs.getBoolean("Add_puesto"));
                privilegios.setAdd_categoria(this.rs.getBoolean("Add_categoria"));
                privilegios.setAbastecer_almacen(this.rs.getBoolean("Abastecer_almacen"));
                privilegios.setRep_almacen(this.rs.getBoolean("Rep_almacen"));
                resPrivilegios.add(numero, privilegios);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloPrivilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resPrivilegios;
    }
    
    public boolean modificarPrivilegios(Privilegios privilegios){
        try {
            String query = "CALL pa_modificar_privilegios(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setBoolean(1, privilegios.isABC_cliente());
            this.cst.setBoolean(2, privilegios.isRep_cliente());
            this.cst.setBoolean(3, privilegios.isABC_empleado());
            this.cst.setBoolean(4, privilegios.isRep_empleado());
            this.cst.setBoolean(5, privilegios.isABC_producto());
            this.cst.setBoolean(6, privilegios.isRep_producto());
            this.cst.setBoolean(7, privilegios.isABC_venta());
            this.cst.setBoolean(8, privilegios.isRep_venta());
            this.cst.setBoolean(9, privilegios.isRep_compra());
            this.cst.setBoolean(10, privilegios.isABC_pedido());
            this.cst.setBoolean(11, privilegios.isRep_pedido());
            this.cst.setBoolean(12, privilegios.isAdd_user());
            this.cst.setBoolean(13, privilegios.isAdd_marca());
            this.cst.setBoolean(14, privilegios.isAdd_puesto());
            this.cst.setBoolean(15, privilegios.isAdd_categoria());
            this.cst.setBoolean(16, privilegios.isAbastecer_almacen());
            this.cst.setBoolean(17, privilegios.isRep_almacen());
            this.cst.setInt(18, privilegios.getIdPrivilegio());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloPrivilegios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloPrivilegios() {
        this.conexion = new ConexionMySQL();
    }
    
}
