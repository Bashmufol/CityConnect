package com.bash.myspringsecproject.controller;

import com.bash.myspringsecproject.model.MyAppUsers;
import com.bash.myspringsecproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UserRepository repo;
    @GetMapping("/users")
    public String getUsers(){
        return "List of users is here";
    }
    @PostMapping("/signup")
    public MyAppUsers signUp(@RequestBody MyAppUsers user){
        r
        return user;
    }
}
