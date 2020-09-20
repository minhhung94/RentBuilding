package com.codegym.webservice.controller;

import com.codegym.dao.dto.ServicesDTO;
import com.codegym.dao.entity.Services;
import com.codegym.web.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping("")
    public List<Services> getAllService() {
        return servicesService.findAll();
    }

    @GetMapping("/distinct")
    public List<String> getAllServiceDistinct() {
        return servicesService.searchAllDistinct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesDTO> getService(@PathVariable("id") int id) {
        ServicesDTO servicesDTO = servicesService.findAllByIdIs(id);
        if (servicesDTO != null) {
            return ResponseEntity.ok(servicesDTO);
        }
        return null;
    }

    @GetMapping(value = "/search", params = {"page", "size", "monthYear", "monthYear2", "contractId"})
    public Page<Services> searchAndPage(@RequestParam("page") int page,
                                        @RequestParam("size") int size,
                                        @RequestParam(value = "monthYear")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date monthYear,
                                        @RequestParam(value = "monthYear2")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date monthYear2,
                                        @RequestParam(value = "contractId") Integer contractId){
        return servicesService.findAllByMonthYearBetweenAndContract_Id(monthYear, monthYear2, contractId, PageRequest.of(page, size));
    }

    @GetMapping(value = "/searchDistinct", params = {"page", "size", "idContract", "startDate", "endDate"})
    public Page<Services> searchAllDistinct(@RequestParam("page") int page,
                                        @RequestParam("size") int size,
                                        @RequestParam(value = "idContract") Integer idContract,
                                        @RequestParam(value = "startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                        @RequestParam(value = "endDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return servicesService.searchServiceIdContract(idContract, startDate, endDate, PageRequest.of(page, size));
    }

    @GetMapping(value = "/invoice", params = {"monthYear", "idContract"})
    public List<Services> searchInvoice(@RequestParam(value = "monthYear")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date monthYear,
                                        @RequestParam(value = "idContract") Integer idContract){
        return servicesService.findAllByMonthYearAndContract_Id(monthYear, idContract);
    }

    @PostMapping("")
    public ResponseEntity<?> createService(@Valid @RequestBody ServicesDTO servicesDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        servicesService.save(servicesDTO);
        return ResponseEntity.ok(servicesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateService(@PathVariable(value = "id") Integer id, @RequestBody @Valid ServicesDTO servicesDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        servicesService.updateService(servicesDTO);
        return ResponseEntity.accepted().body(servicesDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteService(@PathVariable("id") int id) {
        ServicesDTO service = servicesService.findAllByIdIs(id);
        servicesService.remove(service.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    @GetMapping(value = "/paging", params = {"page", "size", "nameService", "periodic", "consume", "monthYear"})
    public Page<Services> getListServices(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam(value = "nameService", defaultValue = "") String nameService,
                                          @RequestParam(value = "periodic", defaultValue = "") String periodic,
                                          @RequestParam(value = "consume") Integer consume,
                                          @RequestParam(value = "monthYear", defaultValue = "2001-01-01")
                                          @DateTimeFormat(pattern = "yyyy-MM-dd") Date monthYear) {
        Page<Services> services;
        services = servicesService.searchAll(nameService, periodic, consume, monthYear, PageRequest.of(page, size));
        return services;
    }

    @GetMapping(value = "/infoService", params = {"page", "size", "idContract", "nameService", "startDate", "endDate"})
    public Page<Services> searchInformationService(@RequestParam("page") int page,
                                                   @RequestParam("size") int size,
                                                   @RequestParam(value = "idContract") Integer idContract,
                                                   @RequestParam(value = "nameService", defaultValue = "") String nameService,
                                                   @RequestParam(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                   @RequestParam(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return servicesService.searchInformationService(idContract,nameService,startDate, endDate, PageRequest.of(page, size));
    }

}
