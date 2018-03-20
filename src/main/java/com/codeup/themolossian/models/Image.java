package com.codeup.themolossian.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    private long id;

    @Column(columnDefinition = "text")
    private String url;

    public Image(String url) {
        this.url = url;
    }

    public Image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
