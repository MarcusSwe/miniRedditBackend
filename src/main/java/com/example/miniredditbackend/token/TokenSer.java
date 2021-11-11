package com.example.miniredditbackend.token;



public interface TokenSer {

    Token createToken(Token token);
    void removeToken(Token token);
    boolean check(String token);
    String checkNameWithToken(String token);
}
