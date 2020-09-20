package com.codegym.web.services.impl;

import com.codegym.dao.dto.CustomerDTO;
import com.codegym.dao.entity.Customer;
import com.codegym.dao.repository.CustomerRepository;
import com.codegym.web.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllByDeleteFlagIsNull() {
        return customerRepository.findAllByDeleteFlagIsNull();
    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        Customer customer = customerRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        if (customer != null) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setDeleteFlag(customer.getDeleteFlag());
            customerDTO.setName(customer.getName());
            customerDTO.setBirthday(customer.getBirthday());
            customerDTO.setIdCard(customer.getIdCard());
            customerDTO.setPhone(customer.getPhone());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setGender(customer.getGender());
            customerDTO.setWebsite(customer.getWebsite());
            customerDTO.setNameCompany(customer.getNameCompany());
            customerDTO.setUserBuilding(customer.getUserBuilding());
            customerDTO.setContracts(customer.getContracts());
            return customerDTO;
        }
        return null;
    }
//
//    @Override
//    public void deleteAllCustomer(Integer id) {
//       List<Customer> customers = customerRepository.findAllCustomer();
//
//
//        for (Customer customer:customers) {
//            customer.setDeleteFlag(1);
//            customerRepository.save(customer);
//        }
//    }

    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findAllByDeleteFlagIsNullAndIdIs(id);
            customer.setDeleteFlag(1);
            customerRepository.save(customer);
    }



    @Override
    public void save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setDeleteFlag(customerDTO.getDeleteFlag());
        customer.setName(customerDTO.getName());
        customer.setBirthday(customerDTO.getBirthday());
        customer.setIdCard(customerDTO.getIdCard());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setGender(customerDTO.getGender());
        customer.setWebsite(customerDTO.getWebsite());
        customer.setNameCompany(customerDTO.getNameCompany());
        customer.setUserBuilding(customerDTO.getUserBuilding());
        customer.setContracts(customerDTO.getContracts());

        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findAllByDeleteFlagIsNullAndIdIs(customerDTO.getId());
        customer.setId(customerDTO.getId());
        customer.setDeleteFlag(customerDTO.getDeleteFlag());
        customer.setName(customerDTO.getName());
        customer.setBirthday(customerDTO.getBirthday());
        customer.setIdCard(customerDTO.getIdCard());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setGender(customerDTO.getGender());
        customer.setWebsite(customerDTO.getWebsite());
        customer.setNameCompany(customerDTO.getNameCompany());
        customer.setUserBuilding(customerDTO.getUserBuilding());
        customer.setContracts(customerDTO.getContracts());

        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getCustomers(String nameCustomer, Pageable pageable) {
        return customerRepository.findAllByDeleteFlagIsNullAndNameContainingIgnoreCase(nameCustomer,pageable);
    }

    // Hung them
    @Override
    public Page<Customer> findAllByDeleteFlagIsNullAndNameContainingAndIdCardContaining(String name, String idCard, Pageable pageable) {
        return customerRepository.searchCustomer(name, idCard, pageable);
    }
}
