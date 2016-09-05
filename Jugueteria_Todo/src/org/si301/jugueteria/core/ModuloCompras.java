
package org.si301.jugueteria.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.si301.jugueteria.bd.ConexionMySQL;
import org.si301.jugueteria.commons.Globals;
import org.si301.jugueteria.model.Compra;
import org.si301.jugueteria.model.CompraProducto;
import org.si301.jugueteria.model.Marca;
import org.si301.jugueteria.model.Producto;

/**
 *
 * @author hugo_
 */
public class ModuloCompras {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<CompraProducto> bitacora() {
        ArrayList<CompraProducto> resCompra = new ArrayList<CompraProducto>();
        try {
            String query = "SELECT * FROM bitacora_compra";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                CompraProducto compraProducto = new CompraProducto();
                compraProducto.setCompra(new Compra());
                compraProducto.getCompra().setIdCompra(this.rs.getInt("IdCompra"));
                compraProducto.getCompra().setFechaCompra(this.rs.getDate("Fecha_Abasto"));
                compraProducto.setPrecio(this.rs.getDouble("Total"));
                resCompra.add(numero, compraProducto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resCompra;
    }
    
    public ArrayList<CompraProducto> detalle() {
        ArrayList<CompraProducto> resCompra = new ArrayList<CompraProducto>();
        try {
            String query = "SELECT * FROM detalle_compra";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                CompraProducto compraProducto = new CompraProducto();
                compraProducto.setCompra(new Compra());
                compraProducto.setProducto(new Producto());
                compraProducto.getProducto().setMarca(new Marca());
                compraProducto.getCompra().setIdCompra(this.rs.getInt("IdCompra"));
                compraProducto.getProducto().setIdProducto(this.rs.getInt("IdProducto"));
                compraProducto.getProducto().setNombre(this.rs.getString("Nombre_Prod"));
                compraProducto.getProducto().setModelo(this.rs.getString("modelo"));
                compraProducto.getProducto().getMarca().setMarca(this.rs.getString("marca"));
                compraProducto.setPrecio(this.rs.getDouble("Precio_Compra"));
                compraProducto.setCantidad(this.rs.getInt("Cantidad"));
                compraProducto.getProducto().setPrecio(this.rs.getDouble("Precio"));
                resCompra.add(numero, compraProducto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resCompra;
    }
    
    public boolean insertarCompra(Compra compra) {
        try {
            String query = "CALL pa_insertar_compra(?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, Globals.DATE_SQL_FORMAT.format(compra.getFechaCompra()));
            this.cst.setInt(2, compra.getEmpleado().getIdEmpleado());
            this.cst.registerOutParameter(3, java.sql.Types.INTEGER);
            this.cst.executeUpdate();
            compra.setIdCompra(this.cst.getInt(3));
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloCompras.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insertarDetalle(CompraProducto compraProducto) {
        try {
            String query = "CALL pa_detalle_compra(?, ?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setInt(1, compraProducto.getCompra().getIdCompra());
            this.cst.setDouble(2, compraProducto.getPrecio());
            this.cst.setInt(3, compraProducto.getCantidad());
            this.cst.setInt(4, compraProducto.getProducto().getIdProducto());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloCompras.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloCompras() {
        this.conexion = new ConexionMySQL();
    }
    
}
