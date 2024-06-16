package com.example.product_store_server.repositories;
import com.example.product_store_server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
