package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.payload.request.UserRequest;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail())
                .setPassword(userRequest.getPassword());

        if(userService.register(user)) {
            return ResponseEntity.ok("Successfully");
        }
        return ResponseEntity.ok("Fail");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail())
                .setPassword(userRequest.getPassword());

        if(userService.login(user) != null) {
            return ResponseEntity.ok(userService.login(user));
        }
        return ResponseEntity.ok("Fail");
    }

}
