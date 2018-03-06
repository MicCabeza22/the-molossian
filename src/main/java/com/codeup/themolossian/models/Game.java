package com.codeup.themolossian.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    private long id;

    @Column(columnDefinition = "text")
    private String description;

    @OneToOne
    private EsrbRating esrbRating;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToOne
    private Image image;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @Column
    private int rating;

    @Column
    private java.time.LocalDate releaseDate;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToMany(mappedBy = "games")
    private List<User> users;

    public Game(String description, EsrbRating esrbRating, Genre genre, Image image, Platform platform, int rating,
                LocalDate releaseDate, String title, List<User> users) {
        this.description = description;
        this.esrbRating = esrbRating;
        this.genre = genre;
        this.image = image;
        this.platform = platform;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.title = title;
        this.users = users;
    }

    public Game() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EsrbRating getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(EsrbRating esrbRating) {
        this.esrbRating = esrbRating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
