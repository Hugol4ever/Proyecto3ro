
package org.si301.jugueteria.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.si301.jugueteria.bd.ConexionMySQL;
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Privilegios;
import org.si301.jugueteria.model.Empleado;

/**
 *
 * @author Hugo
 */
public class InicioSesion {
    //Atributos
    private ResultSet rs;
    private Empleado empleado;
    private Cliente cliente;
    private ConexionMySQL conexion;
    private Connection con;
    private PreparedStatement pst;

    //Metodos
    public boolean empleadoActivo() {
        String query = "SELECT * FROM empleados_activos WHERE Usuario = ? AND Contrasenia = ?";
        try {
            this.con = this.conexion.abrir();
            this.pst = this.con.prepareStatement(query);
            this.pst.setString(1, this.empleado.getUsuario().getUsuario());
            this.pst.setString(2, this.empleado.getUsuario().getContrasenia());
            this.rs = this.pst.executeQuery();
            this.empleado.setEstatus(false);
            while (this.rs.next()) {
                this.empleado.setIdEmpleado(this.rs.getInt("IdEmpleado"));
                this.empleado.setNombre(this.rs.getString("Nombre"));
                this.empleado.setApellidoPateno(this.rs.getString("ApePa"));
                this.empleado.setApellidoMaterno(this.rs.getString("ApeMa"));
                this.empleado.getPrivilegios().setIdPrivilegio(this.rs.getInt("IdPrivilegio"));
                this.empleado.setEstatus(true);
            }
            this.conexion.cerrar();
            return this.empleado.isEstatus();
        } catch (Exception e) {
            System.out.println(e);
            this.conexion.cerrar();
            return false;
        }
    }
    
    public boolean clienteActivo() {
        String query = "SELECT * FROM cliente_activos WHERE Usuario = ? AND Contrasenia = ?";
        try {
            this.con = this.conexion.abrir();
            this.pst = this.con.prepareStatement(query);
            this.pst.setString(1, this.cliente.getUsuario().getUsuario());
            this.pst.setString(2, this.cliente.getUsuario().getContrasenia());
            this.rs = this.pst.executeQuery();
            this.cliente.setEstatus(false);
            while (rs.next()) {
                this.cliente.setIdCliente(this.rs.getInt("IdCliente"));
                this.cliente.setNombre(this.rs.getString("Nombre"));
                this.cliente.setApellidoPateno(this.rs.getString("ApePa"));
                this.cliente.setApellidoMaterno(this.rs.getString("ApeMa"));
                this.cliente.setEstatus(true);
            }
            this.conexion.cerrar();
            return this.cliente.isEstatus();
        } catch (Exception ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            this.conexion.cerrar();
            return false;
        }
    }
    
    public Privilegios privilegios() {
        String query = "SELECT * FROM sesion_privilegios WHERE IdPrivilegio = ?";
        try {
            this.con = this.conexion.abrir();
            this.pst = this.con.prepareStatement(query);
            this.pst.setInt(1, this.empleado.getPrivilegios().getIdPrivilegio());
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                this.empleado.getPrivilegios().setABC_cliente(this.rs.getBoolean("ABC_cliente"));
                this.empleado.getPrivilegios().setRep_cliente(this.rs.getBoolean("Rep_cliente"));
                this.empleado.getPrivilegios().setABC_empleado(this.rs.getBoolean("ABC_empleado"));
                this.empleado.getPrivilegios().setRep_empleado(this.rs.getBoolean("Rep_empleado"));
                this.empleado.getPrivilegios().setABC_producto(this.rs.getBoolean("ABC_producto"));
                this.empleado.getPrivilegios().setRep_producto(this.rs.getBoolean("Rep_producto"));
                this.empleado.getPrivilegios().setABC_venta(this.rs.getBoolean("ABC_venta"));
                this.empleado.getPrivilegios().setRep_venta(this.rs.getBoolean("Rep_venta"));
                this.empleado.getPrivilegios().setRep_compra(this.rs.getBoolean("Rep_compra"));
                this.empleado.getPrivilegios().setABC_pedido(this.rs.getBoolean("ABC_pedido"));
                this.empleado.getPrivilegios().setRep_pedido(this.rs.getBoolean("Rep_pedido"));
                this.empleado.getPrivilegios().setAdd_user(this.rs.getBoolean("Add_user"));
                this.empleado.getPrivilegios().setAdd_marca(this.rs.getBoolean("Add_marca"));
                this.empleado.getPrivilegios().setAdd_puesto(this.rs.getBoolean("Add_puesto"));
                this.empleado.getPrivilegios().setAdd_categoria(this.rs.getBoolean("Add_categoria"));
                this.empleado.getPrivilegios().setAbastecer_almacen(this.rs.getBoolean("Abastecer_almacen"));
                this.empleado.getPrivilegios().setRep_almacen(this.rs.getBoolean("Rep_almacen"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.empleado.getPrivilegios();
    }

    //Constructor
    public InicioSesion(Empleado empleado, Cliente cliente) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.empleado.setPrivilegios(new Privilegios());
        this.conexion = new ConexionMySQL();
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada