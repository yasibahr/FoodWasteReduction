/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.City;

/**
 *
 * @author Brian, Yasaman
 */
public interface CityDao {
    
        List<City> getAllCities() throws SQLException, IOException;
        City getCityByCityID(Integer cityID) throws SQLException, IOException;
	void addCity(City city) throws SQLException, IOException;
	void updateCity(City city) throws SQLException, IOException;
	void deleteCity(City city) throws SQLException, IOException;
}
