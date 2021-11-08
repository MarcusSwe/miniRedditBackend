package com.example.miniredditbackend.token;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user")
    private String name;
    @Column(name = "token")
    private String token;

    public Token(){
    }

    public Token(String user, String token){
        this.name = user;
        this.token = token;
    }


}
