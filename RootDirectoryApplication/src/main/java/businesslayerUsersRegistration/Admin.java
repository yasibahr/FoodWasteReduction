package businesslayer.usersRegistration;

/**
 *
 * @author Fereshteh
 */
public class Admin extends model.Users implements User {
    
    @Override
    public void signUp(){
        
        setUserTypeID(100);
        
    };
    
}
