package com.akademia.spring.dto.mapper;

import com.akademia.spring.dto.UserDTO;
import com.akademia.spring.entity.User;

public class UserMapper {

    public static UserDTO toDto(User u){
        return UserDTO.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .build();
    }
    public static User toEntity(UserDTO u){
        return User.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .build();
    }
}
