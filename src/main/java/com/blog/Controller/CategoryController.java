package com.blog.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.PayLoads.APIResponse;
import com.blog.PayLoads.CategoryDTO;
import com.blog.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createCategory = this.categoryService.createCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(createCategory, HttpStatus.CREATED);

    }

    @PutMapping("/{categoryID}")

    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
            @PathVariable Integer categoryID) {
        CategoryDTO updateCategory = this.categoryService.updateCategory(categoryDTO, categoryID);

        return new ResponseEntity<CategoryDTO>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryID}")
    public ResponseEntity<APIResponse> deleteCategory(@PathVariable Integer categoryID) {
        this.categoryService.deleteCategory(categoryID);
        return new ResponseEntity<APIResponse>(new APIResponse("Category Deleted Successfully", true), HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }

    @GetMapping("/{categoryID}")
    public ResponseEntity<CategoryDTO> getSinglecATEGORY(@PathVariable Integer categoryID) {
        return ResponseEntity.ok(this.categoryService.getCategoyById(categoryID));
    }

}
