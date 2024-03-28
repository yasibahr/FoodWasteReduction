/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import model.StatusType;

/**
 *
 * @author Brian
 */
interface StatusTypeDao {
    
        List<StatusType> getAllStatusTypes();
	StatusType getStatusTypeByStatusTypeID(Integer statusTypeID);
	void addStatusType(StatusType statusType);
	void updateStatusType(StatusType statusType);
	void deleteStatusType(StatusType statusType);
}
