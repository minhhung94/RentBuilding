package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties
@Table(name = "type_floor")

public class TypeFloor {

    @Id
    @Column(name = "id_type_floor")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_type_floor")
    private String nameTypeFloor;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @JsonBackReference(value = "typeFloor")
    @OneToMany(mappedBy = "typeFloor", cascade = CascadeType.ALL)
    private Set<Floor> floors;

    @Override
    public String toString() {
        return "TypeFloor{" +
                "id=" + id +
                ", nameTypeFloor='" + nameTypeFloor + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", floors=" + floors +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeFloor() {
        return nameTypeFloor;
    }

    public void setNameTypeFloor(String nameTypeFloor) {
        this.nameTypeFloor = nameTypeFloor;
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
}
