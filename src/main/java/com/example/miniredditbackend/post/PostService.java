package com.example.miniredditbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostSer{

    private PostRepo postRep;

    @Autowired
    public PostService(PostRepo postRep){
        this.postRep = postRep;
    }

    @Override
    public Posts createPost(Posts posts){

        return postRep.save(posts);
    }

}
