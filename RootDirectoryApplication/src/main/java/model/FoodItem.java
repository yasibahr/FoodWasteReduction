package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
import java.util.Date;

/**
 * DTO for foodItem
 * @author Brian, Yasaman
 */
public class FoodItem {
    
    private Integer foodID;
    private String foodName;
    private Date expirationDate;
    private float price;
    private int quantity;
    private Integer statusTypeID;
    private Integer transactionID;
    private Integer userID;
    private Integer userTypeID;
    private Integer cityID;
    private StatusType statusType;
    private Transactions transactions;
    private Users user;
    private UserType userType;
    private City city;

    /**
     * get food id
     * @return int
     */
    public Integer getFoodID() {
        return foodID;
    }

    /**
     * set food id
     * @param foodID 
     */
    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    /**
     * get food name
     * @return string
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * set food name
     * @param foodName 
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * get exp date
     * @return date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * set exp date
     * @param expirationDate 
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * get price
     * @return float
     */
    public float getPrice() {
        return price;
    }

    /**
     * set price
     * @param price 
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * get quantity
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set quantity
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * get status type id
     * @return int
     */
    public Integer getStatusTypeID() {
        return statusTypeID;
    }

    /**
     * set status type id
     * @param statusTypeID 
     */
    public void setStatusTypeID(Integer statusTypeID) {
        this.statusTypeID = statusTypeID;
    }

    /**
     * get transaction id
     * @return int
     */
    public Integer getTransactionID() {
        return transactionID;
    }

    /**
     * set transasction id
     * @param transactionID 
     */
    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    /**
     * get user id
     * @return int
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * set user id
     * @param userID 
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
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

    /**
     * get city id
     * @return int
     */
    public Integer getCityID() {
        return cityID;
    }

    /**
     * set city id
     * @param cityID 
     */
    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     * get status type
     * @return status type object
     */
    public StatusType getStatusType() {
        return statusType;
    }

    /**
     * set status type
     * @param statusType 
     */
    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }
    
    /**
     * get transasction
     * @return transaction object
     */
    public Transactions getTransactions() {
        return transactions;
    }

    /**
     * set transaction
     * @param transactions 
     */
    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    /**
     * get user
     * @return user object
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
     * get user type
     * @return user type object
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * set user type
     * @param userType 
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * get city
     * @return city object
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
}