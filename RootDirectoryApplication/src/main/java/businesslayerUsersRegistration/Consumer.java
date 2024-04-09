package businesslayerUsersRegistration;

/**
 *
 * @author Fereshteh
 */
public class Consumer extends model.Users implements User {
   
    @Override
    public void signUp(){
        
        setUserTypeID(102);
    
    };
    
}
