/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * DTO for UserType
 * @author Brian
 */
public class UserType {
    
    private Integer userTypeID;
    private String userType;

    /**
     * Get userTypeID.
     * @return Integer
     */
    public Integer getUserTypeID() {
        return userTypeID;
    }

    /**
     * Set userTypeID.
     * @param userTypeID 
     */
    public void setUserTypeID(Integer userTypeID) {
        this.userTypeID = userTypeID;
    }

    /**
     * Get userType.
     * @return String
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Set userType.
     * @param userType 
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }    
}

