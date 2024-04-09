/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.CityDao;
import daoimpl.CityDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.City;
import model.Transactions;

/**
 * Business logic for city class
 * @author Brian, Yasaman
 */
public class CityBusinessLogic {
    
    private CityDao cityDao = null;

    /**
     * Constructor 
     */
    public CityBusinessLogic() {
        cityDao = new CityDaoImpl();
    }

    /**
     * Get list of all cities
     * @return list of cities
     * @throws SQLException
     * @throws IOException 
     */
    public List<City> getAllCities() throws SQLException, IOException {
        return cityDao.getAllCities();
    }

    /**
     * Get a city by its ID
     * @param cityID
     * @return a City
     * @throws SQLException
     * @throws IOException 
     */
    public City getCityByCityID(Integer cityID) throws SQLException, IOException {
        return cityDao.getCityByCityID(cityID);
    }
    
    /**
     * Add a city to the database
     * @param city
     * @throws SQLException
     * @throws IOException 
     */
    public void addCity(City city) throws SQLException, IOException{
        cityDao.addCity(city);
    }
    
    /**
     * Update a city field in the database
     * @param city
     * @throws SQLException
     * @throws IOException 
     */
    public void updateCity(City city) throws SQLException, IOException{
        cityDao.updateCity(city);
    }
    
    /**
     * Delete a city field in the database
     * @param city
     * @throws SQLException
     * @throws IOException 
     */
    public void deleteCity(City city) throws SQLException, IOException{
        cityDao.deleteCity(city);
    }
    
}