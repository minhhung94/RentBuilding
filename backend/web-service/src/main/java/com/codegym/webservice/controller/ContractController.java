package com.codegym.webservice.controller;

import com.codegym.dao.dto.ContractDTO;
import com.codegym.dao.entity.Contract;
import com.codegym.web.services.ContractService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("")
    public List<Contract> getAllContract() {
        List<Contract> contracts;
        contracts = contractService.findAllByDeleteFlagIsNull();
        return contracts;
    }

    @GetMapping(value = "/paging", params = {"page", "size", "fullName", "codeGround", "startRentDay", "endRentDay"})
    public Page<Contract> getListContract(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam(value = "fullName", defaultValue = "") String fullName,
                                          @RequestParam(value = "codeGround", defaultValue = "") String codeGround,
                                          @RequestParam(value = "startRentDay", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startRentDay,
                                          @RequestParam(value = "endRentDay", defaultValue = "2030-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endRentDay) {
        Page<Contract> contracts = contractService.searchAnything(fullName, codeGround, startRentDay, endRentDay, PageRequest.of(page, size));
        return contracts;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ContractDTO> getContract(@PathVariable("id") int id) {
        ContractDTO contractDTO = contractService.findAllByDeleteFlagIsNullAndIdIs(id);
        if (contractDTO != null) {
            return ResponseEntity.ok(contractDTO);
        }
        return ResponseEntity.ok(new ContractDTO());
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteContract(@PathVariable(value = "id") Integer contractID) {
        ContractDTO contract = contractService.findAllByDeleteFlagIsNullAndIdIs(contractID);
        contractService.delete(contract.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<?> createContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        contractService.save(contractDTO);
        return ResponseEntity.ok(contractDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateContract(@PathVariable(value = "id") Integer id, @RequestBody @Valid ContractDTO contractDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        contractService.updateContract(contractDTO);
        return ResponseEntity.accepted().body(contractDTO);
    }

    @GetMapping("/export/{id}")
    public void exportToPDF(HttpServletResponse response, @PathVariable("id") Integer id) throws IOException, DocumentException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = contract_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        Contract contract = contractService.findById(id);
        ContractPDFExporter exporter = new ContractPDFExporter(contract);
        exporter.export(response);

    }
}
