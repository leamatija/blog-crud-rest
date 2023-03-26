package com.akademia.spring.dto.mapper;

import com.akademia.spring.dto.CategoryDTO;
import com.akademia.spring.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryMapper {

    public static CategoryDTO toDto(Category c){
        return CategoryDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }
    public static Category toEntity (CategoryDTO categoryDTO){
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .dateCreated(categoryDTO.getDateCreated())
                .dateModified(categoryDTO.getDateModified())
                .build();
    }
}
