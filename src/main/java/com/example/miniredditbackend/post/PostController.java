package com.example.miniredditbackend.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private PostService postSer;

    @Autowired
    public PostController(PostService postSer){
         this.postSer = postSer;
    }

    @PostMapping("/post")
    public void createPost(@RequestBody PostModel newPost, HttpServletResponse response){
        postSer.createPost(new Posts(newPost.getTitle(), newPost.getAuthor(), newPost.getDate(), newPost.getMessage()));
    }


}
