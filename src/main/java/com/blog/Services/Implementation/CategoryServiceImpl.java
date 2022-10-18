package com.blog.Services.Implementation;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Entity.Category;
import com.blog.Exception.ResourceNotFoundException;
import com.blog.PayLoads.CategoryDTO;
import com.blog.Repository.CategoryRepo;
import com.blog.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Category category = this.modelMapper.map(categoryDTO, Category.class);
        Category saveCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(saveCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryID) {

        Category category = this.categoryRepo.findById(categoryID)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryID));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());

        Category updateCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(updateCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO getCategoyById(Integer categoryID) {
        Category category = this.categoryRepo.findById(categoryID)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryID));

        return this.modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        
        List<Category> categories = this.categoryRepo.findAll();
       List<CategoryDTO> categoryList = categories.stream().map(category -> this.modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
        return categoryList;
    }

    @Override
    public void deleteCategory(Integer categoryID) {
        Category category = this.categoryRepo.findById(categoryID)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryID));
        this.categoryRepo.delete(category);
    }

}
