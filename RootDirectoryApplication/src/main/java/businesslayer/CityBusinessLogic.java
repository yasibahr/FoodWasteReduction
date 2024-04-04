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
 *
 * @author Brian, Yasaman
 */
public class CityBusinessLogic {
    
    private CityDao cityDao = null;

    public CityBusinessLogic() {
        cityDao = new CityDaoImpl();
    }

    public List<City> getAllCities() throws SQLException, IOException {
        return cityDao.getAllCities();
    }

    public City getCityByCityID(Integer cityID) throws SQLException, IOException {
        return cityDao.getCityByCityID(cityID);
    }
    
    public void addCity(City city) throws SQLException, IOException{
        cityDao.addCity(city);
    }
    public void updateCity(City city) throws SQLException, IOException{
        cityDao.updateCity(city);
    }
    
    public void deleteCity(City city) throws SQLException, IOException{
        cityDao.deleteCity(city);
    }
    
}