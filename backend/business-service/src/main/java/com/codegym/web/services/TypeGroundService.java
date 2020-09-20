package com.codegym.web.services;


import com.codegym.dao.entity.TypeGround;

import java.util.List;

public interface TypeGroundService {
    List<TypeGround> findAll();
    TypeGround findById(Integer id);
}
