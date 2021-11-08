package com.example.miniredditbackend.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserSer{

    private UserRepo userRep;

    @Autowired
    public UserService(UserRepo userRep){
        this.userRep = userRep;
    }

    @Override
    @Transactional("tm2")
    public User createUser(User user){

        return userRep.save(user);
    }
}
