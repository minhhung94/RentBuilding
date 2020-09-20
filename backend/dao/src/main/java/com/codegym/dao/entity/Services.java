package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "service")
@JsonIgnoreProperties
public class Services {
    @Id
    @Column(name = "id_service")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_service")
    private String nameService;

    @Column(name = "index_before_month")
    private Integer indexBeforeMonth;

    @Column(name = "index_after_month")
    private Integer indexAfterMonth;

    @Column(name = "consume")
    private Integer consume;

    @Column(name = "periodic")
    private String periodic;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price")
    private Integer price;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "month_year")
    private Date monthYear;

    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;

    @Column(name = "status_pay")
    private Boolean statusPay;

    public Services() {
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", nameService='" + nameService + '\'' +
                ", indexBeforeMonth=" + indexBeforeMonth +
                ", indexAfterMonth=" + indexAfterMonth +
                ", consume=" + consume +
                ", periodic='" + periodic + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", monthYear=" + monthYear +
                ", contract=" + contract +
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Boolean getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(Boolean statusPay) {
        this.statusPay = statusPay;
    }
}
