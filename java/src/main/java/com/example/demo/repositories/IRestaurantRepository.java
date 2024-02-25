package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Restaurant;

public interface IRestaurantRepository {
    Restaurant save(String name);
    Restaurant findById(Long id);
    Restaurant findByName(String name);
    List<Restaurant> listAll();
}
