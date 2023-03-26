package com.akademia.spring.service;

import com.akademia.spring.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO addCategory (CategoryDTO categoryDTO);
    void deleteCategory(Integer id);

}
