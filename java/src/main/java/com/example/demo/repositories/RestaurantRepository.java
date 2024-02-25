package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository {
    private final List<Restaurant> restaurantList;
    private Long autoIncrement = 1L;

    public RestaurantRepository() {
        restaurantList = new ArrayList<>();
    }

    @Override
    public Restaurant save(String name) {
        Restaurant nRes = new Restaurant(autoIncrement, name);
        restaurantList.add(nRes);
        ++autoIncrement;
        return nRes;
    }

    @Override
    public Restaurant findById(Long id) {
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getId().equals(id)) {
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public Restaurant findByName(String name) {
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public List<Restaurant> listAll() {
        List<Restaurant> res= new ArrayList<>(restaurantList);
        return res;
    }
}