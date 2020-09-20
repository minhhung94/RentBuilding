package com.codegym.web.services;

import com.codegym.dao.dto.UserBuildingDTO;
import com.codegym.dao.entity.UserBuilding;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserBuildingService {
    List<UserBuilding> findAllByDeleteFlagIsNull();
    UserBuilding findByUsername(String username);
    UserDetails loadUserByUsername(String userName);
    UserBuildingDTO getUserBuildingByUsername(String username);
    void save(UserBuildingDTO userBuildingDTO);
}
