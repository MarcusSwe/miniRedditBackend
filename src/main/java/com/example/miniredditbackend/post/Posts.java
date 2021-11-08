package com.example.miniredditbackend.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "Posts")
public class Posts {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    @Column(name = "message")
    private String message;

    @Column(name = "upvote")
    private int upvote;

    @Column(name = "downvote")
    private int downvote;

    /* -- one to many .. one table one colummn - tablename is id from post plus voters
    @Column(name = "votenames")
    private String votenames;*/

    /* -- one to many .. one table thw columms - tablename is id plus comments
    @Column(name = "votenames")
    private String votenames;*/

    public Posts(){
    }

    public Posts(String title, String author, String date, String message, int upvote, int downvote){
        this.title = title;
        this.author = author;
        this.date = date;
        this.message = message;
        this.upvote = upvote;
        this.downvote = downvote;
    }


}
