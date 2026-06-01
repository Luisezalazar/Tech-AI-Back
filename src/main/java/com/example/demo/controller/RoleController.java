package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Role;
import com.example.demo.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/getAllRoles")
    public List<Role> getAllRoles() {
        List<Role> listRole = roleService.getAllRoles();
        return listRole;
    }

    @GetMapping("/getRoleById/{id}")
    public Role getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        return role;
    }

    @PostMapping("/saveRole")
    public void saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    @PutMapping("/editRole/{originalId}")
    public Role editRole(
            @PathVariable Long originalId,
            @RequestBody Role updatedRole) { 

        roleService.editRole(originalId, updatedRole.getName(), updatedRole.getPermissions());
        return roleService.getRoleById(originalId);
    }
}
