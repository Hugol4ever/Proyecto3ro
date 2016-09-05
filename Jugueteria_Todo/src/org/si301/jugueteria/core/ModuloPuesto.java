/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.si301.jugueteria.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.si301.jugueteria.bd.ConexionMySQL;
import org.si301.jugueteria.model.Puesto;

/**
 *
 * @author hugo_
 */
public class ModuloPuesto {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<Puesto> puestos() {
        ArrayList<Puesto> resPuesto = new ArrayList<Puesto>();
        String query = "SELECT * FROM Puesto";
        try {
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Puesto puesto = new Puesto();
                puesto.setIdPuesto(this.rs.getInt("IdPuesto"));
                puesto.setPuesto(this.rs.getString("Puesto"));
                resPuesto.add(numero, puesto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloPuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resPuesto;
    }
    
    public boolean insertarPuesto(Puesto puesto) {
        try {
            String query = "CALL pa_insertar_puesto(?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, puesto.getPuesto());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloPuesto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean modificarPuesto(Puesto puesto) {
        try {
            String query = "CALL pa_modificar_puesto(?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, puesto.getPuesto());
            this.cst.setInt(2, puesto.getIdPuesto());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloPuesto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloPuesto() {
        this.conexion = new ConexionMySQL();
    }
    
}
