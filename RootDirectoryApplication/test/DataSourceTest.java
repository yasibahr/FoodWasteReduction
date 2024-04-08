import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.DataSource;

public class DataSourceTest {

    public static void main(String[] args) {
        try {
            Connection connection = DataSource.getConnection();
            System.out.println("Connection to the database was successful.");
            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }
}