package com.akademia.spring.controller;

import com.akademia.spring.dto.PostDTO;
import com.akademia.spring.dto.UserDTO;
import com.akademia.spring.dto.UserPostDTO;
import com.akademia.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser (@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id,
                                              @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUser(id,userDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<UserPostDTO>getUserPosts(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserPosts(id));
    }

    @GetMapping("/{id}/posts/{postId}")
    public ResponseEntity<UserPostDTO> getUserPostById(@PathVariable Integer id,
                                                        @PathVariable Integer postId){
        return ResponseEntity.ok(userService.getUserPostById(id,postId));
    }
    @PostMapping("/{id}/posts")
    public ResponseEntity<UserPostDTO> addUserPost(@PathVariable Integer id,
                                                   @RequestBody PostDTO postDTO){
        return ResponseEntity.ok(userService.addUserPost(id, postDTO));
    }

    @DeleteMapping("/{id}/posts/{postId}")
    public ResponseEntity<Void> deleteUserPost(@PathVariable Integer postId){
        userService.deleteUserPost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
