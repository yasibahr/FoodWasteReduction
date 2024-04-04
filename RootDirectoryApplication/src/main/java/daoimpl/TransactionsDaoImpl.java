/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brian
 */
public class TransactionsDaoImpl implements TransactionsDao{
    private Properties dbProperties;
    ArrayList<Transactions> allTransactions = null;

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
            
            String query = "SELECT * FROM Transactions ORDER BY TransactionsID";
            pstmt = con.prepareStatement(query);
            rs=pstmt.executeQuery();
            allTransactions = new ArrayList<Transactions>();
            
            while (rs.next()){
                Transactions transaction = new Transactions();
                int transactionID = rs.getInt("transactionID");
                transaction.setTransactionID(transactionID);
                
                //convert java.sql.Timestamp to java.time.LocalDateTime to match SQL's DateTime
                java.sql.Timestamp dbTimestamp = rs.getTimestamp("transactionDate");
                LocalDateTime transactionDate = dbTimestamp != null ? dbTimestamp.toLocalDateTime() : null;
                transaction.setTransactionDate(transactionDate);

                allTransactions.add(transaction);
            
            }
        } catch (SQLException ex) {
            throw new SQLException("Cannot create new transaction due to issues with SQL.");
//            Logger.getLogger(TransactionsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TransactionsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }

    @Override
    public Transactions getTransactionByTransactionID(Integer transactionID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addTransaction(Transactions transaction) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO \"\" (\"\", \"\") "
                    + "VALUES(?, ?)");
            pstmt.setString(1, .get());
            pstmt.setString(2, .get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void updateTransaction(Transactions transaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTransaction(Transactions transaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
