package com.codegym.web.services;

import com.codegym.dao.dto.CustomerDTO;
import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllByDeleteFlagIsNull();
    CustomerDTO getCustomerById(Integer id);


    void deleteCustomer(Integer id);
    void save(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    Page<Customer> getCustomers(String nameCustomer, Pageable pageable);
    // Hung them
    Page<Customer> findAllByDeleteFlagIsNullAndNameContainingAndIdCardContaining(String name, String idCard, Pageable pageable);

}
