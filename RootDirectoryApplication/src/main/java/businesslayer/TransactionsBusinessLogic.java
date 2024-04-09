/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.TransactionsDao;
import daoimpl.TransactionsDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.Transactions;

/**
 * Business logic for transactions
 * @author Brian, Yasaman
 */
public class TransactionsBusinessLogic {
    
    private TransactionsDao transactionsDao = null;

    /**
     * Constructor
     */
    public TransactionsBusinessLogic() {
        transactionsDao = new TransactionsDaoImpl();
    }

    /**
     * Get a list of transactions
     * @return list of transactions
     * @throws SQLException
     * @throws IOException 
     */
    public List<Transactions> getAllTransactions() throws SQLException, IOException {
        return transactionsDao.getAllTransactions();
    }
    
    /**
     * Get transaction by ID 
     * @param transactionID
     * @return transaction
     * @throws SQLException
     * @throws IOException 
     */
    public Transactions getTransactionByTransactionID(Integer transactionID) throws SQLException, IOException {
        return transactionsDao.getTransactionByTransactionID(transactionID);
    }
    
    /**
     * Add transaction
     * @param transaction
     * @throws SQLException
     * @throws IOException 
     */
    public void addTransaction(Transactions transaction) throws SQLException, IOException{
        transactionsDao.addTransaction(transaction);
    }
    
    /**
     * Update a transaction
     * @param transaction
     * @throws SQLException
     * @throws IOException 
     */
    public void updateTransaction(Transactions transaction) throws SQLException, IOException{
        transactionsDao.updateTransaction(transaction);
    }
    
    /**
     * Delete a transaction 
     * @param transaction
     * @throws SQLException
     * @throws IOException 
     */
    public void deleteTransaction(Transactions transaction) throws SQLException, IOException{
        transactionsDao.deleteTransaction(transaction);
    }
    
}
