package com.example.miniredditbackend.post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface PostSer {

    Posts createPost(Posts posts);
    List<PostDTO> getAllPosts();
    void voteUp(String token, int id);
    void voteDown(String token, int id);
}
