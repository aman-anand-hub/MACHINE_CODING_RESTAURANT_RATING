package com.example.demo.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;

public class RestaurantService {
    private IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository)
    {
        this.restaurantRepository= restaurantRepository;
    }

    public String registerRestaurant(String name)
    {
        Restaurant res= restaurantRepository.save(name);
        return res.toString();
    }

    public String describeRestaurant(Long restaurantId)
    {
        Restaurant restaurant= restaurantRepository.findById(restaurantId);
        String name= restaurant.getName();
        Double rating= restaurant.averageRating();

        return "Restaurant [id=" +restaurantId+ ", name=" +name+ ", rating=" +rating+ "]";
    }

    public String listRestaurant()
    {
        List<Restaurant> allRes= new ArrayList<>(restaurantRepository.listAll());
        allRes.sort(Comparator.comparingDouble(Restaurant::averageRating).reversed());
        return allRes.toString();
    }

}
