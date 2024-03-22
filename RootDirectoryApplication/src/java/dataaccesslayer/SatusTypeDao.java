/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import model.StatusType;

/**
 *
 * @author Brian
 */
public interface SatusTypeDao {
    
        List<StatusType> getAllStatusTypes();
	StatusType getStatusTypeByStatusTypeID(String statusTypeID);
	void addStatusType(StatusType statusType);
	void updateStatusType(StatusType statusType);
	void deleteStatusType(StatusType statusType);
}
