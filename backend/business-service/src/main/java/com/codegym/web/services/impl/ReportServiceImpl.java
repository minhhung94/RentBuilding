package com.codegym.web.services.impl;

import com.codegym.dao.dto.ReportInt;
import com.codegym.dao.repository.ContractRepository;
import com.codegym.web.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ContractRepository contractRepository;


    @Override
    public List<ReportInt> searchAllReport() {
        return contractRepository.searchAllReport();
    }

    @Override
    public List<ReportInt> searchAllReportHigh() {
        return contractRepository.searchAllReportHigh();
    }

    @Override
    public List<ReportInt> searchAllReportLow() {
        return contractRepository.searchAllReportLow();
    }

    @Override
    public List<ReportInt> searchReportWithAny(Date startRentDay, Date endRentDay, Double minTotal, Double maxTotal, String codeGround) {
        return contractRepository.searchReportWithAny(startRentDay, endRentDay, minTotal, maxTotal, codeGround);
    }
}
