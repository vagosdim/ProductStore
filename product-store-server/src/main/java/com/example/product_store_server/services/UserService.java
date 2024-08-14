package com.example.product_store_server.services;

import com.example.product_store_server.repositories.UserRepository;
import com.example.product_store_server.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User getOrCreateUser(OAuth2User oAuth2User) {
        Integer githubId = oAuth2User.getAttribute("id");
        String username = oAuth2User.getAttribute("login");
        String email = oAuth2User.getAttribute("email");

        return userRepository.findByUsername(username).orElseGet(() -> {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            return userRepository.save(user);
        });
    }
}
