package com.example.miniredditbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/post")
public class PostController {

    private PostService postSer;

    @Autowired
    public PostController(PostService postSer){
         this.postSer = postSer;
    }

    @GetMapping("/all")
    public List<PostDTO> getPosts(){
        return postSer.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable("id") int id){
        return postSer.getPost(id);
    }

    @PostMapping("/newpost")
    public void createPost(@RequestBody PostModel newPost, @RequestHeader("token") String token,  HttpServletResponse response){
        postSer.createPost(new Posts(newPost.getTitle(), newPost.getAuthor(), newPost.getDate(), newPost.getMessage()), token);
    }

    @PutMapping("/voteup")
    public void voteUp(@RequestHeader("token") String token, @RequestHeader("id") int id, HttpServletResponse response){
        //System.out.println(token, id);
        postSer.voteUp(token, id);
    }

    @PutMapping("/votedown")
    public void voteDown(@RequestHeader("token") String token, @RequestHeader("id") int id, HttpServletResponse response){
        postSer.voteDown(token, id);
    }

    @PostMapping("/newcomment")
    public void newComment(@RequestBody CommentModel newComment, @RequestHeader("token") String token,
                           @RequestHeader("id") int id, HttpServletResponse response){
        postSer.createComment(newComment.getCommentAuthor(), newComment.getComment(), newComment.getDate(), id, token);
    }

    @DeleteMapping("/postdelete")
    public void deletePost(@RequestHeader("token") String token, @RequestHeader("id") int id,
                              HttpServletResponse response){
        postSer.deletePost(token, id);
    }

    @DeleteMapping("/commentdelete")
    public void deleteComment(@RequestHeader("token") String token, @RequestHeader("id") int id,
                           HttpServletResponse response){
        postSer.deleteComment(token, id);
    }

    @PutMapping("/updatepost")
    public void updatePost(@RequestHeader("token") String token, @RequestHeader("id") int id,
            @RequestBody EditPostModel editpost
            , HttpServletResponse response){
        postSer.editPost(token, id, editpost.getMessage(), editpost.getTitle());
    }

    @PutMapping("/updatecomment")
    public void updateComment(@RequestHeader("token") String token, @RequestHeader("idcomment") int idcomment,
                           @RequestBody String editcomment,HttpServletResponse response){
        postSer.editComment(token, idcomment, editcomment);
    }

    @GetMapping("/getcomments")
    public List<commentDTO> getCommentsByPost(@RequestHeader("idpost") int idpost, HttpServletResponse response){
        return postSer.getComments(idpost);
    }

}
