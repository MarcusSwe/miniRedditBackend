package com.example.miniredditbackend.token;

import com.example.miniredditbackend.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {

    ArrayList<Token> findByToken(String token);

}
