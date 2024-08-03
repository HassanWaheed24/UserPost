package com.task.user.serviceImpl;

import com.task.user.entity.Post;
import com.task.user.entity.User;
import com.task.user.repository.PostRepository;
import com.task.user.repository.UserRepository;
import com.task.user.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Override
    public List<User> getAllUser() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUserByName(String name){
        return (List<User>) userRepository.findByUserName(name);
    }

    @Override
    public User addUser(User user) {
        Optional<User> existingUserByEmail = userRepository.findByEmail(user.getEmail());
        List<User> existingUserByUsername = userRepository.findByUserName(user.getUserName());

        if (existingUserByEmail.isPresent()) {
            throw new IllegalArgumentException("Email already in use.");
        }
        if (!existingUserByUsername.isEmpty()) {
            throw new IllegalArgumentException("Username already in use.");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setStatus(user.getStatus());
        userRepository.save(updatedUser);
        return updatedUser;
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Post> posts = user.getPosts();

            postRepository.deleteAll(posts);
            userRepository.deleteById(id);
            return user;
        } else {
            throw new IllegalArgumentException("User with id " + id + " not found.");
        }
    }

}
