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

    @OneToOne
    private Image image;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<Post> posts;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "users_games",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")}
    )
    private List<Game> games;

    public User(String email, Image image, String password, String username, List<Post> posts, List<Game> games) {
        this.email = email;
        this.image = image;
        this.password = password;
        this.username = username;
        this.posts = posts;
        this.games = games;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
