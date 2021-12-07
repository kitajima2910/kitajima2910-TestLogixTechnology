package com.example.backend.service;

import com.example.backend.entity.User;

import java.util.Optional;

public interface UserService {

    boolean register(User user);

    User login(User user);

}
