package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties
@Table(name = "type_ground")
public class TypeGround {
    @Id
    @Column(name = "id_type_ground")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_type_ground")
    private String nameTypeGround;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @JsonBackReference(value = "typeGround")
    @OneToMany(mappedBy = "typeGround", cascade = CascadeType.ALL)
    private Set<Ground> grounds;

    @Override
    public String toString() {
        return "TypeGround{" +
                "id=" + id +
                ", nameTypeGround='" + nameTypeGround + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", grounds=" + grounds +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeGround() {
        return nameTypeGround;
    }

    public void setNameTypeGround(String nameTypeGround) {
        this.nameTypeGround = nameTypeGround;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Set<Ground> getGrounds() {
        return grounds;
    }

    public void setGrounds(Set<Ground> grounds) {
        this.grounds = grounds;
    }
}
