package com.example.miniredditbackend.token;

import com.example.miniredditbackend.user.User;
import com.example.miniredditbackend.user.UserRepo;
import com.example.miniredditbackend.user.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
