package com.task.user.controller;

import com.task.user.entity.User;
import com.task.user.handler.HandleData;
import com.task.user.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import com.task.user.response.UserResponse;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    UserService userService;
    @Autowired
    HandleData handleData;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userService.getAllUser();
        List<UserResponse> allUsers = handleData.prepareUserResponse(users);
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserResponse>> getUserByName(@PathVariable String name)
    {
        List<User> users = userService.getUserByName(name);
        List<UserResponse> allUsers = handleData.prepareUserResponse(users);
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id)
    {
        User users = userService.getUserById(id);
        UserResponse allUsers = handleData.prepareUserResponse(users);
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
        User createdUser = userService.addUser(user);
        if (!Objects.isNull(createdUser)){
            return ResponseEntity.ok("User Created");
        }else{
            return ResponseEntity.ok("User Not Created");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user){
        User updatedUser = userService.updateUser(id,user);
        if (!Objects.isNull(updatedUser)){
            return ResponseEntity.ok("User Updated");
        }else{
            return ResponseEntity.ok("User Not Updated");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteUser(@PathVariable Long id){
        User deletedUser = userService.deleteUser(id);
        if (!Objects.isNull(deletedUser)){
            return ResponseEntity.ok("User Deleted");
        }else{
            return ResponseEntity.ok("User Not Deleted");
        }
    }

}
