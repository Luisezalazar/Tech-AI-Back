package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface IUserService {

    public List<User>getAllUser();

    public User getUserById(Integer id);

    public User saveUser(User user);

    public void deleteUser(Integer id);

    public void editUser(Integer originalId, String newEmail, String newPassword, Long newRolId);
}
