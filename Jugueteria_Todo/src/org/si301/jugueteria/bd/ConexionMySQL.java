
package org.si301.jugueteria.bd;

import java.sql.*;

/**
 *
 * @author Hugo
 */
public class ConexionMySQL {
    //Atributos
    private String driverName;
    private String url;
    private String servidor;
    private int puerto;
    private String baseDeDatos;
    private String userName;
    private String password;
    
    Connection connection;

    //Metodos
    public Connection abrir() throws Exception {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }
    
    public void cerrar() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            
        }
    }

    //Constructor
    public ConexionMySQL() {
        //192.168.0.6
        //jugueteria
        //hugod
        this("com.mysql.jdbc.Driver", "localhost", 3306, "BD2_Integradora", "root", "root");
    }
    
    public ConexionMySQL(String driverName, String servidor, int puerto, String baseDeDatos, String userName, String password) {
        this.driverName = driverName;
        this.servidor = servidor;
        this.puerto = puerto;
        this.baseDeDatos = baseDeDatos;
        this.userName = userName;
        this.password = password;
        
        try {
            Class.forName(driverName);
            url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDeDatos;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada