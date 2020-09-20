package com.codegym.webservice.controller;

import com.codegym.dao.entity.TypeFloor;
import com.codegym.web.services.TypeFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/typeFloors")
public class TypeFloorController {
    @Autowired
    private TypeFloorService typeFloorService;

    @GetMapping("")
    public List<TypeFloor> getAllTypeFloor() {
        List<TypeFloor> typeFloors;
        typeFloors = typeFloorService.findAll();
        return typeFloors;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TypeFloor> getFloor(@PathVariable("id") int id) {
        TypeFloor typeFloor = typeFloorService.findById(id);
        if (typeFloor != null) {
            return ResponseEntity.ok(typeFloor);
        }
        return null;
    }
}