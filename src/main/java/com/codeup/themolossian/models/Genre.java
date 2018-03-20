package com.codeup.themolossian.models;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
