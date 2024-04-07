package businesslayer.usersRegistration;

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
