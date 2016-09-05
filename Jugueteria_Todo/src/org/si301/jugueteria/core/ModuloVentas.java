
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
import org.si301.jugueteria.model.Categoria;
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Marca;
import org.si301.jugueteria.model.Producto;
import org.si301.jugueteria.model.Venta;
import org.si301.jugueteria.model.VentaProducto;

/**
 *
 * @author hugo_
 */
public class ModuloVentas {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<VentaProducto> reporteVentas() {
        ArrayList<VentaProducto> resVenta = new ArrayList<VentaProducto>();
        try {
            String query = "SELECT * FROM reporte_venta";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                VentaProducto ventaProducto = new VentaProducto();
                ventaProducto.setProducto(new Producto());
                ventaProducto.setVenta(new Venta());
                ventaProducto.getVenta().setCliente(new Cliente());
                ventaProducto.getVenta().setIdVenta(this.rs.getInt("IdVenta"));
                ventaProducto.getProducto().setIdProducto(this.rs.getInt("IdProducto"));
                ventaProducto.getVenta().setFechaVenta(this.rs.getDate("Fecha_ven"));
                ventaProducto.getVenta().getCliente().setNombre(this.rs.getString("Nombre"));
                ventaProducto.getVenta().getCliente().setApellidoPateno(this.rs.getString("ApePa"));
                ventaProducto.getVenta().getCliente().setApellidoMaterno(this.rs.getString("ApeMa"));
                ventaProducto.getVenta().getCliente().setCp(this.rs.getString("Cp"));
                ventaProducto.getVenta().getCliente().setCiudad(this.rs.getString("Ciudad"));
                ventaProducto.getVenta().getCliente().setEstado(this.rs.getString("Estado"));
                ventaProducto.setPrecio(this.rs.getDouble("Precio"));
                ventaProducto.setCantidad(this.rs.getInt("Cantidad"));
                resVenta.add(numero, ventaProducto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resVenta;
    }
    
    public ArrayList<VentaProducto> ventasDetalle() {
        ArrayList<VentaProducto> resVenta = new ArrayList<VentaProducto>();
        try {
            String query = "SELECT * FROM lista_productos_activos";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                VentaProducto ventaProducto = new VentaProducto();
                ventaProducto.setProducto(new Producto());
                ventaProducto.getProducto().setCategoria(new Categoria());
                ventaProducto.getProducto().setMarca(new Marca());
                ventaProducto.getProducto().setIdProducto(this.rs.getInt("IdProducto"));
                ventaProducto.getProducto().setNombre(this.rs.getString("Nombre_Prod"));
                ventaProducto.getProducto().setModelo(this.rs.getString("Modelo"));
                ventaProducto.getProducto().getMarca().setMarca(this.rs.getString("Marca"));
                ventaProducto.getProducto().setPrecio(this.rs.getDouble("Precio"));
                ventaProducto.getProducto().setFoto(this.rs.getString("Foto"));
                ventaProducto.getProducto().setExistencia(this.rs.getInt("Existencia"));
                ventaProducto.getProducto().getCategoria().setCategoria(this.rs.getString("Categoria"));
                resVenta.add(numero, ventaProducto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resVenta;
    }
    
    public boolean insertarVenta(Venta venta) {
        try {
            String query = "CALL pa_insertar_venta(?, ?, ?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, Globals.DATE_SQL_FORMAT.format(venta.getFechaVenta()));
            this.cst.setString(2, venta.getHoraVenta());
            this.cst.setInt(3, venta.getCliente().getIdCliente());
            this.cst.setInt(4, venta.getEmpleado().getIdEmpleado());
            this.cst.registerOutParameter(5, java.sql.Types.INTEGER);
            this.cst.executeUpdate();
            venta.setIdVenta(this.cst.getInt(5));
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloVentas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insertarDetalle(VentaProducto ventaProducto) {
        try {
            String query = "CALL pa_detalle_venta(?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setInt(1, ventaProducto.getVenta().getIdVenta());
            this.cst.setInt(2, ventaProducto.getCantidad());
            this.cst.setInt(3, ventaProducto.getProducto().getIdProducto());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloVentas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloVentas() {
        this.conexion = new ConexionMySQL();
    }
    
}
