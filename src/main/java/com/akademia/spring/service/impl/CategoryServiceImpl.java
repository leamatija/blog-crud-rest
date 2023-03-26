package com.akademia.spring.service.impl;

import com.akademia.spring.dto.CategoryDTO;
import com.akademia.spring.dto.mapper.CategoryMapper;
import com.akademia.spring.entity.Category;
import com.akademia.spring.repository.CategoryRepository;
import com.akademia.spring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category c = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDto(c);
    }

    @Override
    public void deleteCategory(Integer id) {
    categoryRepository.deleteById(id);
    }
}
