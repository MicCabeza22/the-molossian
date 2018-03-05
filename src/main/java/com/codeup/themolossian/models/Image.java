package com.codeup.themolossian.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue
    private long id;

    @Column(columnDefinition = "text")
    private String url;

    // one-to-many
}
