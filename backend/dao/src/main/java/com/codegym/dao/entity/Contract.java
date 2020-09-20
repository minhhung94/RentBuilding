package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contract")
    private Integer id;

//    @JsonManagedReference(value = "id_employee")
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

//    @JsonManagedReference(value = "id_customer")
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

//    @JsonManagedReference(value = "id_ground")
    @ManyToOne
    @JoinColumn(name = "id_ground")
    private Ground ground;

    @Column(name = "url_image")
    private String urlImage;


    @Column(name = "term")
    private Double term;

    @Column(name = "status_contract")
    private Boolean statusContract;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "start_rent_day")
    private Date startRentDay;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "end_rent_day")
    private Date endRentDay;

    @Column(name = "price")
    private Double price;

    @Column(name = "total")
    private Double total;

    @Column(name = "deposits")
    private Double deposits;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "content")
    private String content;

    @Column(name = "unified")
    private Boolean unified;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    // Hùng đã thêm
    @JsonBackReference(value = "contract")
    @OneToMany(mappedBy  = "contract", cascade = CascadeType.ALL)
    private Set<Services> services;

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", employee=" + employee +
                ", customer=" + customer +
                ", ground=" + ground +
                ", urlImage='" + urlImage + '\'' +
                ", term=" + term +
                ", statusContract=" + statusContract +
                ", startRentDay=" + startRentDay +
                ", endRentDay=" + endRentDay +
                ", price=" + price +
                ", total=" + total +
                ", deposits=" + deposits +
                ", taxCode='" + taxCode + '\'' +
                ", content='" + content + '\'' +
                ", unified=" + unified +
                ", deleteFlag=" + deleteFlag +
                ", services=" + services +
                '}';
    }

    public Set<Services> getServices() {
        return services;
    }

    public void setServices(Set<Services> services) {
        this.services = services;
    }

    // Hết

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getTerm() {
        return term;
    }

    public void setTerm(Double term) {
        this.term = term;
    }

    public Boolean getStatusContract() {
        return statusContract;
    }

    public void setStatusContract(Boolean statusContract) {
        this.statusContract = statusContract;
    }

    public Date getStartRentDay() {
        return startRentDay;
    }

    public void setStartRentDay(Date startRentDay) {
        this.startRentDay = startRentDay;
    }

    public Date getEndRentDay() {
        return endRentDay;
    }

    public void setEndRentDay(Date endRentDay) {
        this.endRentDay = endRentDay;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDeposits() {
        return deposits;
    }

    public void setDeposits(Double deposits) {
        this.deposits = deposits;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getUnified() {
        return unified;
    }

    public void setUnified(Boolean unified) {
        this.unified = unified;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
