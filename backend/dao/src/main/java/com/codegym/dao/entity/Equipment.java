package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "equipment")
@JsonIgnoreProperties
public class Equipment {
    @Id
    @Column(name = "id_equipment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_equipment")
    private String nameEquipment;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "amount_of_broken")
    private Integer amountOfBroken;

    @Column(name = "note")
    private String note;

//    @JsonManagedReference(value = "id_typeTypeEquipment")
    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypeEquipment typeEquipment;

//    @JsonManagedReference(value = "id_groundEquipment")
    @ManyToOne
    @JoinColumn(name = "id_ground")
    private Ground ground;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    public Equipment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmountOfBroken() {
        return amountOfBroken;
    }

    public void setAmountOfBroken(Integer amountOfBroken) {
        this.amountOfBroken = amountOfBroken;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TypeEquipment getTypeEquipment() {
        return typeEquipment;
    }

    public void setTypeEquipment(TypeEquipment typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", nameEquipment='" + nameEquipment + '\'' +
                ", amount=" + amount +
                ", amountOfBroken=" + amountOfBroken +
                ", note='" + note + '\'' +
                ", typeEquipment=" + typeEquipment +
                ", ground=" + ground +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
