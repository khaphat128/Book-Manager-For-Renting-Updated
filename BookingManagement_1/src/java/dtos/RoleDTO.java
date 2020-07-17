/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Administrator
 */
public class RoleDTO {
    private int roleID;
    private String roleName;
    private boolean status;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RoleDTO(int roleID, String roleName, boolean status) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.status = status;
    }

    public RoleDTO() {
    }
}
