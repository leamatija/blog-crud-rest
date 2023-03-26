package com.akademia.spring.dto;

import com.akademia.spring.entity.Category;
import com.akademia.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private Integer id;
    private String title;
    private String body;
    private User user;
    private List<CategoryDTO> categories;
}
