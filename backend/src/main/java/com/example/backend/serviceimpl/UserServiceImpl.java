package com.example.backend.serviceimpl;

import com.example.backend.dao.UserRepository;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean register(User user) {

        if(!userRepository.existsByEmail(user.getEmail())) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword()).orElse(null);
    }
}
