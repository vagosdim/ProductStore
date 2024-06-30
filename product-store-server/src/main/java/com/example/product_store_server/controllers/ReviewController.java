package com.example.product_store_server.controllers;

import com.example.product_store_server.models.Review;

import com.example.product_store_server.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;



    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> user = this.reviewService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping
    public List<Review> getAllReviews(){
        return this.reviewService.findAll();
    }


    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return this.reviewService.save(review);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Optional<Review> review = this.reviewService.findById(id);
        if (review.isPresent()) {
            Review updatedReview = review.get();
            updatedReview.setRating(reviewDetails.getRating());
            updatedReview.setComment(reviewDetails.getComment());
            updatedReview.setProduct(reviewDetails.getProduct());
            updatedReview.setUser(reviewDetails.getUser());

            return ResponseEntity.ok(this.reviewService.save(updatedReview));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Review> review = this.reviewService.findById(id);
        if (review.isPresent()) {
            this.reviewService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


