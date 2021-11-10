package com.example.miniredditbackend.token;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TokenController {

    private TokenService tokenSer;

    @Autowired
    public TokenController(TokenService tokenSer){
        this.tokenSer = tokenSer;
    }



}
