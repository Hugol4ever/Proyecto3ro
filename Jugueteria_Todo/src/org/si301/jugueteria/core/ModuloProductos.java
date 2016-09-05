
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
import org.si301.jugueteria.model.Marca;
import org.si301.jugueteria.model.Producto;

/**
 *
 * @author hugo_
 */
public class ModuloProductos {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<Producto> productosTodos() {
        ArrayList<Producto> resProducto = new ArrayList<Producto>();
        try {
            String query = "SELECT * FROM lista_productos_todos";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Producto producto = new Producto();
                producto.setMarca(new Marca());
                producto.setCategoria(new Categoria());
                producto.setIdProducto(this.rs.getInt("IdProducto"));
                producto.setNombre(this.rs.getString("Nombre_Prod"));
                producto.setModelo(this.rs.getString("Modelo"));
                producto.getMarca().setMarca(this.rs.getString("Marca"));
                producto.setPrecio(this.rs.getDouble("Precio"));
                producto.setFoto(this.rs.getString("Foto"));
                producto.setExistencia(this.rs.getInt("Existencia"));
                producto.getCategoria().setCategoria(this.rs.getString("Categoria"));
                producto.setEstatus(this.rs.getBoolean("Estatus"));
                resProducto.add(numero, producto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resProducto;
    }
    
    public ArrayList<Producto> productosActivos() {
        ArrayList<Producto> resProducto = new ArrayList<Producto>();
        try {
            String query = "SELECT * FROM lista_productos_activos";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Producto producto = new Producto();
                producto.setMarca(new Marca());
                producto.setCategoria(new Categoria());
                producto.setIdProducto(this.rs.getInt("IdProducto"));
                producto.setNombre(this.rs.getString("Nombre_Prod"));
                producto.setModelo(this.rs.getString("Modelo"));
                producto.getMarca().setMarca(this.rs.getString("Marca"));
                producto.setPrecio(this.rs.getDouble("Precio"));
                producto.setFoto(this.rs.getString("Foto"));
                producto.setExistencia(this.rs.getInt("Existencia"));
                producto.getCategoria().setCategoria(this.rs.getString("Categoria"));
                resProducto.add(numero, producto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resProducto;
    }
    
    public ArrayList<Producto> productosInactivos() {
        ArrayList<Producto> resProducto = new ArrayList<Producto>();
        try {
            String query = "SELECT * FROM lista_productos_inactivos";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Producto producto = new Producto();
                producto.setMarca(new Marca());
                producto.setCategoria(new Categoria());
                producto.setIdProducto(this.rs.getInt("IdProducto"));
                producto.setNombre(this.rs.getString("Nombre_Prod"));
                producto.setModelo(this.rs.getString("Modelo"));
                producto.getMarca().setMarca(this.rs.getString("Marca"));
                producto.setPrecio(this.rs.getDouble("Precio"));
                producto.setFoto(this.rs.getString("Foto"));
                producto.setExistencia(this.rs.getInt("Existencia"));
                producto.getCategoria().setCategoria(this.rs.getString("Categoria"));
                resProducto.add(numero, producto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resProducto;
    }
    
    public boolean insertarProducto(Producto producto) {
        try {
            String query = "CALL pa_insertar_producto(?, ?, ?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, producto.getNombre());
            this.cst.setString(2, producto.getModelo());
            this.cst.setString(3, producto.getMarca().getMarca());
            this.cst.setString(4, producto.getFoto());
            this.cst.setString(5, producto.getCategoria().getCategoria());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloProductos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean modificarProducto(Producto producto) {
        try {
            String query = "CALL pa_modificar_producto(?, ?, ?, ?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, producto.getNombre());
            this.cst.setString(2, producto.getModelo());
            this.cst.setString(3, producto.getMarca().getMarca());
            this.cst.setString(4, producto.getFoto());
            this.cst.setString(5, producto.getCategoria().getCategoria());
            this.cst.setInt(6, producto.getIdProducto());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloProductos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminarProducto(int id) {
        try {
            String query = "CALL pa_eliminar_producto(?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setInt(1, id);
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloProductos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloProductos() {
        this.conexion = new ConexionMySQL();
    }
    
}