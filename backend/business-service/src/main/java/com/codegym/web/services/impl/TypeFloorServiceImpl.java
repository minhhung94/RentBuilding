package com.codegym.web.services.impl;

import com.codegym.dao.entity.TypeFloor;
import com.codegym.dao.repository.TypeFloorRepository;
import com.codegym.web.services.TypeFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeFloorServiceImpl implements TypeFloorService {
    @Autowired
    private TypeFloorRepository typeFloorRepository;
    @Override
    public List<TypeFloor> findAll() {
        return typeFloorRepository.findAll();
    }

    @Override
    public TypeFloor findById(Integer id) {
        return typeFloorRepository.findById(id).orElse(null);
    }

}
