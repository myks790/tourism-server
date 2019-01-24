package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.Category;
import com.myks790.tourismserver.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Category save(@RequestBody Category category) {
        Category existingCategory = categoryRepository.findByTitle(category.getTitle());
        if (existingCategory != null){
            return existingCategory;
        }
        return categoryRepository.save(category);
    }

    @GetMapping("/default")
    public List<Category> getDefaultCategory(){
        return categoryRepository.findFirst7By();
    }
}
