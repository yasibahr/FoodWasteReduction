/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.StatusTypeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.StatusType;

/**
 *
 * @author Brian
 */
public class StatusTypeDaoImpl implements StatusTypeDao {

    @Override
    public List<StatusType> getAllStatusTypes() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<StatusType> statusTypes = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT authorID, firstName, lastName FROM authors ORDER BY authorID");
            rs = pstmt.executeQuery();
            statusTypes = new ArrayList<StatusType>();
            while (rs.next()) {
                StatusType statusType = new StatusType();
                statusType.setStatusTypeID(new Integer(rs.getInt("statusTypeID")));
                statusType.setStatusTypeName(rs.getString("firstName"));
                statusTypes.add(statusType);
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
        return statusTypes;
    }

    @Override
    public StatusType getStatusTypeByStatusTypeID(Integer statusTypeID) {
       Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StatusType statusType = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StatustypeID, StatusTypeName FROM StatusType WHERE StatusTypeID = ?");
            pstmt.setInt(1, statusTypeID.intValue());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                statusType = new StatusType();
                statusType.setStatusTypeID(new Integer(rs.getInt("authorID")));
                statusType.setStatusTypeName(rs.getString("firstName"));
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
        return statusType;
    }

    @Override
    public void addStatusType(StatusType statusType) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO \"Status_Type\" (\"statusTypeName\") "
                    + "VALUES(?)");
            pstmt.setString(1, statusType.getStatusTypeName());
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
    public void updateStatusType(StatusType statusType) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE \"Status_Type\" SET \"statusTypeName\" = ?, "
                    + "WHERE \"statusTypeID\" = ?");
            pstmt.setString(1, statusType.getStatusTypeName());
            pstmt.setInt(3, statusType.getStatusTypeID().intValue());
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
    public void deleteStatusType(StatusType statusType) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM \"Status_Type\" WHERE \"statusTypeID\" = ?");
            pstmt.setInt(1, statusType.getStatusTypeID());
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
