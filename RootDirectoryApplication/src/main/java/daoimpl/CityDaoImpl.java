/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.CityDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.City;
import model.Transactions;

/**
 *
 * @author Brian, Yasaman
 */
public class CityDaoImpl implements CityDao{
    ArrayList<City> allCities = null;    

    /**
     * Empty constructor 
     */    
    public CityDaoImpl(){}

    @Override
    public List<City> getAllCities() throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT cityID, cityName, country FROM City ORDER BY cityID");
            rs=pstmt.executeQuery();
            allCities = new ArrayList<City>();
            
            while (rs.next()){
                City city = new City();

                city.setCityName(rs.getString("cityName"));

                city.setCountry(rs.getString("country"));

                allCities.add(city);
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot create new city due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot create new city due to Input/Output.", ex);
        } 
        return allCities;
    }
            
    /**
     * 
     * @param cityID
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public City getCityByCityID(Integer cityID) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        City city = null;
        
        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT cityID, cityName, country FROM City WHERE cityID = ?");
            pstmt.setInt(1, cityID);

            rs=pstmt.executeQuery();
                       
            while (rs.next()){
                city = new City();
                
                city.setCityID(rs.getInt("cityID")); //get id and set id in DTO
                
                city.setCityName(rs.getString("cityName"));
                
                city.setCountry(rs.getString("country"));
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot create new city due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot create new city due to Input/Output.", ex);
        } 
        return city;
    }
        
    /**
     * 
     * @param city
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void addCity(City city) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("INSERT INTO City (cityName, country) "
                    + "VALUES (?, ?)");

            pstmt.setString(1, city.getCityName());
            pstmt.setString(2, city.getCountry());

            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot add new city because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot add new city due to Input/Output.", ex);
        } 
    } 

    /**
     * 
     * @param city
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void updateCity(City city) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement("UPDATE City SET cityName = ?, country = ?"
                    + " WHERE cityID = ?");
            
            pstmt.setString(1, city.getCityName());
            
            pstmt.setString(2, city.getCountry());

            pstmt.setInt(3, city.getCityID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot update city because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot update city due to Input/Output.", ex);
        } 
    } 

    /**
     * 
     * @param city
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void deleteCity(City city) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("DELETE FROM City WHERE cityID = ?");
            
            pstmt.setInt(1, city.getCityID());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot delete city because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot delete city due to Input/Output.", ex);
        } 
//        finally {
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//            }
//        }
    } 
}
