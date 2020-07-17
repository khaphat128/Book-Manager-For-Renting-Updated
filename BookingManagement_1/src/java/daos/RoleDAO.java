/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RoleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.MyConnection;

/**
 *
 * @author Administrator
 */
public class RoleDAO {

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

    public RoleDAO() {
    }

    public RoleDTO getRoleDTOByRoleName(String roleName) throws SQLException {
        conn = MyConnection.getConnection();
        RoleDTO dto = null;
        try {
            if (conn != null) {
                String sql = "SELECT [roleID]"
                        + "      ,[roleName]"
                        + "      ,[status]"
                        + "  FROM [dbo].[tblRoles] WHERE roleName = ? AND Status=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, roleName);
                ps.setBoolean(2, true);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int roleID = rs.getInt("roleID");
                    boolean status = rs.getBoolean("status");
                    dto = new RoleDTO(roleID, roleName, status);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
  
}
