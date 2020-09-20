package com.codegym.web.services.impl;

import com.codegym.dao.entity.TypeEquipment;
import com.codegym.dao.repository.TypeEquipmentRepository;
import com.codegym.web.services.TypeEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEquipmentServiceImpl implements TypeEquipmentService {

    @Autowired
    TypeEquipmentRepository typeEquipmentRepository;

    @Override
    public List<TypeEquipment> findAllByDeleteFlagIsNull() {
        return typeEquipmentRepository.findAllByDeleteFlagIsNull();
    }

    @Override
    public TypeEquipment findById(Integer id) {
        return typeEquipmentRepository.findById(id).orElse(null);
    }
}
