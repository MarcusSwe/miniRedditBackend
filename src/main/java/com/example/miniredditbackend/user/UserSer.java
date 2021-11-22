package com.example.miniredditbackend.user;

import com.example.miniredditbackend.token.Token;
import com.example.miniredditbackend.user.User;

public interface UserSer {

    int createUser(User user);
    String loginUser(User user);
    void logoff(Token token);
    String checkAuth(String token);
}
