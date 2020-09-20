package com.codegym.dao.repository;

import com.codegym.dao.entity.TypeFloor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeFloorRepository extends JpaRepository<TypeFloor,Integer> {
    List<TypeFloor> findAll();

}
