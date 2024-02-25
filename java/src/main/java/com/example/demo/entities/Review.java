package com.example.demo.entities;

public class Review {
    private final Long id;
	private final User user;
	private final Restaurant restaurant;
	private String dishes;
	private String discription;
	private Long rating;

    public Review(Long id, User user, Restaurant restaurant, Long rating, String dishes, String discription)
    {
        this.id= id;
        this.user= user;
        this.restaurant= restaurant;
        this.rating= rating;
        this.dishes= dishes;
        this.discription= discription;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getDishes() {
        return dishes;
    }

    public String getDiscription() {
        return discription;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long newRating) {
        rating= newRating;
    }

    public void setDishes(String dish)
    {
        dishes= dish;
    }

    public void setDescription(String desc)
    {
        discription= desc;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + "]";
    }

}
