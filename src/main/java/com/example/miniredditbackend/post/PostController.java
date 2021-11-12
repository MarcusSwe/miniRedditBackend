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
    public String createPost(@RequestBody PostModel newPost, @RequestHeader("token") String token,  HttpServletResponse response){
        if(postSer.createPost(new Posts(newPost.getTitle(), newPost.getAuthor(), newPost.getDate(), newPost.getMessage()), token) == null){
            response.setStatus(409);
            return "User not logged in or something else went wrong!";
        } else return "Post created!";
    }

    @PutMapping("/voteup")
    public void voteUp(@RequestHeader("token") String token, @RequestHeader("id") int id){
        postSer.voteUp(token, id);
    }

    @PutMapping("/votedown")
    public void voteDown(@RequestHeader("token") String token, @RequestHeader("id") int id){
        postSer.voteDown(token, id);
    }

    @PostMapping("/newcomment")
    public String newComment(@RequestBody CommentModel newComment, @RequestHeader("token") String token,
                           @RequestHeader("id") int id, HttpServletResponse response){
       if(postSer.createComment(newComment.getCommentAuthor(), newComment.getComment(), newComment.getDate(), id, token) > 1){
            response.setStatus(409);
            return "User not logged in or something else went wrong!";
       }else return "Comment created!";
    }

    @DeleteMapping("/postdelete")
    public String deletePost(@RequestHeader("token") String token, @RequestHeader("id") int id,
                              HttpServletResponse response){
        if(postSer.deletePost(token, id)){
            return "Post deleted!";
        }else {
            response.setStatus(409);
            return "Post dont exist or something else went wrong!";
        }

    }

    @DeleteMapping("/commentdelete")
    public String deleteComment(@RequestHeader("token") String token, @RequestHeader("id") int id,
                           HttpServletResponse response){
        if(postSer.deleteComment(token, id)){
            return "Comment deleted!";
        }else{
            response.setStatus(409);
            return "Comment dont exist or something else went wrong!";
        }
    }

    @PutMapping("/updatepost")
    public String updatePost(@RequestHeader("token") String token, @RequestHeader("id") int id,
            @RequestBody EditPostModel editpost
            , HttpServletResponse response){
        if(postSer.editPost(token, id, editpost.getMessage(), editpost.getTitle())){
            return "Post updated!";
        }else{
            response.setStatus(409);
            return "Something went wrong or not owner to post!";
        }
    }

    @PutMapping("/updatecomment")
    public String updateComment(@RequestHeader("token") String token, @RequestHeader("idcomment") int idcomment,
                           @RequestBody String editcomment,HttpServletResponse response){
        if(postSer.editComment(token, idcomment, editcomment)){
            return "Comment updated!";
        }else{
            response.setStatus(409);
            return "Something went wrong or not owner to comment!";
        }
    }

    @GetMapping("/getcomments")
    public List<commentDTO> getCommentsByPost(@RequestHeader("idpost") int idpost, HttpServletResponse response){
        return postSer.getComments(idpost);
    }

}
