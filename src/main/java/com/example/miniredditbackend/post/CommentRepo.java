package com.example.miniredditbackend.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Integer>{

    List<Comments> findAll();
    List<Comments> findAllByPosts(Posts x);

}


