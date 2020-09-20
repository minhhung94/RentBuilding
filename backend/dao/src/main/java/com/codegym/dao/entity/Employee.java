package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id;

    @Column(name="delete_flag")
    private Integer deleteFlag;

    @Column(name = "name_employee")
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

    @Column(name = "level_salary")
    private  String levelSalary;

    @Column(name = "part")
    private  String part;

    @Column(name = "start_word")
    private  Date startWord;

    @Column(name = "type_employee")
    private  String typeEmployee;

    @Column(name = "salary")
    private Long salary;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference  (value = "usernameEmployee")
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserBuilding userBuilding;

    @JsonBackReference(value = "employee")
    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;


    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
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
                ", salary=" + salary +
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

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
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
