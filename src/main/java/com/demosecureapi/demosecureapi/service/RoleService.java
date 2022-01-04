package com.demosecureapi.demosecureapi.service;

import com.demosecureapi.demosecureapi.model.Role;
import com.demosecureapi.demosecureapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role){
        roleRepository.save(role);
        return role;
    }

    public Role findRole(String role){
      return roleRepository.findRoleByName(role);
    }

    public List<Role> findAll( ){
        return roleRepository.findAll();
    }
}
