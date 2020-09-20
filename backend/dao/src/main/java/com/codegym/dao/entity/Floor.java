package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;


import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@JsonIgnoreProperties
@Table(name = "floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_floor")
    private Integer id;

    @Column(name="name_floor")
    private String nameFloor;

    @Column(name="code_floor")
    private String codeFloor;

    @Column(name="area")
    private Integer area;

    @Column(name="capacity")
    private String capacity;

    @Column(name="status_floor")
    private String statusFloor;

    @Column(name="delete_flag")
    private Integer deleteFlag;

    @ManyToOne
//    @JsonManagedReference(value = "id_type_floor" )
    @JoinColumn(name = "id_type_floor")
    private TypeFloor typeFloor;

    @ManyToOne
//    @JsonManagedReference(value = "id_building" )
    @JoinColumn(name="id_building")
    private Building building;

    @JsonBackReference(value = "floor")
    @OneToMany(mappedBy ="floor",cascade = ALL)
    private Set<Ground> grounds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFloor() {
        return nameFloor;
    }

    public void setNameFloor(String nameFloor) {
        this.nameFloor = nameFloor;
    }

    public String getCodeFloor() {
        return codeFloor;
    }

    public void setCodeFloor(String codeFloor) {
        this.codeFloor = codeFloor;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatusFloor() {
        return statusFloor;
    }

    public void setStatusFloor(String statusFloor) {
        this.statusFloor = statusFloor;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public TypeFloor getTypeFloor() {
        return typeFloor;
    }

    public void setTypeFloor(TypeFloor typeFloor) {
        this.typeFloor = typeFloor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Ground> getGrounds() {
        return grounds;
    }

    public void setGrounds(Set<Ground> grounds) {
        this.grounds = grounds;
    }
}
