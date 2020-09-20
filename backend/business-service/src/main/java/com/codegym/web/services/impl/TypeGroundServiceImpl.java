package com.codegym.web.services.impl;

import com.codegym.dao.entity.TypeGround;
import com.codegym.dao.repository.TypeGroundRepository;
import com.codegym.web.services.TypeGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeGroundServiceImpl implements TypeGroundService {
    @Autowired
    TypeGroundRepository typeGroundRepository;
    @Override
    public List<TypeGround> findAll() {
        return typeGroundRepository.findAll();
    }

    @Override
    public TypeGround findById(Integer id) {
        return typeGroundRepository.findById(id).orElse(null);
    }
}
