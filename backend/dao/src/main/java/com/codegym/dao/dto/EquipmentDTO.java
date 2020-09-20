package com.codegym.dao.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipmentDTO {
    private Integer id;
    @NotNull(message = "Không được để trống")
    @Size(min = 2,message = "Tên thiết bị phải ít nhất 2 ký tự")
    private String nameEquipment;

    @NotNull(message = "Không được để trống")
    @Min(value = 1,message = "Số lượng phải lớn hơn hoặc bằng 1")
    private Integer amount;
    
    private Integer amountOfBroken;

    private String note;

    @NotNull(message = "Không được để trống")
    private Integer typeEquipmentId;

    @NotNull(message = "Không được để trống")
    private Integer groundId;

    private Integer deleteFlag;

    public EquipmentDTO() {
    }

    @Override
    public String toString() {
        return "EquipmentDTO{" +
                "id=" + id +
                ", nameEquipment='" + nameEquipment + '\'' +
                ", amount=" + amount +
                ", amountOfBroken=" + amountOfBroken +
                ", note='" + note + '\'' +
                ", typeEquipmentId=" + typeEquipmentId +
                ", groundId=" + groundId +
                ", deleteFlag=" + deleteFlag +
                '}';
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

    public Integer getTypeEquipmentId() {
        return typeEquipmentId;
    }

    public void setTypeEquipmentId(Integer typeEquipmentId) {
        this.typeEquipmentId = typeEquipmentId;
    }

    public Integer getGroundId() {
        return groundId;
    }

    public void setGroundId(Integer groundId) {
        this.groundId = groundId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
