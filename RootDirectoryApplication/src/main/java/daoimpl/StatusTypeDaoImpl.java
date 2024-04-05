/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.StatusTypeDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.City;
import model.StatusType;

/**
 *
 * @author Brian, Yasaman
 */
public class StatusTypeDaoImpl implements StatusTypeDao {
    ArrayList<StatusType> allStatusTypes = null;

    /**
     * Empty constructor. 
     */
    public StatusTypeDaoImpl(){}
    
    /**
     * 
     * @return 
     */
    @Override
    public List<StatusType> getAllStatusTypes() throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "statusTypeID, "
                    + "statusTypeName "
                    + "FROM Status_Type "
                    + "ORDER BY statusTypeID");
            
            rs=pstmt.executeQuery(); //execute query and store result in rs
            
            allStatusTypes = new ArrayList<StatusType>();
            
            //converts each row of the rs int a City object
            while (rs.next()){
                StatusType statusType = new StatusType();
                
                statusType.setStatusTypeID(rs.getInt("statusTypeID"));

                statusType.setStatusTypeName(rs.getString("statusTypeName"));

                allStatusTypes.add(statusType); //results in many statusTypes if there are many rows from DB (rs)
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get all statusTypes due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get all statusTypes due to Input/Output.", ex);
        } 
        return allStatusTypes;
    }

    /**
     * 
     * @param statusTypeID
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public StatusType getStatusTypeByStatusTypeID(Integer statusTypeID) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StatusType statusType = null;
        
        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "statusTypeID, "
                    + "statusTypeName"
                    + "FROM Status_Type "
                    + "WHERE statusTypeID = ?");
            
            pstmt.setInt(1, statusTypeID);

            rs=pstmt.executeQuery();
                       
            while (rs.next()){
                statusType = new StatusType();
                
                statusType.setStatusTypeID(rs.getInt("statusTypeID")); //get id and set id in DTO
                
                statusType.setStatusTypeName(rs.getString("statusTypeName"));
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get statusType by id due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get statusType by id due to Input/Output.", ex);
        } 
        return statusType;
    }

    /**
     * 
     * @param statusType
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void addStatusType(StatusType statusType) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("INSERT INTO Status_Type "
                    + "(statusTypeName) "
                    + "VALUES (?)");

            pstmt.setString(1, statusType.getStatusTypeName());

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
                throw new SQLException("Cannot add new statusType because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot add new statusType due to Input/Output.", ex);
        } 
    }

    /**
     * 
     * @param statusType
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void updateStatusType(StatusType statusType) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement("UPDATE Status_Type SET "
                    + "statusTypeName = ?, "
                    + "WHERE statusTypeID = ?");
            
            pstmt.setString(1, statusType.getStatusTypeName());
            
            pstmt.setInt(2, statusType.getStatusTypeID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot update statusType because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot update statusType due to Input/Output.", ex);
        } 
    }

    /**
     * 
     * @param statusType
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void deleteStatusType(StatusType statusType) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("DELETE FROM Status_Type "
                    + "WHERE statusTypeID = ?");
            
            pstmt.setInt(1, statusType.getStatusTypeID());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot delete statusType because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot delete statusType due to Input/Output.", ex);
        } 
    }
    
}
