package businesslayer.usersRegistration;

/**
 *
 * @author Fereshteh
 */
public class Retailer extends model.Users implements User {
    
    @Override
    public void signUp(){
        
        setUserTypeID(101);
    
    };
    
}
