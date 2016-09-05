
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
import org.si301.jugueteria.model.Empleado;
import org.si301.jugueteria.model.Privilegios;
import org.si301.jugueteria.model.Puesto;
import org.si301.jugueteria.model.Usuario;

/**
 *
 * @author hugo_
 */
public class ModuloEmpleados {
    
    private ResultSet rs;
    private Statement st;
    private CallableStatement cst;
    private ConexionMySQL conexion;
    private Connection con;
    
    public ArrayList<Empleado> empleadosTodos() {
        ArrayList<Empleado> resEmpleados = new ArrayList<Empleado>();
        try {
            String query = "SELECT * FROM empleados_todos";
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setUsuario(new Usuario());
                empleado.setPuesto(new Puesto());
                empleado.setPrivilegios(new Privilegios());
                empleado.setIdEmpleado(this.rs.getInt("IdEmpleado"));
                empleado.setNombre(this.rs.getString("Nombre"));
                empleado.setApellidoPateno(this.rs.getString("ApePa"));
                empleado.setApellidoMaterno(this.rs.getString("ApeMa"));
                empleado.setFechaNacimiento(this.rs.getDate("Fecha_Nac"));
                empleado.setRFC(this.rs.getString("RFC"));
                empleado.setCurp(this.rs.getString("Curp"));
                empleado.setGenero(this.rs.getString("Genero"));
                empleado.setDomicilio(this.rs.getString("Domicilio"));
                empleado.setCp(this.rs.getString("Cp"));
                empleado.setTelefono(this.rs.getLong("telefono"));
                empleado.setEstado(this.rs.getString("Estado"));
                empleado.setCiudad(this.rs.getString("Ciudad"));
                empleado.setFechaIngreso(this.rs.getDate("Fecha_ingreso"));
                empleado.getPuesto().setPuesto(this.rs.getString("Puesto"));
                empleado.setCodigo(this.rs.getInt("CodigoE"));
                empleado.setSalario(this.rs.getInt("Salario"));
                empleado.getUsuario().setIdUsuario(this.rs.getInt("IdUsuario"));
                empleado.getPrivilegios().setIdPrivilegio(this.rs.getInt("IdPrivilegio"));
                empleado.getUsuario().setUsuario(this.rs.getString("Usuario"));
                empleado.getUsuario().setContrasenia(this.rs.getString("Contrasenia"));
                empleado.setEstatus(this.rs.getBoolean("Estatus"));
                resEmpleados.add(numero, empleado);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resEmpleados;
    }
    
    public ArrayList<Empleado> empleadosActivos() {
        ArrayList<Empleado> resEmpleados = new ArrayList<Empleado>();
        try {
            String query = "SELECT * FROM empleados_activos";
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setUsuario(new Usuario());
                empleado.setPuesto(new Puesto());
                empleado.setPrivilegios(new Privilegios());
                empleado.setIdEmpleado(this.rs.getInt("IdEmpleado"));
                empleado.setNombre(this.rs.getString("Nombre"));
                empleado.setApellidoPateno(this.rs.getString("ApePa"));
                empleado.setApellidoMaterno(this.rs.getString("ApeMa"));
                empleado.setFechaNacimiento(this.rs.getDate("Fecha_Nac"));
                empleado.setRFC(this.rs.getString("RFC"));
                empleado.setCurp(this.rs.getString("Curp"));
                empleado.setGenero(this.rs.getString("Genero"));
                empleado.setDomicilio(this.rs.getString("Domicilio"));
                empleado.setCp(this.rs.getString("Cp"));
                empleado.setTelefono(this.rs.getLong("telefono"));
                empleado.setEstado(this.rs.getString("Estado"));
                empleado.setCiudad(this.rs.getString("Ciudad"));
                empleado.setFechaIngreso(this.rs.getDate("Fecha_ingreso"));
                empleado.getPuesto().setPuesto(this.rs.getString("Puesto"));
                empleado.setCodigo(this.rs.getInt("CodigoE"));
                empleado.setSalario(this.rs.getInt("Salario"));
                empleado.getUsuario().setIdUsuario(this.rs.getInt("IdUsuario"));
                empleado.getPrivilegios().setIdPrivilegio(this.rs.getInt("IdPrivilegio"));
                empleado.getUsuario().setUsuario(this.rs.getString("Usuario"));
                empleado.getUsuario().setContrasenia(this.rs.getString("Contrasenia"));
                resEmpleados.add(numero, empleado);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resEmpleados;
    }
    
    public ArrayList<Empleado> empleadosInactivos() {
        ArrayList<Empleado> resEmpleados = new ArrayList<Empleado>();
        try {
            String query = "SELECT * FROM empleados_inactivos";
            this.con = conexion.abrir();
            this.st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs = st.executeQuery(query);
            int numero = 0;
            while (this.rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setUsuario(new Usuario());
                empleado.setPuesto(new Puesto());
                empleado.setPrivilegios(new Privilegios());
                empleado.setIdEmpleado(this.rs.getInt("IdEmpleado"));
                empleado.setNombre(this.rs.getString("Nombre"));
                empleado.setApellidoPateno(this.rs.getString("ApePa"));
                empleado.setApellidoMaterno(this.rs.getString("ApeMa"));
                empleado.setFechaNacimiento(this.rs.getDate("Fecha_Nac"));
                empleado.setRFC(this.rs.getString("RFC"));
                empleado.setCurp(this.rs.getString("Curp"));
                empleado.setGenero(this.rs.getString("Genero"));
                empleado.setDomicilio(this.rs.getString("Domicilio"));
                empleado.setCp(this.rs.getString("Cp"));
                empleado.setTelefono(this.rs.getLong("telefono"));
                empleado.setEstado(this.rs.getString("Estado"));
                empleado.setCiudad(this.rs.getString("Ciudad"));
                empleado.setFechaIngreso(this.rs.getDate("Fecha_ingreso"));
                empleado.getPuesto().setPuesto(this.rs.getString("Puesto"));
                empleado.setCodigo(this.rs.getInt("CodigoE"));
                empleado.setSalario(this.rs.getInt("Salario"));
                empleado.getUsuario().setIdUsuario(this.rs.getInt("IdUsuario"));
                empleado.getPrivilegios().setIdPrivilegio(this.rs.getInt("IdPrivilegio"));
                empleado.getUsuario().setUsuario(this.rs.getString("Usuario"));
                empleado.getUsuario().setContrasenia(this.rs.getString("Contrasenia"));
                resEmpleados.add(numero, empleado);
                numero++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModuloEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resEmpleados;
    }
    
    public boolean insertarEmpleado(Empleado empleado) {
        try {
            this.con = this.conexion.abrir();
            String query = "CALL pa_insertar_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?)";
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, empleado.getNombre());
            this.cst.setString(2, empleado.getApellidoPateno());
            this.cst.setString(3, empleado.getApellidoMaterno());
            this.cst.setString(4, Globals.DATE_SQL_FORMAT.format(empleado.getFechaNacimiento()));
            this.cst.setString(5, empleado.getRFC());
            this.cst.setString(6, empleado.getCurp());
            this.cst.setString(7, empleado.getGenero());
            this.cst.setString(8, empleado.getDomicilio());
            this.cst.setString(9, empleado.getCp());
            this.cst.setLong(10, empleado.getTelefono());
            this.cst.setString(11, empleado.getEstado());
            this.cst.setString(12, empleado.getCiudad());
            this.cst.setString(13, empleado.getUsuario().getPerfil());
            this.cst.setString(14, Globals.DATE_SQL_FORMAT.format(empleado.getFechaIngreso()));
            this.cst.setString(15, empleado.getPuesto().getPuesto());
            this.cst.setInt(16, empleado.getSalario());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean modificarEmpleado(Empleado empleado) {
        try {
            String query = "CALL pa_modificar_empleado (?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setString(1, empleado.getNombre());
            this.cst.setString(2, empleado.getApellidoPateno());
            this.cst.setString(3, empleado.getApellidoMaterno());
            this.cst.setString(4, empleado.getRFC());
            this.cst.setString(5, empleado.getCurp());
            this.cst.setString(6, empleado.getDomicilio());
            this.cst.setString(7, empleado.getCp());
            this.cst.setLong(8, empleado.getTelefono());
            this.cst.setString(9, empleado.getEstado());
            this.cst.setString(10, empleado.getCiudad());
            this.cst.setString(11, empleado.getUsuario().getContrasenia());
            this.cst.setString(12, empleado.getPuesto().getPuesto());
            this.cst.setInt(13, empleado.getSalario());
            this.cst.setInt(14, empleado.getIdEmpleado());
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminarEmpleado(int id) {
        try {
            String query = "CALL pa_eliminar_empleado(?)";
            this.con = this.conexion.abrir();
            this.cst = this.con.prepareCall(query);
            this.cst.setInt(1, id);
            this.cst.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ModuloEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ModuloEmpleados() {
        this.conexion = new ConexionMySQL();
    }
    
}