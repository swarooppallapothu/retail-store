package com.inmar.retailstore.controller;

import com.inmar.retailstore.entities.SubCategory;
import com.inmar.retailstore.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@RestController
@RequestMapping(value = "/api/sub-category")
public class SubCategoryResource extends AbstractResource<SubCategory> {

    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryResource(SubCategoryService subCategoryService) {
        super(subCategoryService);
        this.subCategoryService = subCategoryService;
    }

}
