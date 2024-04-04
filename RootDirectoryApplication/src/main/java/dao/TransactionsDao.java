/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.Transactions;

/**
 *
 * @author Brian, Yasaman
 */
public interface TransactionsDao {
    
        List<Transactions> getAllTransactions() throws SQLException, IOException;
	Transactions getTransactionByTransactionID(Integer transactionID) throws SQLException, IOException;
	void addTransaction(Transactions transaction) throws SQLException, IOException;
	void updateTransaction(Transactions transaction) throws SQLException, IOException;
	void deleteTransaction(Transactions transaction) throws SQLException, IOException;
}
