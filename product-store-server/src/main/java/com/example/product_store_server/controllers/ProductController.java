package com.example.product_store_server.controllers;

import com.example.product_store_server.models.Product;
import com.example.product_store_server.models.Product;
import com.example.product_store_server.models.Product;
import com.example.product_store_server.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    private ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            updatedProduct.setName(productDetails.getName());
            updatedProduct.setDescription(productDetails.getDescription());
            updatedProduct.setPrice(productDetails.getPrice());
            return ResponseEntity.ok(productService.save(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
