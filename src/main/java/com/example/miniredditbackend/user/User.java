package com.example.miniredditbackend.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user")
    private String name;
    @Column(name = "password")
    private String password;

    public User(){
    }

    public User(String user, String password){
        this.name = user;
        this.password = password;
    }


}
