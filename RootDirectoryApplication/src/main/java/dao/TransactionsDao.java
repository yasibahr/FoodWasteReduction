/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import model.Transactions;

/**
 *
 * @author Brian
 */
public interface TransactionsDao {
    
        List<Transactions> getAllTransactions() throws SQLException, IOException;
	Transactions getTransactionByTransactionID(Integer transactionID);
	void addTransaction(Transactions transaction);
	void updateTransaction(Transactions transaction);
	void deleteTransaction(Transactions transaction);
}
