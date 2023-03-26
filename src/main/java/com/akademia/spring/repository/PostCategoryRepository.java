package com.akademia.spring.repository;

import com.akademia.spring.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory,Integer> {
}
