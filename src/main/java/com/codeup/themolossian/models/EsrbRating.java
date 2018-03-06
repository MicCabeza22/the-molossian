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

    public EsrbRating(String name) {
        this.name = name;
    }

    public EsrbRating() {
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
