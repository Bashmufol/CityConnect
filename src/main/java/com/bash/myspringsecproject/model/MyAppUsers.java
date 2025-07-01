package com.bash.myspringsecproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class MyAppUsers {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

}
