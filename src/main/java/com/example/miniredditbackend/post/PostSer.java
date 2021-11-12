package com.example.miniredditbackend.post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface PostSer {

    Posts createPost(Posts posts, String token);
    List<PostDTO> getAllPosts();
    void voteUp(String token, int id);
    void voteDown(String token, int id);
    void createComment(String commentAuthor, String comment, String date, int id, String token);
    void deletePost(String token, int id);
    void editPost(String token, int id, String comment, String title);
    void deleteComment(String token, int id);
    void editComment(String token, int idcomment, String comment);
    PostDTO getPost(int x);
}
