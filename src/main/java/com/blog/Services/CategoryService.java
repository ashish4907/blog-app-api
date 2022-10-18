package com.blog.Services;

import java.util.List;

import com.blog.PayLoads.CategoryDTO;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryID);

    CategoryDTO getCategoyById(Integer categoryID);

    List<CategoryDTO> getAllCategory();

    void deleteCategory(Integer categoryId);

}
