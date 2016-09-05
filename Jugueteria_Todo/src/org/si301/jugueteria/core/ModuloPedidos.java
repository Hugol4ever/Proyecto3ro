
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
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Marca;
import org.si301.jugueteria.model.Pedido;
import org.si301.jugueteria.model.PedidoProducto;
import org.si301.jugueteria.model.Producto;

/**
 *
 * @author hugo_
 */
public class ModuloPedidos {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<PedidoProducto> reportePedidos() {
        ArrayList<PedidoProducto> resPedidos = new ArrayList<PedidoProducto>();
        try {
            String query = "SELECT * FROM reporte_pedidos";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setPedido(new Pedido());
                pedidoProducto.setProducto(new Producto());
                pedidoProducto.getProducto().setMarca(new Marca());
                pedidoProducto.getPedido().setCliente(new Cliente());
                pedidoProducto.getPedido().getCliente().setIdCliente(this.rs.getInt("idCliente"));
                pedidoProducto.getPedido().getCliente().setNombre(this.rs.getString("Nombre"));
                pedidoProducto.getPedido().setFechaPedido(this.rs.getDate("Fecha_Pedi"));
                pedidoProducto.getProducto().setNombre(this.rs.getString("Nombre_Prod"));
                pedidoProducto.getProducto().getMarca().setMarca("Marca");
                pedidoProducto.setCantidad(this.rs.getInt("Cantidad"));
                pedidoProducto.getPedido().getCliente().setCiudad(this.rs.getString("Ciudad"));
                pedidoProducto.getPedido().getCliente().setEstado(this.rs.getString("Estado"));
                pedidoProducto.setPrecio(this.rs.getDouble("Precio"));
                resPedidos.add(numero, pedidoProducto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resPedidos;
    }
    
    public ArrayList<PedidoProducto> pedidosClientes() {
        ArrayList<PedidoProducto> resPedidos = new ArrayList<PedidoProducto>();
        try {
            String query = "SELECT * FROM pedidos_web";
            this.con = this.conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setPedido(new Pedido());
                pedidoProducto.setProducto(new Producto());
                pedidoProducto.getProducto().setMarca(new Marca());
                pedidoProducto.getPedido().setCliente(new Cliente());
                pedidoProducto.getPedido().getCliente().setIdCliente(this.rs.getInt("idCliente1"));
                pedidoProducto.getPedido().setIdPedido(this.rs.getInt("IdPedido"));
                pedidoProducto.getPedido().setFechaPedido(this.rs.getDate("Fecha_Pedi"));
                pedidoProducto.getProducto().setNombre(this.rs.getString("Nombre_Prod"));
                pedidoProducto.getProducto().getMarca().setMarca(this.rs.getString("Marca"));
                pedidoProducto.setCantidad(this.rs.getInt("Cantidad"));
                pedidoProducto.setPrecio(this.rs.getDouble("Precio"));
                resPedidos.add(numero, pedidoProducto);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resPedidos;
    }
    
    public boolean insertarPedido(Pedido pedido) {
        try {
            String query = "CALL pa_insertar_pedido(?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, Globals.DATE_SQL_FORMAT.format(pedido.getFechaPedido()));
            this.cst.setInt(2, pedido.getCliente().getIdCliente());
            this.cst.registerOutParameter(3, java.sql.Types.INTEGER);
            this.cst.executeUpdate();
            pedido.setIdPedido(this.cst.getInt(3));
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloPedidos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insertarDetalle(PedidoProducto pedidoProducto) {
        try {
            String query = "CALL pa_detalle_pedido(?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setInt(1, pedidoProducto.getPedido().getIdPedido());
            this.cst.setInt(2, pedidoProducto.getCantidad());
            this.cst.setInt(3, pedidoProducto.getProducto().getIdProducto());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloPedidos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloPedidos() {
        this.conexion = new ConexionMySQL();
    }
    
}
