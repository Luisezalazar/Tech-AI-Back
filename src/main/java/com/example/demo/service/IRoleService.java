package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.model.Permission;
import com.example.demo.model.Role;

public interface IRoleService {

    public List<Role> getAllRoles();

    public Role getRoleById(Long id);

    public void saveRole(Role role);

    public void deleteRole(Long id);

    public void editRole(Long originalId, String newName, Set<Permission> newPermissions);
}
