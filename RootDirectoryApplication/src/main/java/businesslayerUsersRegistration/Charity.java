package businesslayerUsersRegistration;

/**
 *
 * @author Fereshteh
 */
public class Charity extends model.Users implements User {
    
    @Override
    public void signUp(){
        
        setUserTypeID(103);
        
    };
    
}
