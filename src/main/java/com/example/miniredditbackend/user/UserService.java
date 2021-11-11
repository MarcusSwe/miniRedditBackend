package com.example.miniredditbackend.user;
import com.example.miniredditbackend.token.Token;
import com.example.miniredditbackend.token.TokenRepo;
import com.example.miniredditbackend.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserSer{

    private UserRepo userRep;
    private TokenService tokenSer;

    @Autowired
    public UserService(UserRepo userRep, TokenService tokenSer){
        this.userRep = userRep;
        this.tokenSer = tokenSer;
    }

    @Override
    //@Transactional("tm2")
    public int createUser(User user){

        ArrayList<User> x = userRep.findByName(user.getName());

        if(x.size() >0){
            System.out.println("user exists");
            return 0;
        } else {
            userRep.save(user);System.out.println("user created");
            return 1;
        }
    }

    @Override
    public String loginUser(User user){

        ArrayList<User> y = userRep.findByNameAndPassword(user.getName(), user.getPassword());

        if(y.size() >0){
            System.out.println("correct password");
            String token = UUID.randomUUID().toString();
            tokenSer.createToken(new Token(token,user.getName()));
            return token;

        } else System.out.println("wrong password");return null;

    }

    @Override
    public void logoff(Token token){
        tokenSer.removeToken(token);
    }

}
