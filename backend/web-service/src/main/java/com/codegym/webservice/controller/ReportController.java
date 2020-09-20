package com.codegym.webservice.controller;


import com.codegym.dao.dto.ReportInt;
import com.codegym.web.services.ContractService;
import com.codegym.web.services.GroundService;
import com.codegym.web.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ContractService contractService;

    @Autowired
    GroundService groundService;

    @Autowired
    ReportService reportService;

    @GetMapping("/all")
    public List<ReportInt> getAllReport() {
        return reportService.searchAllReport();
    }

    @GetMapping("/high")
    public List<ReportInt> getReportHigh() {
        return reportService.searchAllReportHigh();
    }

    @GetMapping("/low")
    public List<ReportInt> getReportLow() {
        return reportService.searchAllReportLow();
    }


    @GetMapping(value = "/search", params = {"startRentDay", "endRentDay", "minTotal", "maxTotal", "codeGround"})
    public List<ReportInt> getListReport(@RequestParam(value = "startRentDay", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startRentDay,
                                         @RequestParam(value = "endRentDay", defaultValue = "2030-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endRentDay,
                                         @RequestParam(value = "minTotal", defaultValue = "0") Double minTotal,
                                         @RequestParam(value = "maxTotal", defaultValue = "99999999999") Double maxTotal,
                                         @RequestParam(value = "codeGround", defaultValue = "") String codeGround) {
        List<ReportInt> reportInts = reportService.searchReportWithAny(startRentDay, endRentDay, minTotal, maxTotal, codeGround);
        return reportService.searchReportWithAny(startRentDay, endRentDay, minTotal, maxTotal, codeGround);
    }
}
