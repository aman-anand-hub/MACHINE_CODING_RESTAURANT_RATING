package com.example.demo.repositories;

import com.example.demo.entities.User;

public interface IUserRepository {
    User save(String name);
    User findById(Long id);
    User findByName(String name);
}
