package businesslayerUsersRegistration;

import controller.UserRegistrationServlet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;

/**
 * Validator class for various input validations
 * @author Fereshteh
 */
public class Validator {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(UserRegistrationServlet.class);

    private String validatorException;
    
    public String getValidatorException(){
        return validatorException;
    }

    /**
     * Validate user name.
     * @param userName to validate.
     * @return true if valid, false otherwise.
     */
    public boolean validateUserName(String userName) {
        // Check if userName starts with a letter, followed by 1 to 49 letters, digits, underscores, or hyphens
        if(!userName.matches("^[a-zA-Z][a-zA-Z0-9_-]{0,49}$")) {
            validatorException = "userName is invalid!";
            logger.error("userName is not valid");
            return false;
            
        } else {
            logger.info("userName is valid");
            return true;
        }
    }
    
    /**
     * Validate password.
     * @param password to validate.
     * @return true if valid, false otherwise.
     */
    public boolean validatePassword(String password) {
        // Check if password length is between 8 and 50 characters
        if (password.length() < 8 || password.length() > 50) {
            validatorException = "Password length must be between 8 and 50 characters!";
            logger.error("password is not valid. it is not correct length");
            return false;
        }
        
        // Check if password contains space
        if (password.contains(" ")) {
            validatorException = "Password cannot contain space!";
            logger.error("password is not valid, contains space");
            return false;
        }
        logger.info("password is valid");
        return true;
    }
    
    /**
     * Validate email.
     * @param email to validate.
     * @return true if valid, false otherwise.
     */
    public boolean validateEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            validatorException = "Invalid email address!";
            logger.error("email is not valid");
            return false;
        }
        logger.info("email is valid");
        return true;
    }
    
    /**
    * Validate phone number.
    * @param phoneNumber The phone number to validate.
    * @return true if valid, false otherwise.
    */
    public boolean validatePhoneNumber(String phoneNumber) {
        // Check if phoneNumber contains only digits and has length between 10 and 15
        if(!phoneNumber.matches("^\\d{10,15}$")){
            validatorException = "Phone number is invalid!";
            logger.error("phone number is not valid");
            return false;
            
        } else {
            logger.info("phone number is valid");
            return true;
        }
    }
    
    /**
    * Validate city Id.
    * @param cityId The city ID to validate.
    * @return true if valid, false otherwise.
    */
    //*******************200 to 211 **************
    public boolean validateCityID(int cityID) {
        // Check if cityId is a three-digit number
        if(cityID < 100 || cityID > 999){
            validatorException = "City ID must be a three-digit number!";
            logger.error("cityID is not valid");
            return false;
            
        } else {
            logger.info("cityID is valid");
            return true;
        }
    }
    
    /**
    * Validate user type Id.
    * @param userTypeID The city ID to validate.
    * @return true if valid, false otherwise.
    */
    //********************100 to 103************
    public boolean validateUserTypeID(int userTypeID) {
        // Check if cityId is a three-digit number
        if(userTypeID < 100 || userTypeID > 999){
            validatorException = "UserType ID must be a three-digit number!";
            logger.error("userTypeID is not valid");
            return false;
            
        } else {
            logger.info("userTypeID is valid");
            return true;
        }
    }
    
}
