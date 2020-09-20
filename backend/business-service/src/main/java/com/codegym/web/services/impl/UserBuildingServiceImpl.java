package com.codegym.web.services.impl;

import com.codegym.dao.dto.UserBuildingDTO;
import com.codegym.dao.entity.RoleUser;
import com.codegym.dao.entity.UserBuilding;
import com.codegym.dao.repository.UserBuildingRepository;
import com.codegym.web.services.UserBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserBuildingServiceImpl implements UserBuildingService, UserDetailsService {
    @Autowired
    UserBuildingRepository userBuildingRepository;
    @Override
    public List<UserBuilding> findAllByDeleteFlagIsNull() {
        return userBuildingRepository.findAllByDeleteFlagIsNull();
    }

    @Override
    public UserBuilding findByUsername(String username) {
      return userBuildingRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserBuilding userBuilding = userBuildingRepository.findAllByDeleteFlagIsNullAndUsernameIs(userName);
        if (userBuilding == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        RoleUser roles = userBuilding.getRoleUser();
        grantedAuthorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
        return new org.springframework.security.core.userdetails.User(userBuilding.getUsername(), userBuilding.getPasswordUser(),
                grantedAuthorities);
    }

    @Override
    public UserBuildingDTO getUserBuildingByUsername(String username) {
       UserBuilding userBuilding = userBuildingRepository.findAllByDeleteFlagIsNullAndUsernameIs(username);
       if(userBuilding != null){
           UserBuildingDTO userBuildingDTO = new UserBuildingDTO();
           userBuildingDTO.setCustomer(userBuilding.getCustomer());
           userBuildingDTO.setDeleteFlag(userBuilding.getDeleteFlag());
           userBuildingDTO.setPasswordUser(userBuilding.getPasswordUser());
           userBuildingDTO.setCustomer(userBuilding.getCustomer());
           userBuildingDTO.setRoleUser(userBuilding.getRoleUser());
           userBuildingDTO.setEmployee(userBuilding.getEmployee());
           return userBuildingDTO;
       }
       return null;
    }

    @Override
    public void save(UserBuildingDTO userBuildingDTO) {
        UserBuilding userBuilding = new UserBuilding();
        userBuilding.setUsername(userBuildingDTO.getUsername());
        userBuilding.setDeleteFlag(userBuildingDTO.getDeleteFlag());
        userBuilding.setPasswordUser(userBuildingDTO.getPasswordUser());
        userBuilding.setEmployee(userBuildingDTO.getEmployee());
        userBuilding.setCustomer(userBuildingDTO.getCustomer());
        userBuilding.setRoleUser(userBuildingDTO.getRoleUser());
        userBuildingRepository.save(userBuilding);
    }
}
