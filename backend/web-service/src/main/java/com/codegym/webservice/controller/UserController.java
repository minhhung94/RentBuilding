package com.codegym.webservice.controller;

import com.codegym.dao.dto.JwtResponse;
import com.codegym.dao.dto.UserBuildingDTO;
import com.codegym.web.services.impl.UserBuildingServiceImpl;
import com.codegym.webservice.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")
public class UserController {
    @Autowired(required = false)
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired(required = false)
    UserBuildingServiceImpl userBuildingServiceImpl;

    private UserBuildingDTO userBuildingDTO;
    @GetMapping("/admin")
    public ResponseEntity<?> helloAdmin() {
        userBuildingDTO=new UserBuildingDTO("admin","Hello");
        return new ResponseEntity<>(userBuildingDTO, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> helloUser() {
        userBuildingDTO=new UserBuildingDTO("user","Hello");
        return new ResponseEntity<>(userBuildingDTO, HttpStatus.OK);
    }

    @GetMapping("/member")
    public ResponseEntity<?> helloMember() {
        userBuildingDTO=new UserBuildingDTO("member","Hello");
        return new ResponseEntity<>(userBuildingDTO, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserBuildingDTO userBuilding){
//        System.out.println(user.getPasswordUser());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userBuilding.getUsername(),userBuilding.getPasswordUser())
        );
        UserDetails userDetails = userBuildingServiceImpl
                .loadUserByUsername(authentication.getName());
        String jwtToken=jwtTokenUtil.generateToken(userDetails);
        JwtResponse jwtResponse= new JwtResponse(jwtToken,userDetails.getUsername(),userDetails.getAuthorities());
        return ResponseEntity.ok( jwtResponse);
    }
}
