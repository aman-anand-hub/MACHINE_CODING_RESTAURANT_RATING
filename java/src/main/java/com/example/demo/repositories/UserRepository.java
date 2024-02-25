package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository{
    private final Map<Long,User> userMap;
    private Long autoIncrement= 1L;

    public UserRepository(){
        userMap = new HashMap<Long,User>();
    }

    @Override
    public User save(String name) {
        User nUser= new User(autoIncrement, name);
        userMap.put(autoIncrement, nUser);
        ++autoIncrement;
        return nUser;
    }

    @Override
    public User findById(Long id) {
        return userMap.get(id);
    }

    @Override
    public User findByName(String name) {
        for (Map.Entry<Long, User> entry : userMap.entrySet()) {
            User user = entry.getValue();
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

}
