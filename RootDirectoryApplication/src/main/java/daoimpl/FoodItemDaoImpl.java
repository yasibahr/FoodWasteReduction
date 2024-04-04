/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.FoodItemDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.FoodItem;

/**
 *
 * @author Brian
 */
public class FoodItemDaoImpl implements FoodItemDao{

    @Override
    public List<FoodItem> getAllFoodItems() {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<FoodItem> foodItems = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT foodID, foodName, expierationDate, price, quantity, statusTypeID, transactionID, userID, userTypeID FROM Food_Items ORDER BY foodID");
            rs = pstmt.executeQuery();
            foodItems = new ArrayList<FoodItem>();
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setFoodID(rs.getInt("foodID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setExpirationDate(rs.getDate("expirationDate"));
                foodItem.setPrice(rs.getFloat("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setStatusTypeID(rs.getInt("statusTypeID"));
                foodItem.setStatusTypeID(rs.getInt("transactionID"));
                foodItem.setStatusTypeID(rs.getInt("userID"));
                foodItem.setStatusTypeID(rs.getInt("userTypeID"));
                foodItems.add(foodItem);
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
        return foodItems;
    }

    @Override
    public FoodItem getFoodItemByFoodItemID(Integer foodID) {
         Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        FoodItem foodItem = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT foodID, foodName, expierationDate, price, quantity, statusTypeID, transactionID, userID, userTypeID, cityID FROM Food_Item WHERE foodID = ?");
            pstmt.setInt(1, foodID.intValue());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                foodItem = new FoodItem();
                foodItem.setFoodID(new Integer(rs.getInt("foodID")));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setExpirationDate(rs.getDate("expirationDate"));
                foodItem.setPrice(rs.getFloat("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setStatusTypeID(rs.getInt("statusTypeID"));
                foodItem.setStatusTypeID(rs.getInt("transactionID"));
                foodItem.setStatusTypeID(rs.getInt("userID"));
                foodItem.setStatusTypeID(rs.getInt("userTypeID"));
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
        return foodItem;
    }

    @Override
    public void addFoodItem(FoodItem foodItem) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO \"Food_Item\" (\"foodName\", \"expirationDate\", \"price\", \"quantity\", \"statusTypeID\", \"transactionID\""
                    + ", \"userID\", \"userTypeID\", \"cityID\") VALUES(?, ?)");
            pstmt.setString(1, foodItem.getFoodName());
            pstmt.setDate(2, (Date) foodItem.getExpirationDate());
            pstmt.setFloat(3, foodItem.getPrice());
            pstmt.setInt(4, foodItem.getQuantity());
            pstmt.setInt(5, foodItem.getStatusTypeID());
            pstmt.setInt(6, foodItem.getTransactionID());
            pstmt.setInt(7, foodItem.getUserID());
            pstmt.setInt(8, foodItem.getUserTypeID());
            pstmt.setInt(9, foodItem.getCityID());
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
    public void updateFoodItem(FoodItem foodItem) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE \"Food_Item\" SET \"foodName\" = ?, "
                    + "\"expirationDate\" = ?, \"price\" = ?, \"quantity\" = ?, \"statusTypeID\" = ?, "
                    + "\"transactionID\" = ?, \"userID\" = ?, \"userTypeID\" = ?, \"cityID\" = ? WHERE \"foodID\" = ?");
            pstmt.setString(1, foodItem.getFoodName());
            pstmt.setDate(2, (Date) foodItem.getExpirationDate());
            pstmt.setFloat(3, foodItem.getPrice());
            pstmt.setInt(4, foodItem.getQuantity());
            pstmt.setInt(5, foodItem.getStatusTypeID());
            pstmt.setInt(6, foodItem.getTransactionID());
            pstmt.setInt(7, foodItem.getUserID());
            pstmt.setInt(8, foodItem.getUserTypeID());
            pstmt.setInt(9, foodItem.getCityID());
            pstmt.setInt(10, foodItem.getFoodID());
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
    public void deleteFoodItem(FoodItem foodItem) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM \"Food_Item\" WHERE \"foodID\" = ?");
            pstmt.setInt(1, foodItem.getFoodID());
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