package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class AddReviewCommand implements ICommand {
    public final ReviewService reviewService;

    public AddReviewCommand(ReviewService reviewService) {
        this.reviewService= reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long rating = Long.parseLong(tokens.get(1));
        Long userId= Long.parseLong(tokens.get(2));
        Long restaurantId= Long.parseLong(tokens.get(3));
        String dishes= tokens.get(4);
        String desc= tokens.get(5);
        String res= reviewService.addReview(rating, userId, restaurantId,dishes,desc);
        System.out.println(res);
    }
    
}
