package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;

public class ListRestaurantsCommand implements ICommand {
    private final RestaurantService restaurantService;

    public ListRestaurantsCommand(RestaurantService restaurantService)
    {
        this.restaurantService= restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String res= restaurantService.listRestaurant();
        System.out.println(res);
    }
    
}