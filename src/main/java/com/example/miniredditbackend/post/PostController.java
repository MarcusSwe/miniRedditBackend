package com.example.miniredditbackend.post;


import com.example.miniredditbackend.token.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/post")
public class PostController {

    private PostService postSer;

    @Autowired
    public PostController(PostService postSer){
         this.postSer = postSer;
    }

    @PostMapping("/newpost")
    public void createPost(@RequestBody PostModel newPost, @RequestHeader("token") String token,  HttpServletResponse response){
        postSer.createPost(new Posts(newPost.getTitle(), newPost.getAuthor(), newPost.getDate(), newPost.getMessage()));
    }

    @PutMapping("/voteup")
    public void voteUp(@RequestBody VoteModelUp newVote, @RequestHeader("token") String token, HttpServletResponse response){

    }

    @PutMapping("/votedown")
    public void voteDown(@RequestBody VoteModelDown newVote, @RequestHeader("token") String token, HttpServletResponse response){

    }


}
