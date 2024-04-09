package businesslayer.usersRegistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator class for various input validations
 * @author Fereshteh
 */
public class Validator {
    
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
            return false;
            
        } else {
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
            return false;
        }
        
        // Check if password contains space
        if (password.contains(" ")) {
            validatorException = "Password cannot contain space!";
            return false;
        }

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
            return false;
        }

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
            return false;
            
        } else {
            return true;
        }
    }
    
    /**
    * Validate city Id.
    * @param cityId The city ID to validate.
    * @return true if valid, false otherwise.
    */
    public boolean validateCityId(int cityId) {
        // Check if cityId is a three-digit number
        if(cityId < 100 || cityId > 999){
            validatorException = "City ID must be a three-digit number!";
            return false;
            
        } else {
            return true;
        }
    }
    
    /**
    * Validate user type Id.
    * @param userTypeID The city ID to validate.
    * @return true if valid, false otherwise.
    */
    public boolean validateUserTypeID(int userTypeID) {
        // Check if cityId is a three-digit number
        if(userTypeID < 100 || userTypeID > 999){
            validatorException = "City ID must be a three-digit number!";
            return false;
            
        } else {
            return true;
        }
    }
    
}

