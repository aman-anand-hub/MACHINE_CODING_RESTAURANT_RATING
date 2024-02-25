package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewsCommand implements ICommand {
    private final ReviewService reviewService;

    public GetReviewsCommand(ReviewService reviewService)
    {
        this.reviewService= reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long resId= Long.parseLong(tokens.get(1));
        String order= tokens.get(2);
        String res= reviewService.getReviews(resId, order);
        System.out.println(res);
    }
}
