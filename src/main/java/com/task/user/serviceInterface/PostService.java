package com.task.user.serviceInterface;

import com.task.user.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();
    Post getPostById(Long id);
    Post addPost(Post post);
    Post updatePost(Long id, Post post);
    Post deletePost(Long id, Post post);
}
