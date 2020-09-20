package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties
@Table(name = "user_building")
public class UserBuilding {
    @Id

//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
//    @GeneratedValue(strategy=GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String username;

    @Column(name = "password_user")
    private String passwordUser;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

//    @JsonManagedReference(value = "userBuildingCustomer")
    @OneToOne(mappedBy = "userBuilding")
    private Customer customer;

//    @JsonManagedReference(value = "id_role")
    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleUser roleUser;

    @OneToOne(mappedBy = "userBuilding")
//    @JsonManagedReference (value = "userBuildingEmployee")
    private Employee employee;

    public UserBuilding() {
    }

    @Override
    public String toString() {
        return "UserBuilding{" +
                "username='" + username + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", customer=" + customer +
                ", roleUser=" + roleUser +
                ", employee=" + employee +
                '}';
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
