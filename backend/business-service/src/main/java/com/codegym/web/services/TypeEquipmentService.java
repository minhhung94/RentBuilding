package com.codegym.web.services;

import com.codegym.dao.entity.TypeEquipment;

import java.util.List;

public interface TypeEquipmentService {

    List<TypeEquipment> findAllByDeleteFlagIsNull();
    TypeEquipment findById(Integer id);
}
