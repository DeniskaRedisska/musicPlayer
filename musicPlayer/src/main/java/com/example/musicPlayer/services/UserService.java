package com.example.musicPlayer.services;

import com.example.musicPlayer.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Iterable<User> getUsers();
    void addUser(User user);
    void deleteUser(User user);
    Optional<User> findById(int id);
    void edit(User user);
}
