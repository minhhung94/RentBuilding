package com.codegym.webservice.controller;

import com.codegym.dao.dto.CustomerDTO;
import com.codegym.dao.dto.EmployeeDTO;
import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.Customer;
import com.codegym.dao.entity.Employee;
import com.codegym.web.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/employees")

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/salary")
    public List<Employee> getSalary() {
        return employeeService.getTatCa();
    }

    @GetMapping("")
    public List<Employee> getAllEmployee() {
        return employeeService.findAllByDeleteFlagIsNull();
    }

//        @GetMapping(value = "/paging", params = {"page", "size", "search"})
//    public Page<Employee> getListEmployee(@RequestParam("page") int page,
//                                          @RequestParam("size") int size,
//                                          @RequestParam("search") String name) {
//        return employeeService.getEmployees(name, PageRequest.of(page,size));
//
//    }
    @PostMapping("")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        employeeService.save(employeeDTO);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") int id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        if (employeeDTO != null) {
            return ResponseEntity.ok(employeeDTO);
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable("id") int id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        employeeService.deleteEmployee(employeeDTO.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;


    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") Integer id, @RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        employeeService.updateEmployee(employeeDTO);
        return ResponseEntity.accepted().body(employeeDTO);
    }

    @GetMapping(value = "/paging", params = {"page", "size", "name", "idCard", "address", "part"})
    public Page<Employee> getListEmployee(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam(value = "name", defaultValue = "") String name,
                                          @RequestParam(value = "idCard", defaultValue = "") String idCard,
                                          @RequestParam(value = "address", defaultValue = "") String address,
                                          @RequestParam(value = "part", defaultValue = "") String part) {
        return employeeService.searchAnything(name, idCard, address, part, PageRequest.of(page, size));

    }
    @GetMapping(value = "/paging1", params = {"page", "size", "name", "idCard", "address", "part"})
    public Page<Employee> getListEmployeeServe(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam(value = "name", defaultValue = "") String name,
                                          @RequestParam(value = "idCard", defaultValue = "") String idCard,
                                          @RequestParam(value = "address", defaultValue = "") String address,
                                          @RequestParam(value = "part", defaultValue = "") String part) {
        return employeeService.searchAnythingEmployeeServe(name, idCard, address, part, PageRequest.of(page, size));

    }

}
