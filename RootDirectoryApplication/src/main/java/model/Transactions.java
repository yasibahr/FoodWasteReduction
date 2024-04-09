/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Brian, Yasaman
 */
public class Transactions {
    
    private Integer transactionID;
    private LocalDateTime transactionDate;
    private Users user;
    private City city;
    private Integer userTypeID;

    public Integer getTransactionID() {
        return transactionID;
    }

    /**
     * set transactionid
     * @param transactionID 
     */
    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    /**
     * get transaction date
     * @return date
     */
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    /**
     * set transaction date
     * @param transactionDate 
     */
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    /**
     * get user
     * @return user
     */
    public Users getUser() {
        return user;
    }

    /**
     * set user
     * @param user 
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * get city
     * @return city
     */
    public City getCity() {
        return city;
    }

    /**
     * set city
     * @param city 
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * get user type id
     * @return int
     */
    public Integer getUserTypeID() {
        return userTypeID;
    }

    /**
     * set user type id
     * @param userTypeID 
     */
    public void setUserTypeID(Integer userTypeID) {
        this.userTypeID = userTypeID;
    }
}
