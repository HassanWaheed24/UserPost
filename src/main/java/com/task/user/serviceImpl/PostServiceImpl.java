package com.task.user.serviceImpl;

import com.task.user.entity.Post;
import com.task.user.entity.User;
import com.task.user.repository.PostRepository;
import com.task.user.repository.UserRepository;
import com.task.user.serviceInterface.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Post> getAllPost() {
        return new ArrayList<>(postRepository.findAll());
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post addPost(Post post) {
        Long userId = post.getAuthor().getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Post> existingPostByTitle = postRepository.findByTitle(post.getTitle());

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User with id " + userId + " not found.");
        }
        if (existingPostByTitle.isPresent()) {
            throw new IllegalArgumentException("Post with title " + post.getTitle() + " already exists.");
        }

        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post updatedPost) {
        Optional<Post> postOptional = postRepository.findById(id);

        Post existingPost = new Post();
        if (postOptional.isPresent()) {
            existingPost = postOptional.get();
            if (updatedPost.getAuthor() == null || updatedPost.getAuthor().getUserId() == null) {
                throw new IllegalArgumentException("Author information is required to update the post.");
            }
            Long userIdOfOriginalAuthor = existingPost.getAuthor().getUserId();
            Long userIdOfUpdater = updatedPost.getAuthor().getUserId();

            if (userIdOfOriginalAuthor.equals(userIdOfUpdater)) {
                if (updatedPost.getTitle() != null) {
                    existingPost.setTitle(updatedPost.getTitle());
                }
                if (updatedPost.getContent() != null) {
                    existingPost.setContent(updatedPost.getContent());
                }
                if (updatedPost.getStatus() != null) {
                    existingPost.setStatus(updatedPost.getStatus());
                }

                postRepository.save(existingPost);
            } else {
                throw new IllegalArgumentException("You are not authorized to update this post.");
            }
        } else {
            throw new IllegalArgumentException("Post with id " + id + " not found.");
        }
        return existingPost;
    }


    @Override
    public Post deletePost(Long id, Post post) {
        Optional<Post> postOptional = postRepository.findById(id);

        Post existingPost = new Post();
        if (postOptional.isPresent()) {
            existingPost = postOptional.get();
            Long userIdOfOriginalAuthor = existingPost.getAuthor().getUserId();

            if (userIdOfOriginalAuthor.equals(post.getAuthor().getUserId())) {
                postRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("You are not authorized to delete this post.");
            }
        } else {
            throw new IllegalArgumentException("Post with id " + id + " not found.");
        }
        return existingPost;
    }

}
