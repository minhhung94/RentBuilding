package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties
@Table(name = "ground")
public class Ground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ground")
    private Integer id;


    @Column(name="codeGround")
    private String codeGround;

    @Column(name="area")
    private Integer area;

    @Column(name="status_ground")
    private String statusGround;

    @Column(name="price")
    private Integer price;

    @Column(name="price_manager")
    private Integer priceManager;

    @Column(name="delete_flag")
    private Integer deleteFlag;

    @Column(name="note")
    private String note;

//    @JsonManagedReference(value = "id_floorGround")
    @ManyToOne
    @JoinColumn(name = "id_floor")
    private Floor floor;

    @JsonBackReference(value = "groundEquipments")
    @OneToMany(mappedBy ="ground",cascade = CascadeType.ALL)
    private Set<Equipment> equipments;

    @JsonBackReference(value = "groundContracts")
    @OneToMany(mappedBy = "ground",cascade = CascadeType.ALL)
    private Set<Contract> contracts;

//    @JsonManagedReference(value = "id_type_ground")
    @ManyToOne
    @JoinColumn(name = "id_type_ground")
    private TypeGround typeGround;

    @Column(name="id_building")
    private Integer buildingId;

    @Override
    public String toString() {
        return "Ground{" +
                "id=" + id +
                ", codeGround='" + codeGround + '\'' +
                ", area=" + area +
                ", statusGround='" + statusGround + '\'' +
                ", price=" + price +
                ", priceManager=" + priceManager +
                ", deleteFlag=" + deleteFlag +
                ", note='" + note + '\'' +
                ", floor=" + floor +
                ", equipments=" + equipments +
                ", contracts=" + contracts +
                ", typeGround=" + typeGround +
                ", buildingId=" + buildingId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeGround() {
        return codeGround;
    }

    public void setCodeGround(String codeGround) {
        this.codeGround = codeGround;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getStatusGround() {
        return statusGround;
    }

    public void setStatusGround(String statusGround) {
        this.statusGround = statusGround;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPriceManager() {
        return priceManager;
    }

    public void setPriceManager(Integer priceManager) {
        this.priceManager = priceManager;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public TypeGround getTypeGround() {
        return typeGround;
    }

    public void setTypeGround(TypeGround typeGround) {
        this.typeGround = typeGround;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
}
