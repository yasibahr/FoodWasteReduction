/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Used to connect to the database 
 * @author Yasaman, Brian
 */
public class DataSource {

    private static Connection connection = null;

    private DataSource() { }

    /**
     * Establishes the connection 
     * @return Connection
     * @throws SQLException 
     * @throws IOException 
     */
    public static Connection getConnection() throws SQLException, IOException {    	
        String[] connectionInfo = openPropsFile();

        try {
            if (connection == null) { //if connection doesn't exist 
                connection = DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]); //create cxn 
            } 
        } catch (SQLException ex) {
            throw new SQLException ("Could not create connection");
        }
        return connection;
    }

    /**
     * Open properties file and gets the information inside
     * @return Database information in a String list
     * @throws IOException 
     */
    private static String[] openPropsFile() throws IOException {

        Properties props = new Properties();
        // Use the class loader to find the database.properties file in the classpath
        try (InputStream in = DataSource.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (in == null) {
                throw new IOException("database.properties file not found in classpath");
            }
            props.load(in);
        } catch (IOException e) {
            throw new IOException("Could not retrieve database.properties information", e);
        }

        String connectionString = "jdbc:" + props.getProperty("db") + "://" + 
                props.getProperty("host") + ":" + 
                props.getProperty("port") + "/" + 
                props.getProperty("name");
        String username = props.getProperty("user");
        String password = props.getProperty("pass");

        String[] info = new String[3];
        info[0] = connectionString;
        info[1] = username;
        info[2] = password;

        return info;
    }   
}
