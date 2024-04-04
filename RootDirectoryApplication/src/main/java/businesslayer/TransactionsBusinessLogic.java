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
 *
 * @author Brian, Yasaman
 */
public class TransactionsBusinessLogic {
    
    private TransactionsDao transactionsDao = null;

    public TransactionsBusinessLogic() {
        transactionsDao = new TransactionsDaoImpl();
    }

    public List<Transactions> getAllTransactions() throws SQLException, IOException {
        return transactionsDao.getAllTransactions();
    }
    
    public Transactions getTransactionByTransactionID(Integer transactionID) throws SQLException, IOException {
        return transactionsDao.getTransactionByTransactionID(transactionID);
    }
    
    public void addTransaction(Transactions transaction) throws SQLException, IOException{
        transactionsDao.addTransaction(transaction);
    }
    
    public void updateTransaction(Transactions transaction) throws SQLException, IOException{
        transactionsDao.updateTransaction(transaction);
    }
    
    public void deleteTransaction(Transactions transaction) throws SQLException, IOException{
        transactionsDao.deleteTransaction(transaction);
    }
    
}
