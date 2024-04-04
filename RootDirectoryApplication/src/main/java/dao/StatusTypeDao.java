/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.StatusType;

/**
 *
 * @author Brian, Yasaman
 */
public interface StatusTypeDao {
    
        List<StatusType> getAllStatusTypes() throws SQLException, IOException;
	StatusType getStatusTypeByStatusTypeID(Integer statusTypeID) throws SQLException, IOException;
	void addStatusType(StatusType statusType) throws SQLException, IOException;
	void updateStatusType(StatusType statusType) throws SQLException, IOException;
	void deleteStatusType(StatusType statusType) throws SQLException, IOException;
}
