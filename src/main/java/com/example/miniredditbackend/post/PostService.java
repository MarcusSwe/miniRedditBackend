package com.example.miniredditbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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



       Posts y = postRep.findById(Integer.valueOf(31)).get();
          System.out.println(y);

    Comments c = new Comments("test","sdafgsdfgsdg","saf",y);
          commentRep.save(c);


        return postRep.save(posts);
    }

}
