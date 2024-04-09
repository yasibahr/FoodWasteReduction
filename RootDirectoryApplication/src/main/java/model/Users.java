package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * DTO for Users
 * @author Brian, Yasaman
 */
public class Users {
    
    private Integer userID;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private Integer userTypeID;
    private Integer cityID;
    private UserType userType;
    private City city;

    /**
     * Get userID
     * @return Integer
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Set userID
     * @param userID 
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * get UserName
     * @return String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set userName
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get password
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get email 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get phone
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Get userTypeID
     * @return int
     */
    public Integer getUserTypeID() {
        return userTypeID;
    }

    /**
     * Set userTypeID
     * @param userTypeID 
     */
    public void setUserTypeID(Integer userTypeID) {
        this.userTypeID = userTypeID;
    }

    /**
     * Get cityID
     * @return int
     */
    public Integer getCityID() {
        return cityID;
    }

    /**
     * Set cityID
     * @param cityID 
     */
    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }
    
    /**
     * Get userType 
     * @return userType object
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Set userType
     * @param userType 
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    /**
     * Get city
     * @return city object
     */
    public City getCity() {
        return city;
    }

    /**
     * Set city
     * @param city 
     */
    public void setCity(City city) {
        this.city = city;
    }
}
