package com.akademia.spring.service;

import com.akademia.spring.dto.CategoryDTO;
import com.akademia.spring.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();
    void deletePost(Integer id);
    List<PostDTO> getPostsByCategory(Integer categoryId);
    PostDTO getPostById (Integer id);
    List<CategoryDTO> getPostCategories();
    CategoryDTO getPostCategoryById (Integer categoryId);

}
