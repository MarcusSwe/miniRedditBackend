package com.example.miniredditbackend.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

    private String title;
    private String author;
    private String date;
    private String message;
    private long id;
    private int upvote;
    private int downvote;
    private String hypermedialink;

    public PostDTO(String title, String author, String date, String message, long id, int upvote, int downvote, String hypermedialink) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.message = message;
        this.id = id;
        this.upvote = upvote;
        this.downvote = downvote;
        this.hypermedialink = hypermedialink;
    }

}
