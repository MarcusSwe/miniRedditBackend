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
    public String createUser(@RequestBody UserModel newUser, HttpServletResponse response){

        int x = userSer.createUser(new User(newUser.getName(), newUser.getPassword()));

        switch (x){
            case(0):
            response.setStatus(409);
            return "User already exists!";

            case(1):
            return "User created!";

            default:
            response.setStatus(500);
            return "Something went wrong!";

        }
    }



    @PostMapping("/login")
    public String login(@RequestBody User loginUser, HttpServletResponse response){

        String token = userSer.loginUser(loginUser);

        if (token == null) {
            response.setStatus(406);
            return null;
        }

        return token;
    }

}
