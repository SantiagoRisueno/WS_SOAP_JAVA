/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Steven
 */
public class AccesoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/eurekabank";
    private static final String USER = "root";
    private static final String PASS = "";

    public AccesoDB() {
    }
    
    public static Connection getConnection() throws SQLException {
        Connection cn = null;
        try {
            //datos MYSQL
            String driver = "com.mysql.cj.jdbc.Driver";
            //Cargar el driver a memoria
            Class.forName(driver).newInstance();
            //Obtener el objeto Connection
            cn=DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e){
            throw new SQLException("ERROR, no se encuentra el dirver");
        } catch (Exception e){
            throw new SQLException("ERROR, no se tiene acceso el servidor");
        }
        return cn;
    }
}
