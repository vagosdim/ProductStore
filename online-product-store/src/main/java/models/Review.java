package models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Review {
    @Id
    @GeneratedValue
    private Long Id;

    private int rating;
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    public Review(Long id, int rating, String comment, User user, Product product) {
        Id = id;
        this.rating = rating;
        this.comment = comment;
        this.user = user;
        this.product = product;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}