package com.example.miniredditbackend.post;

import com.example.miniredditbackend.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService implements PostSer{

    private PostRepo postRep;
    private CommentRepo commentRep;
    private TokenService tokenSer;
    private VoteNamesRepo votesRep;

    @Autowired
    public PostService(PostRepo postRep, CommentRepo te, TokenService tokenSer, VoteNamesRepo votesRep){
        this.postRep = postRep;
        this.commentRep = te;
        this.tokenSer = tokenSer;
        this.votesRep = votesRep;
    }

    @Override
    public Posts createPost(Posts posts, String token){
        if(tokenSer.check(token)){
            String x = tokenSer.checkNameWithToken(token);
            if(x.equals(posts.getAuthor())){
                return postRep.save(posts);
            }
        }
          return null;
    }

    @Override
    public List<PostDTO> getAllPosts(){
        List<Posts> y = postRep.findAll();
        return y.stream().map(x -> new PostDTO(x.getTitle(), x.getAuthor(), x.getDate(), x.getMessage(),
                x.getId(), x.getUpvote(), x.getDownvote(), "/post/"+x.getId())).collect(Collectors.toList());
    }

    @Override
    public List<commentDTO> getComments(int i){
        List<Comments> y = commentRep.findAllByPosts(postRep.findById(i).get());
        return y.stream().map(x -> new commentDTO(x.getCommentAuthor(), x.getComment(), x.getDate(), x.getId())).collect(Collectors.toList());
    }

    @Override
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

            if(postRep.findById(id).isPresent()) {
                Posts x = postRep.findById(id).get();
                int y = postRep.findById(id).get().getUpvote();
                int z = postRep.findById(id).get().getDownvote();

                try{
                    votesRep.findByVotenamesAndPosts(tokenSer.checkNameWithToken(token), x).getId();
                    VoteNames v = votesRep.findByVotenamesAndPosts(tokenSer.checkNameWithToken(token), x);
                    String w = v.getWhatvote();

                    if(w.equals("up")){
                     votesRep.deleteById(v.getId());
                     y--;
                     x.setUpvote(y);
                     postRep.save(x);
                    }else{
                        z--;
                        y++;
                        v.setWhatvote("up");
                        x.setDownvote(z);
                        x.setUpvote(y);
                        votesRep.save(v);
                        postRep.save(x);
                    }
                }catch(Exception e){
                    System.out.println("finns ej");
                    y++;
                    x.setUpvote(y);
                    VoteNames addvoter = new VoteNames(tokenSer.checkNameWithToken(token), "up",x);
                    votesRep.save(addvoter);
                    postRep.save(x);
                }
            }
        }
    }

    @Override
    public void voteDown(String token, int id){

        if(tokenSer.check(token)) {

            if (postRep.findById(id).isPresent()) {
                Posts x = postRep.findById(id).get();
                int y = postRep.findById(id).get().getDownvote();
                int z = postRep.findById(id).get().getUpvote();

                try {
                    votesRep.findByVotenamesAndPosts(tokenSer.checkNameWithToken(token), x).getId();
                    VoteNames v = votesRep.findByVotenamesAndPosts(tokenSer.checkNameWithToken(token), x);
                    String w = v.getWhatvote();

                    if (w.equals("down")) {
                        votesRep.deleteById(v.getId());
                        y--;
                        x.setDownvote(y);
                        postRep.save(x);
                    } else {
                        z--;
                        y++;
                        v.setWhatvote("down");
                        x.setUpvote(z);
                        x.setDownvote(y);
                        postRep.save(x);
                        votesRep.save(v);
                    }
                } catch (Exception e) {
                    System.out.println("finns ej");
                    y++;
                    x.setDownvote(y);
                    VoteNames addvoter = new VoteNames(tokenSer.checkNameWithToken(token), "down", x);
                    votesRep.save(addvoter);
                    postRep.save(x);
                }
            }
        }
    }

    @Override
    public void createComment(String commentAuthor, String comment, String date, int id, String token){
        if(tokenSer.check(token)){
            String x = tokenSer.checkNameWithToken(token);
            if(x.equals(commentAuthor)){
                Posts p = postRep.findById(id).get();
                Comments c = new Comments(commentAuthor, comment, date, p);
                commentRep.save(c);
            }
        }
    }

    @Override
    public void deletePost(String token, int id){
        if(tokenSer.check(token)){
            Posts p = postRep.findById(id).get();
            String x = tokenSer.checkNameWithToken(token);
            if(x.equals(p.getAuthor())){
                postRep.deleteById(id);
            }
        }
    }

    @Override
    public void deleteComment(String token, int id){
         if(tokenSer.check(token)){
            Comments o = commentRep.findById(id).get();
            String x = tokenSer.checkNameWithToken(token);
            if(x.equals(o.getCommentAuthor())){
                commentRep.deleteById(id);
            }
        }
    }



    @Override
    public void editPost(String token, int id, String comment, String title){
        if(tokenSer.check(token)){
            Posts o = postRep.findById(id).get();
            String x = tokenSer.checkNameWithToken(token);
            if(x.equals(o.getAuthor())){
                o.setMessage(comment);
                o.setTitle(title);
                postRep.save(o);
            }
        }
    }

    @Override
    public void editComment(String token, int idcomment, String comment){
        if(tokenSer.check(token)){
            Comments o = commentRep.findById(idcomment).get();
            String x = tokenSer.checkNameWithToken(token);
            if(x.equals(o.getCommentAuthor())){
                o.setComment(comment);
                commentRep.save(o);
            }
        }
    }

}
