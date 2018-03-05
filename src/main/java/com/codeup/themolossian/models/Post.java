package com.codeup.themolossian.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
    // int id

    @Column(columnDefinition = "text")
    private String body;

    // genre_id

    // image_id

    @Column
    private String title;

    // user_id
}
