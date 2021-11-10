package com.example.miniredditbackend.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserSer{

    private UserRepo userRep;

    @Autowired
    public UserService(UserRepo userRep){
        this.userRep = userRep;
    }

    @Override
    //@Transactional("tm2")
    public User createUser(User user){

        ArrayList<User> x = userRep.findByName(user.getName());
        ArrayList<User> y = userRep.findByNameAndPassword(user.getName(), user.getPassword());

        if(x.size() >0){
            System.out.println("user exists");
        } else System.out.println("user created");

        if(y.size() >0){
            System.out.println("correct password");
        } else System.out.println("wrong password");


        return userRep.save(user);

    }
}
