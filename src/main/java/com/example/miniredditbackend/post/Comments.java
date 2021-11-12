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
    private Integer id;

    private String commentAuthor;
    private String comment;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Posts posts;

    public Comments(){

    }

    public Comments(String commentauthor, String comment,String date, Posts posts){
        this.commentAuthor = commentauthor;
        this.comment = comment;
        this.date = date;
        this.posts = posts;
    }

}
