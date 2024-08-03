package com.task.user.handler;

import com.task.user.dto.PostDTO;
import com.task.user.entity.Post;
import com.task.user.entity.User;
import com.task.user.response.PostResponse;
import com.task.user.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

@Component
public class HandleData {
    public List<UserResponse> prepareUserResponse(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        if (users.isEmpty()) {
            userResponses.add(new UserResponse("NF", "No Record Found"));
        } else {
            for (User user : users) {
                UserResponse response = new UserResponse("00", "Request Successful");
                response.setUserId(user.getUserId());
                response.setUserName(user.getUserName());
                response.setEmail(user.getEmail());
                response.setPassword(user.getPassword());
                response.setName(user.getName());
                response.setDateOfBirth(user.getDateOfBirth());
                response.setGender(user.getGender());
                response.setPhoneNumber(user.getPhoneNumber());
                response.setAddressStreet(user.getAddressStreet());
                response.setAddressCity(user.getAddressCity());
                response.setAddressStateProvince(user.getAddressStateProvince());
                response.setAddressPostalCode(user.getAddressPostalCode());
                response.setAddressCountry(user.getAddressCountry());
                response.setProfilePictureUrl(user.getProfilePictureUrl());
                response.setRole(user.getRole());
                response.setRegistrationDate(user.getRegistrationDate());
                response.setLastLoginDate(user.getLastLoginDate());
                response.setStatus(user.getStatus());
                response.setBlock(user.getBlock());

                List<PostDTO> postDTOs = new ArrayList<>();
                for (Post post : user.getPosts()) {
                    PostDTO postDTO = new PostDTO();
                    postDTO.setId(post.getId());
                    postDTO.setTitle(post.getTitle());
                    postDTO.setContent(post.getContent());
                    postDTO.setCreatedDate(post.getCreatedDate());
                    postDTO.setUpdatedDate(post.getUpdatedDate());
                    postDTO.setStatus(post.getStatus());
                    postDTOs.add(postDTO);
                }
                response.setPosts(postDTOs);
                userResponses.add(response);
            }
        }
        return userResponses;
    }


    public List<PostResponse> preparePostResponse(List<Post> posts) {
        List<PostResponse> userResponses = new ArrayList<>();
        PostDTO postDTO = new PostDTO();
        if (posts.isEmpty()) {
            userResponses.add(new PostResponse("NF", "No Record Found"));
        } else {
            for (Post post : posts) {
                PostResponse response = new PostResponse("00", "Request Successful");
                response.setId(post.getId());
                response.setTitle(post.getTitle());
                response.setContent(post.getContent());
                response.setCreatedDate(post.getCreatedDate());
                response.setUpdatedDate(post.getUpdatedDate());
                response.setStatus(post.getStatus());

                User author = new User();
                author.setUserId(post.getAuthor().getUserId());
                author.setUserName(post.getAuthor().getUserName());

                response.setAuthor(author);
                userResponses.add(response);
            }
        }
        return userResponses;
    }

    public UserResponse prepareUserResponse(User user) {
        if (Objects.isNull(user)) {
           return new UserResponse("NF", "No Record Found");
        } else {

                UserResponse response = new UserResponse("00", "Request Successful");
                response.setUserId(user.getUserId());
                response.setUserName(user.getUserName());
                response.setEmail(user.getEmail());
                response.setPassword(user.getPassword());
                response.setName(user.getName());
                response.setDateOfBirth(user.getDateOfBirth());
                response.setGender(user.getGender());
                response.setPhoneNumber(user.getPhoneNumber());
                response.setAddressStreet(user.getAddressStreet());
                response.setAddressCity(user.getAddressCity());
                response.setAddressStateProvince(user.getAddressStateProvince());
                response.setAddressPostalCode(user.getAddressPostalCode());
                response.setAddressCountry(user.getAddressCountry());
                response.setProfilePictureUrl(user.getProfilePictureUrl());
                response.setRole(user.getRole());
                response.setRegistrationDate(user.getRegistrationDate());
                response.setLastLoginDate(user.getLastLoginDate());
                response.setStatus(user.getStatus());
                response.setBlock(user.getBlock());

                List<PostDTO> postDTOs = new ArrayList<>();
                for (Post post : user.getPosts()) {
                    PostDTO postDTO = new PostDTO();
                    postDTO.setId(post.getId());
                    postDTO.setTitle(post.getTitle());
                    postDTO.setContent(post.getContent());
                    postDTO.setCreatedDate(post.getCreatedDate());
                    postDTO.setUpdatedDate(post.getUpdatedDate());
                    postDTO.setStatus(post.getStatus());
                    postDTOs.add(postDTO);
                }
                response.setPosts(postDTOs);
                return response;
            }
    }

    public PostResponse preparePostResponse(Post post) {
        List<PostResponse> userResponses = new ArrayList<>();
        PostDTO postDTO = new PostDTO();
        if (Objects.isNull(post)) {
            return new PostResponse("NF", "No Record Found");
        } else {
                PostResponse postResponse = new PostResponse("00", "Request Successful");
            postResponse.setId(post.getId());
            postResponse.setTitle(post.getTitle());
            postResponse.setContent(post.getContent());
            postResponse.setCreatedDate(post.getCreatedDate());
            postResponse.setUpdatedDate(post.getUpdatedDate());
            postResponse.setStatus(post.getStatus());

                User author = new User();
                author.setUserId(post.getAuthor().getUserId());
                author.setUserName(post.getAuthor().getUserName());

            postResponse.setAuthor(author);
            return postResponse;
            }
    }

}


