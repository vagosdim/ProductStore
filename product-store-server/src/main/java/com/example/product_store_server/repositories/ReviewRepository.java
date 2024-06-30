package com.example.product_store_server.repositories;

import com.example.product_store_server.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
