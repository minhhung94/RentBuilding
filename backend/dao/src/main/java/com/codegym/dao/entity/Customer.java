package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer id;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Column(name = "name_customer",nullable = false)
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "phone")
    private String phone;


    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "website")
    private String website;

    @Column(name = "name_company")
    private String nameCompany;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "usernameCustomer")
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserBuilding userBuilding;

    @JsonBackReference(value = "customer")
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;


    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", deleteFlag=" + deleteFlag +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", website='" + website + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", userBuilding=" + userBuilding +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public UserBuilding getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(UserBuilding userBuilding) {
        this.userBuilding = userBuilding;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
