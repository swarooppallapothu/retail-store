package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.bean.UiCategory;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.converter.CategoryConverter;
import com.inmar.retailstore.entities.Category;
import com.inmar.retailstore.repository.CategoryRepository;
import com.inmar.retailstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class CategoryServiceImpl extends AbstractServiceImpl<Category, UiCategory> implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        super(categoryRepository, categoryConverter);
        this.categoryConverter = categoryConverter;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseDto<List<UiCategory>> search(RequestDto request) {
        return null;
    }
}
