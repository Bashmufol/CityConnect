package com.bash.myspringsecproject.service;

import com.bash.myspringsecproject.model.MyAppUsers;
import com.bash.myspringsecproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final UserRepository repo;

    public MyAppUsers registerUser(@RequestBody MyAppUsers user){
        return repo.save(user);
    }
}
