package com.akademia.spring.service.impl;

import com.akademia.spring.dto.CategoryDTO;
import com.akademia.spring.dto.PostDTO;
import com.akademia.spring.dto.mapper.CategoryMapper;
import com.akademia.spring.dto.mapper.PostMapper;
import com.akademia.spring.entity.Category;
import com.akademia.spring.entity.Post;
import com.akademia.spring.exception.NotFoundException;
import com.akademia.spring.repository.CategoryRepository;
import com.akademia.spring.repository.PostRepository;
import com.akademia.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> PostMapper.toDto(post))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePost(Integer id) {
    postRepository.deleteById(id);

    }

    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {
        Category category =categoryRepository.findById(categoryId).orElseThrow(()-> new NotFoundException("Category not found!"));
        List<PostDTO> postDTOS =category.getPosts().stream()
                .map(PostMapper::toDto)
                .collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public PostDTO getPostById(Integer id) {
        return postRepository.findById(id)
                .map(post -> PostMapper.toDto(post))
                .orElseThrow(()->new NotFoundException("This post can not be found!"));
    }

    @Override
    public List<CategoryDTO> getPostCategories() {
      return categoryRepository.findAll()
              .stream()
              .map(c->CategoryMapper.toDto(c))
              .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getPostCategoryById( Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .map(c->CategoryMapper.toDto(c))
                .orElseThrow(()->new NotFoundException("This category can not be found!"));
    }
}
