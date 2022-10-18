package com.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
