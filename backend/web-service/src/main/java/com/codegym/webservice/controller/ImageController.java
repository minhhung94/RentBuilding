package com.codegym.webservice.controller;

import com.codegym.dao.entity.Image;
import com.codegym.web.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("")
    public List<Image> getAllImage() {
        List<Image> images;
        images = imageService.findAll();
        return images;
    }
    @GetMapping("/{type}")
    public List<Image> getAllByType(@PathVariable("type") String type) {
        List<Image> images;
        images = imageService.findByTypeContaining(type);
        return images;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Image> getImage(@PathVariable("id") int id) {
        Image image = imageService.findById(id);
        if (image != null) {
            return ResponseEntity.ok(image);
        }
        return null;
    }
}
