package com.codegym.webservice.controller;

import com.codegym.dao.dto.UserBuildingDTO;
import com.codegym.dao.entity.UserBuilding;
import com.codegym.web.services.UserBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/userBuildings")
public class UserBuildingController {
    @Autowired
    UserBuildingService userBuildingService;
    @GetMapping("")
    public List<UserBuilding> getAllTypeGround() {
        return userBuildingService.findAllByDeleteFlagIsNull();
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserBuilding> getUserBuilding(@PathVariable("username") String username) {
        UserBuilding userBuilding = userBuildingService.findByUsername(username);
        if (userBuilding != null) {
            return ResponseEntity.ok(userBuilding);
        }
        return null;
    }
    @PostMapping("")
    public ResponseEntity<?> createUserBuilding( @RequestBody UserBuildingDTO userBuildingDTO) {
        userBuildingService.save(userBuildingDTO);
        return ResponseEntity.ok(userBuildingDTO);
    }

}
