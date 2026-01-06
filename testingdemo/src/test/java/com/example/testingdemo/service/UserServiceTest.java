package com.example.testingdemo.service;

import com.example.testingdemo.model.User;
import com.example.testingdemo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    void createUserTest() {
        User user = new User(1L, "Saloni");
        when(repository.save(user)).thenReturn(user);

        User saved = service.createUser(user);

        assertEquals("Saloni", saved.getUsername());
    }

    @Test
    void findByIdExists() {
        User user = new User(1L, "Saloni");
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        User result = service.findById(1L);

        assertNotNull(result);
    }

    @Test
    void findByIdNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> service.findById(1L));
    }
}
