package com.codegym.dao.repository;


import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByDeleteFlagIsNull();
//    @Query(value = "SELECT * FROM customer WHERE id>0", nativeQuery = true)
//    List<Customer> findAllCustomer();
    Customer findAllByDeleteFlagIsNullAndIdIs(Integer id);
    Page<Customer> findAllByDeleteFlagIsNullAndNameContainingIgnoreCase(String fullName, Pageable pageable);

    // Hung them
    @Query(value = "SELECT c FROM Customer c where c.name like %?1% and c.idCard like %?2% and c.deleteFlag is null order by c.name" )
    Page<Customer> searchCustomer(String name, String idCard, Pageable pageable);

}

