package com.codegym.web.services;


import com.codegym.dao.dto.CustomerDTO;
import com.codegym.dao.dto.EmployeeDTO;
import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.Customer;
import com.codegym.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAllByDeleteFlagIsNull();
    List<Employee> getAllEmployeeServe();
    EmployeeDTO getEmployeeById(Integer id);
    List<Employee> getTatCa();


    void deleteEmployee(Integer id);
    void save(EmployeeDTO customerDTO);
    void updateEmployee(EmployeeDTO employeeDTO);
    Page<Employee> getEmployees(String nameEmployee, Pageable pageable);
    Page<Employee> searchAnything(String name, String idCard, String address, String part, Pageable pageable);
    Page<Employee> searchAnythingEmployeeServe(String name, String idCard, String address, String part, Pageable pageable);
}
