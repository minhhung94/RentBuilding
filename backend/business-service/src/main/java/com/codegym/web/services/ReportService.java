package com.codegym.web.services;

import com.codegym.dao.dto.ReportInt;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<ReportInt> searchAllReport();
    List<ReportInt> searchAllReportHigh();
    List<ReportInt> searchAllReportLow();
    List<ReportInt> searchReportWithAny(Date startRentDay, Date endRentDay, Double minTotal, Double maxTotal, String codeGround );
}
