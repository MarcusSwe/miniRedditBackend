package com.example.miniredditbackend.post;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

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

    /* note to self: måste skapa nedan tabell i sql annars går den på default varchar 255
    CREATE TABLE IF NOT EXISTS comments (id BIGINT AUTO_INCREMENT PRIMARY KEY, comment VARCHAR(700), commentAuthor TEXT, date TEXT, post_id BIGINT);
    */
    @Column(name ="comment", columnDefinition = "VARCHAR(700)")
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
