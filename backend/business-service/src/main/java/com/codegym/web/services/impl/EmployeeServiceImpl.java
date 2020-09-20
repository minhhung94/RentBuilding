package com.codegym.web.services.impl;

import com.codegym.dao.dto.CustomerDTO;
import com.codegym.dao.dto.EmployeeDTO;
import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.Customer;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.repository.EmployeeRepository;
import com.codegym.dao.repository.UserBuildingRepository;
import com.codegym.web.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserBuildingRepository userBuildingRepository;

    @Override
    public List<Employee> findAllByDeleteFlagIsNull() {
        return employeeRepository.getAll();
    }

    @Override
    public List<Employee> getAllEmployeeServe() {
        return employeeRepository.getAllEmployeeServe();
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        if (employee != null) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setDeleteFlag(employee.getDeleteFlag());
            employeeDTO.setName(employee.getName());
            employeeDTO.setBirthday(employee.getBirthday());
            employeeDTO.setIdCard(employee.getIdCard());
            employeeDTO.setPhone(employee.getPhone());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setAddress(employee.getAddress());
            employeeDTO.setGender(employee.getGender());
            employeeDTO.setLevelSalary(employee.getLevelSalary());
            employeeDTO.setPart(employee.getPart());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setStartWord(employee.getStartWord());
            employeeDTO.setTypeEmployee(employee.getTypeEmployee());
            employeeDTO.setUserBuilding(employee.getUserBuilding().getUsername());
            employeeDTO.setContracts(employee.getContracts());
            return employeeDTO;
        }
        return null;
    }

    @Override
    public List<Employee> getTatCa() {
        return employeeRepository.getAllByDeleteFlagIsNull();
    }


    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        employee.setDeleteFlag(1);
        employeeRepository.save(employee);
    }


    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setDeleteFlag(employeeDTO.getDeleteFlag());
        employee.setName(employeeDTO.getName());
        employee.setBirthday(employeeDTO.getBirthday());
        employee.setIdCard(employeeDTO.getIdCard());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAddress(employeeDTO.getAddress());
        employee.setGender(employeeDTO.getGender());
        employee.setLevelSalary(employeeDTO.getLevelSalary());
        employee.setPart(employeeDTO.getPart());
        employee.setStartWord(employeeDTO.getStartWord());
        employee.setTypeEmployee(employeeDTO.getTypeEmployee());
        employee.setSalary(employeeDTO.getSalary());
        employee.setUserBuilding(userBuildingRepository.findAllByDeleteFlagIsNullAndUsernameIs(employeeDTO.getUserBuilding()));
        employee.setContracts(employeeDTO.getContracts());
        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findAllByDeleteFlagIsNullAndIdIs(employeeDTO.getId());
        employee.setId(employeeDTO.getId());
        employee.setDeleteFlag(employeeDTO.getDeleteFlag());
        employee.setName(employeeDTO.getName());
        employee.setBirthday(employeeDTO.getBirthday());
        employee.setIdCard(employeeDTO.getIdCard());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAddress(employeeDTO.getAddress());
        employee.setGender(employeeDTO.getGender());
        employee.setLevelSalary(employeeDTO.getLevelSalary());
        employee.setPart(employeeDTO.getPart());
        employee.setStartWord(employeeDTO.getStartWord());
        employee.setTypeEmployee(employeeDTO.getTypeEmployee());
        employee.setSalary(employeeDTO.getSalary());
        employee.setUserBuilding(userBuildingRepository.findAllByDeleteFlagIsNullAndUsernameIs(employeeDTO.getUserBuilding()));
        employee.setContracts(employeeDTO.getContracts());
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getEmployees(String nameEmployee, Pageable pageable) {
        return employeeRepository.findAllByDeleteFlagIsNullAndNameContainingIgnoreCase(nameEmployee, pageable);
    }

    @Override
    public Page<Employee> searchAnything(String name, String idCard, String address, String part, Pageable pageable) {
        return employeeRepository.searchAnything(name,idCard,address,part, pageable);
    }

    @Override
    public Page<Employee> searchAnythingEmployeeServe(String name, String idCard, String address, String part, Pageable pageable) {
        return employeeRepository.searchAnythingEmployeeServe(name,idCard,address,part, pageable);
    }


}
