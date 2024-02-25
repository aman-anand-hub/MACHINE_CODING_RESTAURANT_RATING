package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;

public class RegisterRestaurantCommand implements ICommand{
    private final RestaurantService restaurantService;

    public RegisterRestaurantCommand(RestaurantService restaurantService)
    {
        this.restaurantService= restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name= tokens.get(1);
        String res= restaurantService.registerRestaurant(name);
        System.out.println(res);
    }
    
}
