/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.MyConnection;

/**
 *
 * @author Administrator
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }

    public OrderDAO() {

    }

    public boolean InsertOrder(OrderDTO dto) throws SQLException {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tblOrders] "
                        + "           ([totalPrice] "
                        + "           ,[date], [dateReturn] "
                        + "           ,[userID]) "
                        + "     VALUES(?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setFloat(1, dto.getTotalPrice());
                ps.setDate(2, dto.getDate());
                ps.setDate(3, dto.getDateReturn());
                ps.setString(4, dto.getUser().getUserID());
                result = ps.executeUpdate() > 0;
            }

        }finally {
            closeConnection();
        }
        return result;
    }

    public int getLastOrderIDByUser(String userID) throws SQLException {
        int result = -1;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = "SELECT TOP(1) orderID FROM [tblOrders] WHERE userID=? ORDER BY userID DESC";
               
                ps = conn.prepareStatement(sql);
                ps.setString(1, userID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("orderID");
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
