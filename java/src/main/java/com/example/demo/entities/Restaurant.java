package com.example.demo.entities;
import java.util.ArrayList;
import java.util.List;
// import com.example.demo.entities.Review;

public class Restaurant {
    private final Long id;
    private final String name;
    private Long sumOfRating;
    private List<Review> reviews;

    public Restaurant(Long id, String name)
    {
        this.id= id;
        this.name= name;
        this.sumOfRating= 0L;
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
        sumOfRating+= r.getRating();
    }

    public double averageRating()
    {
        if (reviews.isEmpty()) {
            return 0.0; 
        }
        return ((double) sumOfRating / reviews.size());
    }

    @Override
    public String toString()
    {
        return "Restaurant [id="+ id+"]";
    }
}
