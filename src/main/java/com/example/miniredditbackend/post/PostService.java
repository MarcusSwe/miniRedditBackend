package com.example.miniredditbackend.post;

import com.example.miniredditbackend.token.TokenService;
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
    private TokenService tokenSer;

    @Autowired
    public PostService(PostRepo postRep, CommentRepo te, TokenService tokenSer){
        this.postRep = postRep;
        this.commentRep = te;
        this.tokenSer = tokenSer;
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

    @Override
    public List<PostDTO> getAllPosts(){
        List<Posts> y = postRep.findAll();

        return y.stream().map(x -> new PostDTO(x.getTitle(), x.getAuthor(), x.getDate(), x.getMessage(),
                x.getId(), x.getUpvote(), x.getDownvote(), "/post/"+x.getId())).collect(Collectors.toList());
    }

    public PostDTO getPost(int x){
        try {
        Posts z = postRep.findById(x).get();
            return new PostDTO(z.getTitle(), z.getAuthor(), z.getDate(), z.getMessage(), z.getId(), z.getUpvote(), z.getDownvote(),
                    "/post" +z.getId());
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public void voteUp(String token, int id){

        if(tokenSer.check(token)){

            int y = postRep.findById(id).get().getUpvote();
            y++;
            Posts x = postRep.findById(id).get();
            x.setUpvote(y);
            postRep.save(x);

        }
    }

    @Override
    public void voteDown(String token, int id){

        if(tokenSer.check(token)){

            int y = postRep.findById(id).get().getDownvote();
            y++;
            Posts x = postRep.findById(id).get();
            x.setDownvote(y);
            postRep.save(x);

        }
    }

    @Override
    public void createComment(String commentAuthor, String comment, String date, int id, String token){

        if(tokenSer.check(token)){

            Posts p = postRep.findById(id).get();
            Comments c = new Comments(commentAuthor, comment, date, p);

            commentRep.save(c);

        }

    }


}
