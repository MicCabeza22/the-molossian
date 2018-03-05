package com.codeup.themolossian.models;

import javax.persistence.*;

@Entity
@Table(name = "platforms")
public class Platform {
    @Id
    @GeneratedValue
    private long id;

    // image_id

    @Column(nullable = false, unique = true)
    private String name;
}
