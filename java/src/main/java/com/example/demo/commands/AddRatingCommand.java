package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class AddRatingCommand implements ICommand {
    public final ReviewService reviewService;

    public AddRatingCommand(ReviewService reviewService) {
        this.reviewService= reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long rating = Long.parseLong(tokens.get(1));
        Long userId= Long.parseLong(tokens.get(2));
        Long restaurantId= Long.parseLong(tokens.get(3));
        String res= reviewService.addRating(rating, userId, restaurantId);
        System.out.println(res);
    }
    
}
