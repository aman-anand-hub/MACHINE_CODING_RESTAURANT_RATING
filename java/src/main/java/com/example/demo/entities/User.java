package com.example.demo.entities;
import java.util.ArrayList;
import java.util.List;
// import com.example.demo.entities.Review;

public class User {
    private final Long id;
    private final String name;
    private List<Review> reviews;

    public User(Long id, String name)
    {
        this.id= id;
        this.name= name;
        this.reviews= new ArrayList<>();
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<Review> getReviews()
    {
        return reviews;
    }

    public void addReview(Review r)
    {
        reviews.add(r);
    }

    @Override
    public String toString()
    {
        return "User [id="+ id+"]";
    }
}
