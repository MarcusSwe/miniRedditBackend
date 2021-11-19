package com.example.miniredditbackend.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class commentDTO {

    private String commentAuthor;
    private String comment;
    private String date;
    private long id;

    public commentDTO(String commentAuthor, String comment, String date, long id){
        this.commentAuthor = commentAuthor;
        this.comment = comment;
        this.date = date;
        this.id = id;
    }
}
