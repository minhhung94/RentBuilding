package com.codegym.dao.dto;

import com.codegym.dao.entity.Floor;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

public class BuildingDTO implements Serializable {

    private Integer id;

    private String abbreviationName;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Tên đầy đủ tối thiểu 2 ký tự")
    @Size(max=50,message = "Tên đầy đủ tối đa 50 ký tự")
    private String fullName;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "(MST-)[0-9]{3}", message ="Mã số thuế có định dạng là MST-xxx (x là số 0-9)" )
    private String taxCode;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "([0-9]{9}|[0-9]{12})",message = "Số điện thoại gồm 9 hoặc 12 số")
    private String phone;

    @NotEmpty(message = "Không được để trống")
    @Email(message = "Nhập đúng định dạng email")
    @Size(max = 25,message = "Email tối đa 25 ký tự")
    private String email;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Fax tối thiểu 2 ký tự")
    @Size(max=25,message = "Fax tối đa 25 ký tự")
    private String fax;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Địa chỉ tối thiểu 2 ký tự")
    @Size(max=50,message = "Địa chỉ tối đa 50 ký tự")
    private String address;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Tên ban quản lý tối thiểu 2 ký tự")
    @Size(max=50,message = "Tên ban quản lý tối đa 50 ký tự")
    private String management;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Tên người quản lý tối thiểu 2 ký tự")
    @Size(max=50,message = "Tên người quản lý tối đa 50 ký tự")
    private String manager;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Số tài khoản tối thiểu 2 ký tự")
    @Size(max=25,message = "Số tài khoản tối đa 25 ký tự")
    private String accountNumber;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Tên người nhận tối thiểu 2 ký tự")
    @Size(max=50,message = "Tên người nhận tối đa 50 ký tự")
    private String recipientName;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 2,message = "Tên ngân hàng tối thiểu 2 ký tự")
    @Size(max=50,message = "Tên ngân hàng tối đa 50 ký tự")
    private String bank;

    private Integer deleteFlag;

    private Set<Floor> floors;

    private Integer logo;

    @Override
    public String toString() {
        return "BuildingDTO{" +
                "id=" + id +
                ", abbreviationName='" + abbreviationName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", address='" + address + '\'' +
                ", management='" + management + '\'' +
                ", manager='" + manager + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", bank='" + bank + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", floors=" + floors +
                ", logo=" + logo +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbreviationName() {
        return abbreviationName;
    }

    public void setAbbreviationName(String abbreviationName) {
        this.abbreviationName = abbreviationName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }
}
