package com.example.miniredditbackend.token;

import com.example.miniredditbackend.user.User;
import com.example.miniredditbackend.user.UserRepo;
import com.example.miniredditbackend.user.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class TokenService implements TokenSer {

    private TokenRepo tokenRep;

    @Autowired
    public TokenService(TokenRepo tokenRep){
        this.tokenRep = tokenRep;
    }

    @Override
    //@Transactional("tm3")
    public Token createToken(Token token){

        return tokenRep.save(token);
    }

    @Override
    public void removeToken(Token token){
        ArrayList<Token> x = tokenRep.findByToken(token.getToken());
        if(x.size() >0){
           int y =  x.get(0).getId();
           tokenRep.deleteById(y);
        }
    }
}
