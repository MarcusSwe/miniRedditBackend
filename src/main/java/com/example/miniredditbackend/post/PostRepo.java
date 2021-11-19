package com.example.miniredditbackend.post;

import com.example.miniredditbackend.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Posts, Long> {

List<Posts> findAll();

}
