package com.example.miniredditbackend.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}