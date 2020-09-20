package com.codegym.dao.repository;


import com.codegym.dao.entity.TypeGround;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeGroundRepository extends JpaRepository<TypeGround,Integer> {
    List<TypeGround> findAll();
}
