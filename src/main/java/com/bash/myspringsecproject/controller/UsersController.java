package com.bash.myspringsecproject.controller;

import com.bash.myspringsecproject.model.MyAppUsers;
import com.bash.myspringsecproject.repository.UserRepository;
import com.bash.myspringsecproject.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final MyUserService myUserService;
    private final BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/")
    public String getHomePage() {
        return "Welcome to Spring Security User Management System!";
    }

    @GetMapping("/users")
    public String getUsers(){
        return "List of users is here";
    }
//    @PostMapping("/login")
//    public String login(@RequestBody MyAppUsers user){
//        return "Login successful";
//    }
    @PostMapping("/signup")
    public MyAppUsers registerUser(@RequestBody MyAppUsers user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserService.registerUser(user);
    }
}
