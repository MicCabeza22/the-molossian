package com.codeup.themolossian.models;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private java.time.LocalDate date;

    @Column(columnDefinition = "text")
    private String description;

    // game_id

    // image_id

    @Column(nullable = false)
    private String title;

    // user_id
}
