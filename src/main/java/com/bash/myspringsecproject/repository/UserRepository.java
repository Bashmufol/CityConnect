package com.bash.myspringsecproject.repository;

import com.bash.myspringsecproject.model.MyAppUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyAppUsers,Long> {
    Optional<MyAppUsers> findByUsername(String username);
    Optional<MyAppUsers> findByEmail(String email);
}
