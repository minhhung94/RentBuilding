package com.codegym.dao.dto;

import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.UserBuilding;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class CustomerDTO implements Serializable {
    private Integer id;
    private Integer deleteFlag;
    @NotNull(message = "Không được để trống")
    @Size(min = 1,message = "Phải lớn hơn hoặc bằng 1")
    private String name;

    @NotNull(message = "Không được để trống")
    private Date birthday;

    @NotNull(message = "Không được để trống")
    private String idCard;

    @NotNull(message = "Không được để trống")
    private String phone;

    @NotNull(message = "Không được để trống")
    private String email;

    @NotNull(message = "Không được để trống")
    private String address;

//    @NotNull(message = "Không được để trống")
    private String gender;

    @NotNull(message = "Không được để trống")
    private String website;

//    @NotNull(message = "Không được để trống")
    private String nameCompany;
    private UserBuilding userBuilding;
    private Set<Contract> contracts;

    public CustomerDTO() {
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
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
                ", contracts=" + contracts +
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
