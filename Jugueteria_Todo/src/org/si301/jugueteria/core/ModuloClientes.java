package org.si301.jugueteria.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.si301.jugueteria.bd.ConexionMySQL;
import org.si301.jugueteria.commons.Globals;
import org.si301.jugueteria.model.Cliente;
import org.si301.jugueteria.model.Usuario;

/**
 *
 * @author Hugo
 */
public class ModuloClientes {

    //Atributos
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;

    //Metodos
    public ArrayList<Cliente> clientesTodos() {
        ArrayList<Cliente> resCliente = new ArrayList<Cliente>();
        try {
            String query = "SELECT * FROM cliente_todos";
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setUsuario(new Usuario());
                cliente.setIdCliente(this.rs.getInt("IdCliente"));
                cliente.setNombre(this.rs.getString("Nombre"));
                cliente.setApellidoPateno(this.rs.getString("ApePa"));
                cliente.setApellidoMaterno(this.rs.getString("ApeMa"));
                cliente.setFechaNacimiento(this.rs.getDate("Fecha_Nac"));
                cliente.setRFC(this.rs.getString("RFC"));
                cliente.setCurp(this.rs.getString("Curp"));
                cliente.setGenero(this.rs.getString("Genero"));
                cliente.setDomicilio(this.rs.getString("Domicilio"));
                cliente.setCp(this.rs.getString("Cp"));
                cliente.setTelefono(this.rs.getLong("telefono"));
                cliente.setEstado(this.rs.getString("Estado"));
                cliente.setCiudad(this.rs.getString("Ciudad"));
                cliente.setFechaRegistro(this.rs.getDate("Fecha_Reg"));
                cliente.setHoraRegistro(this.rs.getTime("Hora_Reg").toString());
                cliente.setEmail(this.rs.getString("Email"));
                cliente.getUsuario().setUsuario(this.rs.getString("Usuario"));
                cliente.getUsuario().setContrasenia(this.rs.getString("Contrasenia"));
                cliente.setEstatus(rs.getBoolean("ActivoC"));
                resCliente.add(numero, cliente);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resCliente;
    }
    
    public ArrayList<Cliente> clienteActivos() {
        ArrayList<Cliente> resCliente = new ArrayList<Cliente>();
        try {
            String query = "SELECT * FROM cliente_activos";
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setUsuario(new Usuario());
                cliente.setIdCliente(this.rs.getInt("IdCliente"));
                cliente.setNombre(this.rs.getString("Nombre"));
                cliente.setApellidoPateno(this.rs.getString("ApePa"));
                cliente.setApellidoMaterno(this.rs.getString("ApeMa"));
                cliente.setFechaNacimiento(this.rs.getDate("Fecha_Nac"));
                cliente.setRFC(this.rs.getString("RFC"));
                cliente.setCurp(this.rs.getString("Curp"));
                cliente.setGenero(this.rs.getString("Genero"));
                cliente.setDomicilio(this.rs.getString("Domicilio"));
                cliente.setCp(this.rs.getString("Cp"));
                cliente.setTelefono(this.rs.getLong("telefono"));
                cliente.setEstado(this.rs.getString("Estado"));
                cliente.setCiudad(this.rs.getString("Ciudad"));
                cliente.setFechaRegistro(this.rs.getDate("Fecha_Reg"));
                cliente.setHoraRegistro(this.rs.getTime("Hora_Reg").toString());
                cliente.setEmail(this.rs.getString("Email"));
                cliente.getUsuario().setUsuario(this.rs.getString("Usuario"));
                cliente.getUsuario().setContrasenia(this.rs.getString("Contrasenia"));
                resCliente.add(numero, cliente);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloClientes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.printStackTrace();
            this.conexion.cerrar();
        }
        this.conexion.cerrar();
        return resCliente;
    }
    
    public ArrayList<Cliente> clientesInactivos() {
        ArrayList<Cliente> resCliente = new ArrayList<Cliente>();
        try {
            String query = "SELECT * FROM cliente_inactivos";
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setUsuario(new Usuario());
                cliente.setIdCliente(this.rs.getInt("IdCliente"));
                cliente.setNombre(this.rs.getString("Nombre"));
                cliente.setApellidoPateno(this.rs.getString("ApePa"));
                cliente.setApellidoMaterno(this.rs.getString("ApeMa"));
                cliente.setFechaNacimiento(this.rs.getDate("Fecha_Nac"));
                cliente.setRFC(this.rs.getString("RFC"));
                cliente.setCurp(this.rs.getString("Curp"));
                cliente.setGenero(this.rs.getString("Genero"));
                cliente.setDomicilio(this.rs.getString("Domicilio"));
                cliente.setCp(this.rs.getString("Cp"));
                cliente.setTelefono(this.rs.getLong("telefono"));
                cliente.setEstado(this.rs.getString("Estado"));
                cliente.setCiudad(this.rs.getString("Ciudad"));
                cliente.setFechaRegistro(this.rs.getDate("Fecha_Reg"));
                cliente.setHoraRegistro(this.rs.getTime("Hora_Reg").toString());
                cliente.setEmail(this.rs.getString("Email"));
                cliente.getUsuario().setUsuario(this.rs.getString("Usuario"));
                cliente.getUsuario().setContrasenia(this.rs.getString("Contrasenia"));
                resCliente.add(numero, cliente);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resCliente;
    }
    
    public boolean insertarCliente(Cliente cliente) {
        try {
            this.con = this.conexion.abrir();
            String query = "CALL pa_insertar_cliente(?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, cliente.getNombre());
            this.cst.setString(2, cliente.getApellidoPateno());
            this.cst.setString(3, cliente.getApellidoMaterno());
            this.cst.setString(4, Globals.DATE_SQL_FORMAT.format(cliente.getFechaNacimiento()));
            this.cst.setString(5, cliente.getRFC());
            this.cst.setString(6, cliente.getCurp());
            this.cst.setString(7, cliente.getGenero());
            this.cst.setString(8, cliente.getDomicilio());
            this.cst.setString(9, cliente.getCp());
            this.cst.setLong(10, cliente.getTelefono());
            this.cst.setString(11, cliente.getEstado());
            this.cst.setString(12, cliente.getCiudad());
            this.cst.setString(13, cliente.getUsuario().getUsuario());
            this.cst.setString(14, cliente.getUsuario().getContrasenia());
            this.cst.setString(15, cliente.getUsuario().getPerfil());
            this.cst.setString(16, Globals.DATE_SQL_FORMAT.format(cliente.getFechaRegistro()));
            this.cst.setString(17, cliente.getHoraRegistro());
            this.cst.setString(18, cliente.getEmail());
            this.cst.registerOutParameter(19, java.sql.Types.INTEGER);
            this.cst.executeUpdate();
            cliente.setIdCliente(this.cst.getInt(19));
            this.conexion.cerrar();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloClientes.class.getName()).log(Level.SEVERE, null, ex);
            this.conexion.cerrar();
            System.out.println(ex);
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean modificarCliente(Cliente cliente) {
        try {
            this.con = this.conexion.abrir();
            String query = "CALL pa_modificar_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?)";
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, cliente.getNombre());
            this.cst.setString(2, cliente.getApellidoPateno());
            this.cst.setString(3, cliente.getApellidoMaterno());
            this.cst.setString(4, cliente.getRFC());
            this.cst.setString(5, cliente.getCurp());
            this.cst.setString(6, cliente.getDomicilio());
            this.cst.setString(7, cliente.getCp());
            this.cst.setLong(8, cliente.getTelefono());
            this.cst.setString(9, cliente.getEstado());
            this.cst.setString(10, cliente.getCiudad());
            this.cst.setString(11, cliente.getUsuario().getContrasenia());
            this.cst.setString(12, cliente.getEmail());
            this.cst.setInt(13, cliente.getIdCliente());
            this.cst.executeUpdate();
            this.conexion.cerrar();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloClientes.class.getName()).log(Level.SEVERE, null, ex);
            this.conexion.cerrar();
            System.out.println(ex);
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean bajaCliente(int id) {
        try {
            this.con = this.conexion.abrir();
            String query = "CALL pa_eliminar_clientes(?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setInt(1, id);
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Constructor
    public ModuloClientes() {
        this.conexion = new ConexionMySQL();
    }

    //Seccion de metodos gettes and settes
    
}//fin de la clase, despues de esta linea no va nada
