package com.example.demo.repositories;

import com.example.demo.entities.Review;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.User;

public class ReviewRepository implements IReviewRepository {
    private final Map<Long,Review> reviewMap;
    private IUserRepository userRepository;
    private IRestaurantRepository restaurantRepository;
    private Long autoIncrement= 1L;

    public ReviewRepository(IUserRepository userRepository, IRestaurantRepository restaurantRepository){
        reviewMap = new HashMap<Long, Review>();
        this.userRepository= userRepository;
        this.restaurantRepository= restaurantRepository;
    }

    @Override
    public Review save(Long rating, Long userId, Long restrauntId, String dishes, String description) {
        User user= userRepository.findById(userId);
        Restaurant restaurant= restaurantRepository.findById(restrauntId);

        Review nReview= new Review(autoIncrement, user, restaurant, rating, dishes, description);
        reviewMap.put(autoIncrement, nReview);
        ++autoIncrement;

        restaurant.addReview(nReview);
        user.addReview(nReview);

        return nReview;
    }

    @Override
    public Review findByReviewID(Long id) {
        return reviewMap.get(id);
    }

    @Override
    public List<Review> findByUser(User user) {
        return user.getReviews();
    }

    @Override
    public List<Review> findByRestaurant(Restaurant restaurant) {
        return restaurant.getReviews();
    }

    @Override
    public Review findIfExists(Long userId, Long restaurantId) {
        for (Review review : reviewMap.values()) {
            User user = review.getUser();
            Restaurant restaurant = review.getRestaurant();
    
            if (user.getId().equals(userId) && restaurant.getId().equals(restaurantId)) {
                return review;
            }
        }
        return null;
    }   
}
