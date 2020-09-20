package com.codegym.dao.repository;

import com.codegym.dao.entity.TypeEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeEquipmentRepository extends JpaRepository<TypeEquipment, Integer> {
    List<TypeEquipment> findAllByDeleteFlagIsNull();
    TypeEquipment findAllByDeleteFlagIsNullAndIdIs(Integer id);
}
