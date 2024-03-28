/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.StatusTypeDaoImpl;
import java.sql.SQLException;
import java.util.List;
import model.StatusType;

/**
 *
 * @author Brian
 */
public class StatusTypeBusinessLogic {
    
    private StatusTypeDaoImpl statusTypeDao = null;

    public StatusTypeBusinessLogic() {
        statusTypeDao = new StatusTypeDaoImpl();
    }
    
    public List<StatusType> getAllStatusTypes() throws SQLException {
        return statusTypeDao.getAllStatusTypes();
    }

    public void addStatusTypeName(StatusType statusType) {
        statusTypeDao.addStatusType(statusType);
    }
}
