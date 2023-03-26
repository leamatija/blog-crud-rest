package com.akademia.spring.service;


import com.akademia.spring.dto.PostDTO;
import com.akademia.spring.dto.UserDTO;
import com.akademia.spring.dto.UserPostDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUserById(Integer id);
    UserDTO addUser(UserDTO userDTO);
    UserDTO updateUser(Integer id, UserDTO userDTO);
    void deleteUserById(Integer id);
    UserPostDTO getUserPosts(Integer userId);
    UserPostDTO getUserPostById(Integer userId, Integer postId);
    UserPostDTO addUserPost (Integer id, PostDTO postDTO);
    void deleteUserPost(Integer postId);



}
