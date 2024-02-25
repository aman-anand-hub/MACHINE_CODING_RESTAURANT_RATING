package com.example.demo.services;

import com.example.demo.entities.Review;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IRestaurantRepository;

public class ReviewService {
    private IReviewRepository reviewRepository;
    private IRestaurantRepository restaurantRepository;

    public ReviewService(IReviewRepository reviewRepository, IRestaurantRepository restaurantRepository)
    {
        this.reviewRepository= reviewRepository;
        this.restaurantRepository= restaurantRepository;
    }

    public String addRating(Long rating, Long userId, Long restrauntId)
    {
        Review alreadyExists= reviewRepository.findIfExists(userId, restrauntId);

        if(alreadyExists == null)
        {
            Review review= reviewRepository.save(rating, userId, restrauntId, null, null);
            return review.toString() + " added successfully for Restaurant [id=" + restrauntId + "] by User [id=" + userId + "]!"; 
        }
        else
        {
            alreadyExists.setRating(rating);
            return alreadyExists.toString() + " added successfully for Restaurant [id=" + restrauntId + "] by User [id=" + userId + "]!";
        }
    }

    public String addReview(Long rating, Long userId, Long restaurantId, String dishes, String description)
    {
        Review alreadyExists= reviewRepository.findIfExists(userId, restaurantId);

        if(alreadyExists == null)
        {
            Review review= reviewRepository.save(rating, userId, restaurantId, dishes, description);
            return review.toString() + " added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!"; 
        }
        else
        {
            alreadyExists.setRating(rating);
            alreadyExists.setDishes(dishes);
            alreadyExists.setDescription(description);
            return alreadyExists.toString() + " added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";
        }
    }

    public String getReviews(Long restaurantId, String order)
    {
        Restaurant rest= restaurantRepository.findById(restaurantId);
        List<Review> listOfReview= new ArrayList<>();
        listOfReview= rest.getReviews();
        // sort in ascending order based on rating
        Collections.sort(listOfReview, Comparator.comparingLong(Review::getRating));

        if(order.equals("RATING_DESC"))
        {
            Collections.reverse(listOfReview);
        }

        return listOfReview.toString();
    }

    public String getReviewsFilterOrder(Long restaurantId, Long low, Long high, String order)
    {
        Restaurant rest= restaurantRepository.findById(restaurantId);
        List<Review> listOfReview= new ArrayList<>();
        listOfReview= rest.getReviews();
        // sort in ascending order based on rating
        Collections.sort(listOfReview, Comparator.comparingLong(Review::getRating));

        if(order.equals("RATING_DESC"))
        {
            Collections.reverse(listOfReview);
        }

        List<Review> filteredReview= new ArrayList<>();

        for (Review review : listOfReview) {
            Long rating = review.getRating();
            if (rating >= low && rating <= high) {
                filteredReview.add(review);
            }
        }

        return filteredReview.toString();
    }
}
