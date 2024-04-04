/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.City;

/**
 *
 * @author Brian
 */
public class CityDaoImpl implements CityDao{
    
    public CityDaoImpl(){
        
    }

    @Override
    public List<City> getAllCities() {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<City> cities = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT cityID, cityName, country FROM City ORDER BY cityID");
            rs = pstmt.executeQuery();
            cities = new ArrayList<City>();
            while (rs.next()) {
                City city = new City();
                city.setCityID(new Integer(rs.getInt("cityID")));
                city.setCityName(rs.getString("cityName"));
                city.setCountry(rs.getString("country"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return cities;
    }

    @Override
    public City getCityByCityID(Integer cityID){
        
       Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        City city = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT cityID, cityName, country FROM City WHERE cityID = ?");
            pstmt.setInt(1, cityID.intValue());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                city = new City();
                city.setCityID(new Integer(rs.getInt("cityID")));
                city.setCityName(rs.getString("cityName"));
                city.setCountry(rs.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return city;
    }
    @Override
    public void addCity(City city) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // cityID is auto increment 
            pstmt = con.prepareStatement(
                    "INSERT INTO \"City\" (\"cityName\", \"country\") "
                    + "VALUES(?, ?)");
            pstmt.setString(1, city.getCityName());
            pstmt.setString(2, city.getCountry());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void updateCity(City city) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE \"City\" SET \"cityName\" = ?, "
                    + "\"country\" = ? WHERE \"cityID\" = ?");
            pstmt.setString(1, city.getCityName());
            pstmt.setString(2, city.getCountry());
            //example has city.getCityID().intValue()); but that causes an error here for unknown reasons. 
            //says "int cannot be derefferenced"
            pstmt.setInt(3, city.getCityID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void deleteCity(City city) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM \"City\" WHERE \"cityID\" = ?");
            pstmt.setInt(1, city.getCityID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    } 
    
}
