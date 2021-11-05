package com.example.miniredditbackend.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class UserService {

    private UserRepo userRep;

    @Autowired
    public UserService(UserRepo userRep){
        this.userRep = userRep;
    }

    public User createUser(User user){
        return userRep.save(user);
    }

}
