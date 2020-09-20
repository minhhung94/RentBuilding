package com.codegym.web.services.impl;

import com.codegym.dao.entity.Image;
import com.codegym.dao.repository.ImageRepository;
import com.codegym.web.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> findByTypeContaining(String type) {
        return imageRepository.findByTypeContaining(type);
    }

    @Override
    public Image findById(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }
}
