package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepo;

    @Autowired
    IRoleRepository roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder; 

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        String passwordEncriptada = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncriptada);

        if (user.getRol() != null && user.getRol().getId() != null) {
            Role rolCompleto = roleRepo.findById(user.getRol().getId()).orElse(null);
            
            if (rolCompleto != null) {
                user.setRol(rolCompleto);
            } else {
                throw new RuntimeException("El rol asignado no existe en la base de datos.");
            }
        }
        
        return userRepo.save(user); 
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public void editUser(Integer originalId, String newEmail, String newPassword, Long newRolId) {
        User user = this.getUserById(originalId);

        if (user != null) {
            user.setEmail(newEmail);
            
            if (newRolId != null) {
                Role role = roleRepo.findById(newRolId).orElse(null);
                
                if (role != null) {
                    user.setRol(role);
                } else {
                    System.out.println("Cuidado: El rol con ID " + newRolId + " no existe en la base de datos.");
                }
            }
            
            if (newPassword != null && !newPassword.trim().isEmpty()) {
                String passwordEncriptada = passwordEncoder.encode(newPassword);
                user.setPassword(passwordEncriptada);
            }
            
            userRepo.save(user);
        }
    }
}