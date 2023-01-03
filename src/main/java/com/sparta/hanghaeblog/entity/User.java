package com.sparta.hanghaeblog.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

//    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)
//    private UserRoleEnum role;

    @OneToMany
    List<Blog> blogs = new ArrayList<>();

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
