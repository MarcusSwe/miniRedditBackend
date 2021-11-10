package com.example.miniredditbackend.user;


import com.example.miniredditbackend.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    private UserService userSer;
    private TokenService tokenSer;

    @Autowired
    public UserController(UserService userSer, TokenService tokenSer){
        this.userSer = userSer;
        this. tokenSer = tokenSer;
    }

    @PostMapping("/newuser")
    public void createUser(@RequestBody UserModel newUser, HttpServletResponse response){


        userSer.createUser(new User(newUser.getName(), newUser.getPassword()));



    }

    @PostMapping("/login")
    public String login(@RequestBody UserModel loginUser, HttpServletResponse response){
        String token = "ok";

        return token;
    }

}
