package com.codegym.dao.dto;

import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.UserBuilding;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class EmployeeDTO implements Serializable {
    private Integer id;
    private Integer deleteFlag;
    @NotNull(message = "Không được để trống")
    private String name;
    @NotNull(message = "Không được để trống")
    private Date birthday;
    @NotNull(message = "Không được để trống")
    private String idCard;
    @NotNull(message = "Không được để trống")
    private String phone;
    @NotNull(message = "Không được để trống")
    private String email;
    private String address;
    private String gender;
    private String levelSalary;
    private String part;
    private Date startWord;
    private String typeEmployee;
    private String userBuilding;
    private Long salary;
    private Set<Contract> contracts;

    public EmployeeDTO() {
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", deleteFlag=" + deleteFlag +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", levelSalary='" + levelSalary + '\'' +
                ", part='" + part + '\'' +
                ", startWord=" + startWord +
                ", typeEmployee='" + typeEmployee + '\'' +
                ", userBuilding='" + userBuilding + '\'' +
                ", salary=" + salary +
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

    public String getLevelSalary() {
        return levelSalary;
    }

    public void setLevelSalary(String levelSalary) {
        this.levelSalary = levelSalary;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public Date getStartWord() {
        return startWord;
    }

    public void setStartWord(Date startWord) {
        this.startWord = startWord;
    }

    public String getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(String typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public String getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(String userBuilding) {
        this.userBuilding = userBuilding;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
