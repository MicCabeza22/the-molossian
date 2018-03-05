package com.codeup.themolossian.models;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    private long id;

    @Column(columnDefinition = "text")
    private String description;

    // esrb_rating_id

    // genre_id

    // image_id

    // platform_id

    @Column
    private int rating;

    @Column
    private java.time.LocalDate releaseDate;

    @Column(nullable = false, unique = true)
    private String title;
}
