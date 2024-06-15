package com.example.online_product_store.repositories;
import com.example.online_product_store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
