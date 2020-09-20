package com.codegym.web.services;

import com.codegym.dao.entity.TypeFloor;


import java.util.List;

public interface TypeFloorService {
    List<TypeFloor> findAll();
    TypeFloor findById(Integer id);


}
