package com.example.miniredditbackend.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserService userSer;

    @Autowired
    public UserController(UserService userSer){
        this.userSer = userSer;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserModel newUser, HttpServletResponse response){
        userSer.createUser(new User(newUser.getName(), newUser.getPassword()));
    }




}
