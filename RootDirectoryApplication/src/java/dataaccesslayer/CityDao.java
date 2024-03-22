/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import model.City;

/**
 *
 * @author Brian
 */
public interface CityDao {
    
        List<City> getAllUsers();
	City getCityByCityID(String cityID);
	void addCity(City city);
	void updateCity(City city);
	void deleteCity(City city);
}
