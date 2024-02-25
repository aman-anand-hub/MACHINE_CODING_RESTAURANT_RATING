package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository)
    {
        this.userRepository= userRepository;
    }

    public String registerUser(String name)
    {
        User u= userRepository.save(name);
        return u.toString();
    }
}
