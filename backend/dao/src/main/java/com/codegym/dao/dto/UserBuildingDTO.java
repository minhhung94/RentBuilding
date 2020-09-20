package com.codegym.dao.dto;

import com.codegym.dao.entity.Customer;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.RoleUser;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

public class UserBuildingDTO implements Serializable {
    private String username;
    private String passwordUser;
    private Integer deleteFlag;
    private Customer customer;
    private RoleUser roleUser;
    private Employee employee;

    public UserBuildingDTO() {
    }

    public UserBuildingDTO(String username, String passwordUser) {
        this.username = username;
        this.passwordUser = passwordUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
