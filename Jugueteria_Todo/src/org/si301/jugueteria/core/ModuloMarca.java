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
import org.si301.jugueteria.model.Marca;

/**
 *
 * @author hugo_
 */
public class ModuloMarca {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<Marca> marcas() {
        ArrayList<Marca> resMarcas = new ArrayList<Marca>();
        String query = "SELECT * FROM Marca";
        try {
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Marca marca = new Marca();
                marca.setIdMarca(this.rs.getInt("IdMarca"));
                marca.setMarca(this.rs.getString("Marca"));
                resMarcas.add(numero, marca);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resMarcas;
    }
    
    public boolean insertarMarca(Marca marca) {
        try {
            String query = "CALL pa_insertar_marca(?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, marca.getMarca());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloMarca.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean modificarMarca(Marca marca) {
        try {
            String query = "CALL pa_modificar_marca(?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, marca.getMarca());
            this.cst.setInt(2, marca.getIdMarca());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloMarca.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloMarca() {
        this.conexion = new ConexionMySQL();
    }
    
}
