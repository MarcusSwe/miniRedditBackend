package com.example.miniredditbackend.post;

import com.example.miniredditbackend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VoteNamesRepo extends JpaRepository<VoteNames, Long> {

    VoteNames findByVotenamesAndPosts(String voter, Posts y);
}

