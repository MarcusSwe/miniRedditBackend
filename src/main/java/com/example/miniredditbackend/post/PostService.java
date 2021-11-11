package com.example.miniredditbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostService implements PostSer{

    private PostRepo postRep;
    private CommentRepo commentRep;

    @Autowired
    public PostService(PostRepo postRep, CommentRepo te){
        this.postRep = postRep;
        this.commentRep = te;
    }

    @Override
    public Posts createPost(Posts posts){

       postRep.deleteById(31);
       //7410   System.out.println(y);

//postRep.save(y);

   // Comments c = new Comments("test","sdafgsdfgdfdfgsdg","sdfgaf",y);
     //     commentRep.save(c);


        return postRep.save(posts);
    }

    public List<PostDTO> getAllPosts(){
        List<Posts> y = postRep.findAll();

        return y.stream().map(x -> new PostDTO(x.getTitle(), x.getAuthor(), x.getDate(), x.getMessage(),
                x.getId(), x.getUpvote(), x.getDownvote(), "/post/"+x.getId())).collect(Collectors.toList());
    }

    public PostDTO getPost(int x){
        Posts z = postRep.findById(Integer.valueOf(x)).get();

        return new PostDTO(z.getTitle(), z.getAuthor(), z.getDate(), z.getMessage(), z.getId(), z.getUpvote(), z.getDownvote(),
                "/post" +z.getId());

    }

}
