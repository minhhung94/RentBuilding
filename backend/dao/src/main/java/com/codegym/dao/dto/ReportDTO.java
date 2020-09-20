package com.codegym.dao.dto;

import java.io.Serializable;

public class ReportDTO implements Serializable {
    private String codeGroundCal;
    private Double totalCal;

    public ReportDTO() {
    }

    public ReportDTO(String codeGroundCal, Double totalCal) {
        this.codeGroundCal = codeGroundCal;
        this.totalCal = totalCal;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "codeGroundCal='" + codeGroundCal + '\'' +
                ", totalCal=" + totalCal +
                '}';
    }

    public String getCodeGroundCal() {
        return codeGroundCal;
    }

    public void setCodeGroundCal(String codeGroundCal) {
        this.codeGroundCal = codeGroundCal;
    }

    public Double getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(Double totalCal) {
        this.totalCal = totalCal;
    }
}
