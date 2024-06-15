package com.example.online_product_store.services;

import com.example.online_product_store.repositories.UserRepository;
import com.example.online_product_store.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
