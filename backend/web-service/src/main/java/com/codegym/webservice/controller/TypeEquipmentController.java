package com.codegym.webservice.controller;


import com.codegym.dao.entity.TypeEquipment;
import com.codegym.web.services.TypeEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/type_equipment")
public class TypeEquipmentController {

    @Autowired
    TypeEquipmentService typeEquipmentService;

    @GetMapping("")
    public List<TypeEquipment> getAllTypeEquipment() {
        List<TypeEquipment> typeEquipments;
        typeEquipments = typeEquipmentService.findAllByDeleteFlagIsNull();
        return typeEquipments;
    }
}
