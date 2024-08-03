package com.task.user.controller;

import com.task.user.entity.Post;
import com.task.user.handler.HandleData;
import com.task.user.response.PostResponse;
import com.task.user.serviceInterface.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/posts")
public class postController {
    @Autowired
    PostService postService;
    @Autowired
    HandleData handleData;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(){
        List<Post> postData = postService.getAllPost();
        List<PostResponse> allPosts = handleData.preparePostResponse(postData);
        return ResponseEntity.ok(allPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getProductById(@PathVariable Long id){
        Post postData = postService.getPostById(id);
        PostResponse post = handleData.preparePostResponse(postData);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<String> insertProduct(@RequestBody Post post){

        Post insertedPostData = postService.addPost(post);
        if(Objects.isNull(insertedPostData)){
            return ResponseEntity.ok("Post not added");
        }else{
            return ResponseEntity.ok("Post Created");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id,@RequestBody Post post){
        Post updatedtedPostData = postService.updatePost(id,post);
        if(Objects.isNull(updatedtedPostData)){
            return ResponseEntity.ok("Post not updated");
        }else{
            return ResponseEntity.ok("Post updated");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteProduct(@PathVariable Long id,@RequestBody Post post){
        Post updatedtedPostData = postService.deletePost(id, post);

        if(Objects.isNull(updatedtedPostData)){
            return ResponseEntity.ok("Post not deleted");
        }else{
            return ResponseEntity.ok("Post deleted");
        }
    }
}
