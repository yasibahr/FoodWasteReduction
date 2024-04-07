package businesslayer.usersRegistration;

/**
 *
 * @author Fereshteh
 */
public class UserFactory {
    
    public static User createUser(String userType) {
        
        User user = null;
        
        if ("retailer".equals(userType)) {
            user = new Retailer();
        } else if ("consumer".equals(userType)) {
            user = new Consumer();
        } else if ("charity".equals(userType)) {
            user = new Charity();
        } else if ("admin".equals(userType)) {
            user = new Admin();
        }

        return user;
        
    }
    
}
