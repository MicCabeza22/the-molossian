package com.codeup.themolossian.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "platforms")
public class Platform {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platform")
    private List<Game> games;

    public Platform(Image image, String name, List<Game> games) {
        this.image = image;
        this.name = name;
        this.games = games;
    }

    public Platform() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
