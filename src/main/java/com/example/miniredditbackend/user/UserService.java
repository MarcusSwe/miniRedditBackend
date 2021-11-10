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

        if(x.size() >0){
            System.out.println("user exists");
        } else System.out.println("user created");

        return userRep.save(user);

    }
}
