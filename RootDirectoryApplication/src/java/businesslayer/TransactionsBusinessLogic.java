/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Brian
 */
public class TransactionsBusinessLogic {
    
    private TransactionsDaoImpl transactionsDao = null;

    public TransactionsBusinessLogic() {
        transactionsDao = new TransactionsDaoImpl();
    }

    public List<Transaction> getAllTransactions() throws SQLException {
        return transactionsDao.getAll();
    }

    public void addTransaction(Transaction transaction) {
        transactionsDao.addTransaction(transaction);
    }
}
