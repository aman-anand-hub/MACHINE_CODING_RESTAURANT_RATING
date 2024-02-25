package com.example.demo.repositories;

import com.example.demo.entities.Review;
import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.User;

public interface IReviewRepository {
    Review save(Long rating, Long userId, Long restrauntId, String dishes, String description);
    Review findByReviewID(Long id);
    List<Review> findByUser(User user);
    List<Review> findByRestaurant(Restaurant restaurant);
    Review findIfExists(Long userId, Long restrauntId);
}
