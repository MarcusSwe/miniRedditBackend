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
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "name")
    private String name;

    public Token(){
    }

    public Token(String token, String name){
        this.token = token;
        this.name = name;
    }


}
