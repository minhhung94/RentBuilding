package com.codegym.webservice.controller;

import com.codegym.dao.entity.TypeGround;
import com.codegym.web.services.TypeGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/typeGrounds")
public class TypeGroundController {

    @Autowired
    private TypeGroundService typeGroundService;

    @GetMapping("")
    public List<TypeGround> getAllTypeGround() {
        List<TypeGround> typeGrounds;
        typeGrounds = typeGroundService.findAll();
        return typeGrounds;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TypeGround> getGround(@PathVariable("id") int id) {
        TypeGround typeGround = typeGroundService.findById(id);
        if (typeGround != null) {
            return ResponseEntity.ok(typeGround);
        }
        return null;
    }
}
