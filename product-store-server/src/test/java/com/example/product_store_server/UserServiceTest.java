package com.example.product_store_server;

import com.example.product_store_server.models.User;
import com.example.product_store_server.repositories.UserRepository;
import com.example.product_store_server.services.UserService;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private List<User> users;

    @BeforeAll
    void init(){
        User user1= new User("user1","user1@gmail.com");
        User user2= new User("user2","user2@gmail.com");
        this.users=new ArrayList<User>();
        Collections.addAll(this.users,user1,user2);
    }

    @Test
    void findAllUsers(){
        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<User> usersFound=userService.findAll();

        assertThat(usersFound.size()).isEqualTo(2);
        assertThat(usersFound).isEqualTo(users);
    }

    @Test
    void saveUser(){
        User user= users.getFirst();

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User userSaved=userService.save(user);

        assertThat(userSaved).isEqualTo(user);
    }

    @Test
    void deleteUser(){
        User user= users.getFirst();
        Long id=1L;
        Mockito.doNothing().when(userRepository).deleteById(id);

        userService.deleteById(id);

        Mockito.verify(userRepository,Mockito.times(1)).deleteById(id);
    }

    @Test
    void findById(){
        User user=users.getFirst();
        Long id=1L;
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));

        Optional<User> userFound= userService.findById(id);

        assertThat(userFound).isEqualTo(Optional.of(user));

    }



}
