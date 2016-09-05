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
import org.si301.jugueteria.model.Categoria;

/**
 *
 * @author hugo_
 */
public class ModuloCategoria {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<Categoria> categorias() {
        ArrayList<Categoria> resCategoria = new ArrayList<Categoria>();
        String query = "SELECT * FROM Categoria";
        try {
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(this.rs.getInt("IdCategoria"));
                categoria.setCategoria(this.rs.getString("Categoria"));
                resCategoria.add(numero, categoria);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resCategoria;
    }
    
    public boolean insertarCategoria(Categoria categoria) {
        try {
            String query = "CALL pa_insertar_categoria(?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, categoria.getCategoria());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloCategoria.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean modificarCategoria(Categoria categoria) {
        try {
            String query = "CALL pa_modificar_categoria(?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, categoria.getCategoria());
            this.cst.setInt(2, categoria.getIdCategoria());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloCategoria.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloCategoria() {
        this.conexion = new ConexionMySQL();
    }
    
}
