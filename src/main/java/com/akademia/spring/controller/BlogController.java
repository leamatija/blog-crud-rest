package com.akademia.spring.controller;

import com.akademia.spring.dto.CategoryDTO;
import com.akademia.spring.dto.PostDTO;
import com.akademia.spring.service.CategoryService;
import com.akademia.spring.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {
    private final PostService postService;
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getPostCategories (){
        return ResponseEntity.ok(postService.getPostCategories());
    }


    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDTO>  getPostCategoryById (@PathVariable Integer id){
        return ResponseEntity.ok(postService.getPostCategoryById(id));
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.addCategory(categoryDTO));
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<Void> deleteCategory (@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Integer postId){
        return ResponseEntity.ok(postService.getPostsByCategory(postId));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
