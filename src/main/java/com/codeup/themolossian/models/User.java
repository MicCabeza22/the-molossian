package com.codeup.themolossian.models;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    // image_id

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;
}
