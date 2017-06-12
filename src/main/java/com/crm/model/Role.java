package com.crm.model;

public class Role {
    private Integer roleId;

    private String roleName;

    private Integer parentRole;

    private Integer depth;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getParentRole() {
        return parentRole;
    }

    public void setParentRole(Integer parentRole) {
        this.parentRole = parentRole;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}