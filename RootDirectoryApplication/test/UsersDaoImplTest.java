import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.DataSource;
import daoimpl.UsersDaoImpl;
import model.Users;

public class UsersDaoImplTest {

    public static void main(String[] args) {
        try {
            Connection connection = DataSource.getConnection();
            System.out.println("Connection to the database was successful.");
            
            
            Users user = new Users();
            user.setUserName("admin2");
            user.setPassword("12345678910");
            user.setEmail("admin2@gmail.com");
            user.setPhone("5144312222");
            user.setCityID(200);
            user.setUserTypeID(100);
            
            UsersDaoImpl userDaoImpl = new UsersDaoImpl();
            try {
                userDaoImpl.addUser(user);
                System.out.println("User added!");
            } catch (SQLException e) {
                System.out.println(e);
            }
            
            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }
}



