package com.codegym.dao.repository;

import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.Customer;
import com.codegym.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT * from employee e where e.type_employee = 0 and delete_flag is null",nativeQuery = true)
    List<Employee> getAll();
    @Query(value = "SELECT * from employee e where e.type_employee = 1 and delete_flag is null",nativeQuery = true)
    List<Employee> getAllEmployeeServe();
    Employee findAllByDeleteFlagIsNullAndIdIs(Integer id);
    Page<Employee> findAllByDeleteFlagIsNullAndNameContainingIgnoreCase(String fullName, Pageable pageable);
    @Query(value = "select * from employee e where e.name_employee like %?1% and e.type_employee = 0 and e.id_card like %?2% " +
            "and e.address like %?3% " +
            "and e.part like %?4% " +
            "and e.delete_flag is null " +
            "order by e.id_employee",nativeQuery = true)
    Page<Employee> searchAnything(String name, String idCard, String address, String part, Pageable pageable);

    @Query(value = "select * from employee e where e.name_employee like %?1% and e.type_employee = 1 and e.id_card like %?2% " +
            "and e.address like %?3% " +
            "and e.part like %?4% " +
            "and e.delete_flag is null " +
            "order by e.id_employee",nativeQuery = true)
    Page<Employee> searchAnythingEmployeeServe(String name, String idCard, String address, String part, Pageable pageable);

    List<Employee> getAllByDeleteFlagIsNull();


}
