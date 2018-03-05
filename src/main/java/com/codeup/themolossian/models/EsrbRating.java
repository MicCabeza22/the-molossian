package com.codeup.themolossian.models;

import javax.persistence.*;

@Entity
@Table(name = "esrbRatings")
public class EsrbRating {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;
}
