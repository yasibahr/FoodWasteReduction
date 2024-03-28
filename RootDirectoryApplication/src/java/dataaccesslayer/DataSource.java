/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private Connection connection = null;
    //Set sourcepath when known
    private String url = "jdbc:mysql://localhost:3306/FoodWasteReduction?useSSL=false&&allowPublicKeyRetrieval=true";
    private String username = "root";
    private String password = "algonquin";

    public DataSource() {
    }

    /*
 * Only use one connection for this application, prevent memory leaks.
     */
    public Connection createConnection() throws SQLException {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return connection;
    }
}
