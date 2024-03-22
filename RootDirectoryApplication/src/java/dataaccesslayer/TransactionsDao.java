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
    
        List<Transactions> getAllTransactions();
	Transactions getTransactionByTransactionID(String transactionID);
	void addUser(Transactions transaction);
	void updateUser(Transactions transaction);
	void deleteUser(Transactions transaction);
}
