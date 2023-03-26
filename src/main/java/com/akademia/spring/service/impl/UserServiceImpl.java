package com.akademia.spring.service.impl;

import com.akademia.spring.dto.PostDTO;
import com.akademia.spring.dto.UserDTO;
import com.akademia.spring.dto.UserPostDTO;
import com.akademia.spring.dto.mapper.PostMapper;
import com.akademia.spring.dto.mapper.UserMapper;
import com.akademia.spring.entity.Post;
import com.akademia.spring.entity.User;
import com.akademia.spring.exception.NotFoundException;
import com.akademia.spring.repository.PostRepository;
import com.akademia.spring.repository.UserRepository;
import com.akademia.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(u-> UserMapper.toDto(u))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id)
                .map(user -> UserMapper.toDto(user)).orElseThrow(()->new NotFoundException("This user can not be found!"));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user= userRepository.save(UserMapper.toEntity(userDTO));
        return UserMapper.toDto(user);
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDTO.getUsername());
                    user.setEmail(userDTO.getEmail());
                    return user;
                }).map(userRepository::save)
                .map(UserMapper::toDto)
                .orElseThrow(()->new NotFoundException("This user can not be found!"));

    }

    @Override
    public void deleteUserById(Integer id) {
        UserDTO userDTO=getUserById(id);
        userRepository.deleteById(id);

    }


    @Override
    public UserPostDTO getUserPosts(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User not found"));
        List<PostDTO> postDTOS = user.getPosts().stream()
                .map(p-> PostMapper.toDto(p))
                .collect(Collectors.toList());

        UserPostDTO dto = UserPostDTO.builder()
                .userDTO(UserMapper.toDto(user))
                .posts(postDTOS)
                .build();

        return dto;
    }

    @Override
    public UserPostDTO getUserPostById(Integer userId,Integer postId) {
        User user =userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User not found"));

        Post post = user.getPosts().stream()
                .filter(p -> p.getId()==postId)
                .findFirst()
                .orElse(null);
        UserPostDTO dto = UserPostDTO.builder()
                .userDTO(UserMapper.toDto(user))
                .posts(Arrays.asList(PostMapper.toDto(post)))
                .build();
        return dto;
    }

    @Override
    public UserPostDTO addUserPost(Integer id, PostDTO postDTO) {
        User user =userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found"));
        Post p = new Post();
        p.setTitle(postDTO.getTitle());
        p.setBody(postDTO.getBody());
        p.setUser(user);
        p=postRepository.save(p);

        UserPostDTO dto = UserPostDTO.builder()
                .userDTO(UserMapper.toDto(user))
                .posts(Arrays.asList(PostMapper.toDto(p)))
                .build();
        return dto;
    }
    //gabime
    @Override
    public void deleteUserPost(Integer postId) {
        postRepository.deleteById(postId);
    }
}
