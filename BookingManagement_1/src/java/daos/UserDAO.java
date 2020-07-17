/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RoleDTO;
import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.MyConnection;

/**
 *
 * @author Administrator
 */
public class UserDAO {

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

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        conn = MyConnection.getConnection();
        UserDTO dto = null;
        try {
            if (conn != null) {
                String sql = "SELECT  u.userName, u.roleID, u.status, r.roleName, r.status AS roleStatus "
                        + "FROM tblRoles r JOIN tblUsers u "
                        + "ON r.roleID=u.roleID "
                        + "WHERE userID=? AND password=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    boolean status = rs.getBoolean("status");
                    if (status) {
                        String userName = rs.getString("userName");
                        int roleID = rs.getInt("roleID");
                        String roleName = rs.getString("roleName");
                        boolean roleStatus = rs.getBoolean("roleStatus");
                        RoleDTO roleDTO = new RoleDTO(roleID, roleName, roleStatus);
                        dto = new UserDTO(userID, userName, roleDTO, "***", status);
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public void createAUser(UserDTO user) throws SQLException {
        conn = MyConnection.getConnection();

        try {
            if (conn != null) {
                String sql = "insert into tblUsers(userID, userName, password, roleID, status) values(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUserID());
                ps.setString(2, user.getUserName());
                ps.setString(3, user.getPassword());
                ps.setInt(4, 1);
                ps.setBoolean(5, true);
                ps.executeUpdate();

            }
        } finally {
            closeConnection();
        }

    }

}
