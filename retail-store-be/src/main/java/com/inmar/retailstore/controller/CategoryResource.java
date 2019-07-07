package com.inmar.retailstore.controller;

import com.inmar.retailstore.bean.UiCategory;
import com.inmar.retailstore.entities.Category;
import com.inmar.retailstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@RestController
@RequestMapping(value = "/api/category")
public class CategoryResource extends AbstractResource<Category, UiCategory> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryResource(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }

}
