/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Brian
 */
public class CityBusinessLogic {
    
    private CityDaoImpl authorsDao = null;

    public AuthorsBusinessLogic() {
        cityDao = new CityDaoImpl();
    }

    public List<City> getAllCities() throws SQLException {
        return cityDao.getAllCities();
    }

    public void addCity(City city) {
        cityDao.addCity(city);
    }
}
