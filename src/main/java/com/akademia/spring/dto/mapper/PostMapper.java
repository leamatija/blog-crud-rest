package com.akademia.spring.dto.mapper;

import com.akademia.spring.dto.CategoryDTO;
import com.akademia.spring.dto.PostDTO;
import com.akademia.spring.entity.Post;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class PostMapper {

    public static PostDTO toDto(Post p){
        List<CategoryDTO> categoryDTOS =p.getCategories().stream().map(c->CategoryMapper.toDto(c)).collect(Collectors.toList());
        return PostDTO.builder()
                .id(p.getId())
                .body(p.getBody())
                .title(p.getTitle())
                .categories(categoryDTOS)
                .build();
    }

}
