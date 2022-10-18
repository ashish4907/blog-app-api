package com.blog.PayLoads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private Integer categoryId;
    
    @NotBlank
    @Size(min = 4,max = 15,message = "Minimum size of category title is 4 and maximum is 15")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, message = "Minimum size of category description is 10")
    private String categoryDescription;
    
    
}
