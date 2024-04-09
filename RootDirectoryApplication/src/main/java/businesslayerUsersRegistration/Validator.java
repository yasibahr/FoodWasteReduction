package businesslayerUsersRegistration;

import controller.UserRegistrationServlet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;

/**
 * Validator class for various input validations
 * @author Fereshteh, Yasaman
 */
public class Validator {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Validator.class);

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
    //200 to 211
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
    //100 to 103
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
    
    /**
     * Make sure expiration date is right format and is valid date
     * @param expirationDate
     * @return true or false
     */
    public boolean validateExpirationDate(String expirationDate){
        //check if the format is YYYY-MM-DD
        String validDate = "\\d{4}-\\d{2}-\\d{2}";
        
        //if its incorrect format
        if (!expirationDate.matches(validDate)) {
            return false;
        }

        //if its correct format, check if its a date that makes sense
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(expirationDate, formatter);

            //year must be 2024 or after
            if (date.getYear() <= 2024) {
                return false;
            }
            return true; //the date meets all criteria
        } catch (DateTimeParseException e) {
            logger.error("Date format is valid but not correct date");
            return false; //date is not valid
        }
    }
    
    /**
     * Turn a price of type string into a type double and validate it
     * @param price
     * @return a price of type Double
     */
    public Double validateAndParsePrice(String price) {
        try {
            return Double.parseDouble(price); //try to parse the price
        } catch (NumberFormatException e) {
            logger.warn("Price is not a valid number: " + price, e);
            return null; 
        }
    }
       
    /**
     * Turn a date of type string to type Date
     * @param dateString
     * @return a date of type Date
     */
    public Date parseStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            logger.error("Error parsing the date: " + dateString, e);
            return null;
        }
    }
}

