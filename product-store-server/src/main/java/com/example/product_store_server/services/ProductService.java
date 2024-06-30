package com.example.product_store_server.services;

import com.example.product_store_server.models.Product;
import com.example.product_store_server.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    public Product save(Product user) {
        return this.productRepository.save(user);
    }

    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
