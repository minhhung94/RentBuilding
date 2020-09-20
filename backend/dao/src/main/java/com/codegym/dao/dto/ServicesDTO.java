package com.codegym.dao.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

public class ServicesDTO implements Serializable {

    private Integer id;

    @NotNull(message = "Không được để trống")
    @Size(min = 2,message = "Tên dịch vụ phải ít nhất 2 ký tự")
    private String nameService;

    @NotNull(message = "Không được để trống")
    private Integer indexBeforeMonth;

    @NotNull(message = "Không được để trống")
    private Integer indexAfterMonth;

    @NotNull(message = "Không được để trống")
    private Integer consume;

    @NotNull(message = "Không được để trống")
    private String periodic;

    @NotNull(message = "Không được để trống")
    private String  unit;

    @NotNull(message = "Không được để trống")
    private Integer price;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "Không được để trống")
    private Date monthYear;

    @NotNull(message = "Không được để trống")
    private Integer contractId;

//    @NotNull(message = "Không được để trống")
    private Boolean statusPay;

    public ServicesDTO() {
    }

    @Override
    public String toString() {
        return "ServicesDTO{" +
                "id=" + id +
                ", nameService='" + nameService + '\'' +
                ", indexBeforeMonth=" + indexBeforeMonth +
                ", indexAfterMonth=" + indexAfterMonth +
                ", consume=" + consume +
                ", periodic='" + periodic + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", monthYear=" + monthYear +
                ", contractId=" + contractId +
                ", statusPay=" + statusPay +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Integer getIndexBeforeMonth() {
        return indexBeforeMonth;
    }

    public void setIndexBeforeMonth(Integer indexBeforeMonth) {
        this.indexBeforeMonth = indexBeforeMonth;
    }

    public Integer getIndexAfterMonth() {
        return indexAfterMonth;
    }

    public void setIndexAfterMonth(Integer indexAfterMonth) {
        this.indexAfterMonth = indexAfterMonth;
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public String getPeriodic() {
        return periodic;
    }

    public void setPeriodic(String periodic) {
        this.periodic = periodic;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(Date monthYear) {
        this.monthYear = monthYear;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Boolean getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(Boolean statusPay) {
        this.statusPay = statusPay;
    }
}
