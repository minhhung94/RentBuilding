package com.codegym.webservice.controller;

import com.codegym.dao.dto.ContractDTO;
import com.codegym.dao.dto.CustomerDTO;
import com.codegym.dao.entity.*;

import com.codegym.web.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @GetMapping("")
    public List<Customer> getAllCustomer() {
        List<Customer> customers;
        customers = customerService.findAllByDeleteFlagIsNull();
        return customers;
    }
    @GetMapping(value = "/paging", params = {"page", "size", "search"})
    public Page<Customer> getListContract(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam("search") String name) {
        return customerService.getCustomers(name, PageRequest.of(page,size));

    }


//    @PostMapping("")
//    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
//        customerService.save(customerDTO);
//        return ResponseEntity.ok(customerDTO);
//    }
    @PostMapping("")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        customerService.save(customerDTO);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") int id){
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        if (customerDTO != null) {
            return ResponseEntity.ok(customerDTO);
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable("id") int id) {
       CustomerDTO customer=customerService.getCustomerById(id);
        customerService.deleteCustomer(customer.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;


    }
//    @PutMapping("/{id}")
//    public ResponseEntity<CustomerDTO> updateContract(@PathVariable(value = "id") Integer id , @RequestBody CustomerDTO customerDTO){
//        customerService.updateCustomer(customerDTO);
//        return ResponseEntity.ok(customerDTO);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable(value = "id") Integer id, @RequestBody @Valid CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        customerService.updateCustomer(customerDTO);
        return ResponseEntity.accepted().body(customerDTO);
    }

    //Hung them
    @GetMapping(value = "/page", params = {"page", "size", "name", "idCard"})
    public Page<Customer> getCustomers(@RequestParam("page") int page,
                                       @RequestParam("size") int size,
                                       @RequestParam("name") String name,
                                       @RequestParam("idCard") String idCard) {
        return customerService.findAllByDeleteFlagIsNullAndNameContainingAndIdCardContaining(name, idCard, PageRequest.of(page,size));
    }
}

