package com.example.product_store_server.services;


import com.example.product_store_server.models.Review;
import com.example.product_store_server.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll(){
        return this.reviewRepository.findAll();
    }

    public Optional<Review> findById(Long id) {
        return this.reviewRepository.findById(id);
    }

    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }

    public void deleteById(Long id) {
        this.reviewRepository.deleteById(id);
    }
}
