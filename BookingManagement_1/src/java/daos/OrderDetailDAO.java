/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.MyConnection;

/**
 *
 * @author Administrator
 */
public class OrderDetailDAO {

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

    public OrderDetailDAO() {
    }

    public boolean insertOrderDetail(OrderDetailDTO dto) throws SQLException {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tblOrderDetails] "
                        + "           ([orderID] "
                        + "           ,[bookID] "
                        + "           ,[amount] "
                        + "           ,[totalPrice]) "
                        + "     VALUES(?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, dto.getOrder().getOrderID());
                ps.setInt(2, dto.getBook().getBookID());
                ps.setInt(3, dto.getAmount());
                ps.setFloat(4, dto.getTotalPrice());
                result = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
