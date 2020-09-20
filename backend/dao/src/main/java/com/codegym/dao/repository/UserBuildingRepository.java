package com.codegym.dao.repository;

import com.codegym.dao.entity.Customer;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.UserBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBuildingRepository extends JpaRepository<UserBuilding,String> {
    List<UserBuilding> findAllByDeleteFlagIsNull();
    UserBuilding findByUsername(String username);
    UserBuilding findAllByDeleteFlagIsNullAndUsernameIs(String username);
}
