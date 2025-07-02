package com.bash.myspringsecproject.controller;


import com.bash.myspringsecproject.service.JwtService;
import com.bash.myspringsecproject.service.MyUserDetailsService;
import com.bash.myspringsecproject.service.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MyUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> request) throws Exception {
        String username = request.get("username");
        String password = request.get("password");

        // Authenticate the user with Spring Security's AuthenticationManager
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
//        Potential Error
        // Load UserDetails after successful authentication to generate the token
        final UserPrincipal userPrincipal = (UserPrincipal) userDetailsService.loadUserByUsername(username);
        final String token = jwtService.generateToken(userPrincipal);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);

    }

}
