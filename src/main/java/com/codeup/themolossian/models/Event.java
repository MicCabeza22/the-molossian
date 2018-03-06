package com.codeup.themolossian.models;

import javax.persistence.*;
import java.time.LocalDate;

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

    @OneToOne
    private Game game;

    @OneToOne
    private Image image;

    @Column(nullable = false)
    private String title;

    @OneToOne
    private User user;

    public Event(LocalDate date, String description, Game game, Image image, String title, User user) {
        this.date = date;
        this.description = description;
        this.game = game;
        this.image = image;
        this.title = title;
        this.user = user;
    }

    public Event() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
