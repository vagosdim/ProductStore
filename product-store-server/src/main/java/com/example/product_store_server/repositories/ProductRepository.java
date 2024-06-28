package com.example.product_store_server.repositories;

import com.example.product_store_server.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}