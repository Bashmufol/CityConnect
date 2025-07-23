package com.bash.myspringsecproject.service;

import com.bash.myspringsecproject.model.MyAppUsers;
import com.bash.myspringsecproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String input) {
        Optional<MyAppUsers> userOptional = repo.findByUsername(input);
        if (userOptional.isEmpty()) {
           userOptional = repo.findByEmail(input);htndndm
        }
        if (userOptional.isPresent()) {
            MyAppUsers user = userOptional.get();
            return new UserPrincipal(user);
        }
        else throw new UsernameNotFoundException("User not found with username or email" + input);
    }
}
