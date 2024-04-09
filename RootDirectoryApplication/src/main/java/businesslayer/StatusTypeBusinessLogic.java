/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import daoimpl.StatusTypeDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.StatusType;
import dao.StatusTypeDao;

/**
 * Business logic for statusType
 * @author Brian, Yasaman
 */
public class StatusTypeBusinessLogic {
    
    private StatusTypeDao statusTypeDao = null;

    /**
     * Constructor
     */
    public StatusTypeBusinessLogic() {
        statusTypeDao = new StatusTypeDaoImpl();
    }
    
    /**
     * Get list of all statusTypes
     * @return list of statusTypes
     * @throws SQLException
     * @throws IOException 
     */
    public List<StatusType> getAllStatusTypes() throws SQLException, IOException {
        return statusTypeDao.getAllStatusTypes();
    }

    /**
     * Get statusType by ID
     * @param statusTypeID
     * @return statusType
     * @throws SQLException
     * @throws IOException 
     */
    public StatusType getStatusTypeByStatusTypeID(Integer statusTypeID) throws SQLException, IOException {
        return statusTypeDao.getStatusTypeByStatusTypeID(statusTypeID);
    }
       
    /**
     * Add statusType
     * @param statusType
     * @throws SQLException
     * @throws IOException 
     */
    public void addStatusTypeName(StatusType statusType) throws SQLException, IOException{
        statusTypeDao.addStatusType(statusType);
    }
    
    /**
     * Update statusType in database
     * @param statusType
     * @throws SQLException
     * @throws IOException 
     */
    public void updateTransaction(StatusType statusType) throws SQLException, IOException{
        statusTypeDao.updateStatusType(statusType);
    }
    
    /**
     * Delete a statusType in database
     * @param statusType
     * @throws SQLException
     * @throws IOException 
     */
    public void deleteTransaction(StatusType statusType) throws SQLException, IOException{
        statusTypeDao.deleteStatusType(statusType);
    }
}
