package com.example.demo.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Permission;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;

@Configuration
public class AdminSeeder {

    @Bean
    public CommandLineRunner initAdminUser(IUserRepository userRepository, PasswordEncoder passwordEncoder, IRoleRepository roleRepository) {
        return args -> {
            Role adminRole = roleRepository.findByName("ADMIN").orElseGet(() -> {
                Role newRole = new Role();
                newRole.setName("ADMIN");
                newRole.setPermissions(new HashSet<>(Arrays.asList(Permission.values())));
                return roleRepository.save(newRole);
            });

            String adminEmail = "admin@admin.com";
            if (userRepository.findByEmail(adminEmail).isEmpty()) {
                
                User admin = new User();
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode("123456"));
                
                admin.setRol(adminRole); 
                
                userRepository.save(admin);
                System.out.println("Admin user created successfully!");

            } else {
                System.out.println("The user already exists");
            }
        };
    }
}
