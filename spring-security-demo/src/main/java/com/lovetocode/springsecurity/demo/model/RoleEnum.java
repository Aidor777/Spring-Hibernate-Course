package com.lovetocode.springsecurity.demo.model;

public enum RoleEnum {
    EMPLOYEE, MANAGER, ADMIN;

    public String toSecurityRole() {
        return "ROLE_" + this.name();
    }
}
