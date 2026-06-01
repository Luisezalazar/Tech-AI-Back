package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Permission;
import com.example.demo.model.Role;
import com.example.demo.repository.IRoleRepository;


@Service
public class RoleService implements IRoleService {

    @Autowired
    IRoleRepository roleRepo;

    @Override
    public List<Role> getAllRoles() {
        List<Role> listRole = roleRepo.findAll();
        return listRole;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void editRole(Long originalId, String newName, Set<Permission> newPermissions) {
        Role role = this.getRoleById(originalId);
        
        if (role != null) {
            role.setName(newName);
            role.getPermissions().clear();
            if (newPermissions != null) {
                role.getPermissions().addAll(newPermissions);
            }
            
            roleRepo.save(role);
        } else {
            throw new RuntimeException("Rol no encontrado");
        }
    }

}
