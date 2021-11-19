package com.example.miniredditbackend.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "voters")
public class VoteNames {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String votenames;
    private String whatvote;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Posts posts;

    public VoteNames() {

    }

    public VoteNames(String voter, String whatvote, Posts posts){
        this.votenames = voter;
        this.whatvote = whatvote;
        this.posts = posts;
    }


}
