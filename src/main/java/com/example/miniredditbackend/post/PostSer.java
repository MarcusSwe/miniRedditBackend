package com.example.miniredditbackend.post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface PostSer {

    Posts createPost(Posts posts, String token);
    List<PostDTO> getAllPosts();
    void voteUp(String token, long id);
    void voteDown(String token, long id);
    int createComment(String commentAuthor, String comment, String date, long id, String token);
    boolean deletePost(String token, long id);
    boolean editPost(String token, long id, String comment, String title);
    boolean deleteComment(String token, long id);
    boolean editComment(String token, long idcomment, String comment);
    PostDTO getPost(long x);
    List<commentDTO> getComments(long x);
}
