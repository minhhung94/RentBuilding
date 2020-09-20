package com.codegym.web.services;

import com.codegym.dao.entity.Image;


import java.util.List;

public interface ImageService {
    List<Image> findAll();
    List<Image> findByTypeContaining(String type);
    Image findById(Integer id);
}
