package com.example.miniredditbackend.post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface PostSer {

    Posts createPost(Posts posts, String token);
    List<PostDTO> getAllPosts();
    void voteUp(String token, int id);
    void voteDown(String token, int id);
    int createComment(String commentAuthor, String comment, String date, int id, String token);
    boolean deletePost(String token, int id);
    boolean editPost(String token, int id, String comment, String title);
    boolean deleteComment(String token, int id);
    boolean editComment(String token, int idcomment, String comment);
    PostDTO getPost(int x);
    List<commentDTO> getComments(int x);
}
