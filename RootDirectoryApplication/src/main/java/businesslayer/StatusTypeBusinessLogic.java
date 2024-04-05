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
 *
 * @author Brian, Yasaman
 */
public class StatusTypeBusinessLogic {
    
    private StatusTypeDao statusTypeDao = null;

    public StatusTypeBusinessLogic() {
        statusTypeDao = new StatusTypeDaoImpl();
    }
    
    public List<StatusType> getAllStatusTypes() throws SQLException, IOException {
        return statusTypeDao.getAllStatusTypes();
    }

    public StatusType getStatusTypeByStatusTypeID(Integer statusTypeID) throws SQLException, IOException {
        return statusTypeDao.getStatusTypeByStatusTypeID(statusTypeID);
    }
        
    public void addStatusTypeName(StatusType statusType) throws SQLException, IOException{
        statusTypeDao.addStatusType(statusType);
    }
    
    public void updateTransaction(StatusType statusType) throws SQLException, IOException{
        statusTypeDao.updateStatusType(statusType);
    }
    
    public void deleteTransaction(StatusType statusType) throws SQLException, IOException{
        statusTypeDao.deleteStatusType(statusType);
    }
}
