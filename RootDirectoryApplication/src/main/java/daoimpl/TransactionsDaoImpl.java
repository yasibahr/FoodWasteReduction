/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.TransactionsDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Transactions;
import java.util.Properties;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Yasaman, Brian
 */
public class TransactionsDaoImpl implements TransactionsDao{
    ArrayList<Transactions> allTransactions = null;
    
    /**
     * Empty constructor 
     */
    public TransactionsDaoImpl(){}

    /**
     *
     * @return
     * @throws SQLException
     * @throws IOException
     */
    @Override
    public List<Transactions> getAllTransactions() throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT * FROM Transactions ORDER BY transactionID");
            rs=pstmt.executeQuery();
            allTransactions = new ArrayList<Transactions>();
            
            while (rs.next()){
                Transactions transaction = new Transactions();
                
                transaction.setTransactionID(rs.getInt("transactionID"));
                
                //convert java.sql.Timestamp to java.time.LocalDateTime to match SQL's DateTime
                java.sql.Timestamp dbTimestamp = rs.getTimestamp("transactionDate");
                LocalDateTime transactionDate = dbTimestamp != null ? dbTimestamp.toLocalDateTime() : null;
                transaction.setTransactionDate(transactionDate);

                allTransactions.add(transaction); 
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot create new transaction due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot create new transaction due to Input/Output.", ex);
        } 
        return allTransactions;
    }

    /**
     * 
     * @param transactionID
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public Transactions getTransactionByTransactionID(Integer transactionID) throws SQLException, IOException  {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transactions transaction = null;
        
        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT * FROM Transactions WHERE transactionID = ?");
            pstmt.setInt(1, transactionID);
            
            rs=pstmt.executeQuery();
                       
            if (rs.next()){
                transaction = new Transactions();
                
                transaction.setTransactionID(rs.getInt("transactionID")); //get id and set id in DTO
                
                //retrieve transactionDate from rs and store it
                java.sql.Timestamp timestamp = rs.getTimestamp("transactionDate"); //get transactionDate
                LocalDateTime transactionDate = timestamp != null ? timestamp.toLocalDateTime() : null;
                transaction.setTransactionDate(transactionDate); //now can set transactionDate
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot create new transaction due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot create new transaction due to Input/Output.", ex);
        } 
        return transaction;
    }
    
    /**
     * 
     * @param transaction
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void addTransaction(Transactions transaction) throws SQLException, IOException{
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("INSERT INTO Transactions (transactionDate) "
                    + "VALUES (?)");
            
//convert LocalDateTime to Timestamp for the SQL query
            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(transaction.getTransactionDate());
            pstmt.setTimestamp(1, timestamp);

            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot add new transaction because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot add new transaction due to Input/Output.", ex);
        } 
    } 
        
    /**
     * 
     * @param transaction
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void updateTransaction(Transactions transaction) throws SQLException, IOException{
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement("UPDATE Transactions SET transactionDate = ?"
                    + " WHERE transactionID = ?");
            
            //convert LocalDateTime to Timestamp for the SQL query
            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(transaction.getTransactionDate());
            pstmt.setTimestamp(1, timestamp);
               
            pstmt.setInt(2, transaction.getTransactionID().intValue()); //where ID is...

            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot update transaction because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot update transaction due to Input/Output.", ex);
        } 
    } 

    /**
     * 
     * @param transaction
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void deleteTransaction(Transactions transaction) throws SQLException, IOException{
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("DELETE FROM Transactions WHERE transactionID = ?");
            pstmt.setInt(1, transaction.getTransactionID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot delete transaction because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot delete transaction due to Input/Output.", ex);
        } 
    } 
}
