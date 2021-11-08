package com.example.miniredditbackend.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String commentAuthor;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Posts posts;

    public Comments(){

    }

    public Comments(String commentauthor, String comment, Posts posts){
        this.commentAuthor = commentauthor;
        this.comment = comment;
        this.posts = posts;
    }

}
