package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.bean.UiSubCategory;
import com.inmar.retailstore.converter.SubCategoryConverter;
import com.inmar.retailstore.entities.SubCategory;
import com.inmar.retailstore.repository.SubCategoryRepository;
import com.inmar.retailstore.service.SubCategoryService;
import com.inmar.retailstore.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class SubCategoryServiceImpl extends AbstractServiceImpl<SubCategory, UiSubCategory> implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryConverter subCategoryConverter;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, SubCategoryConverter subCategoryConverter) {
        super(subCategoryRepository, subCategoryConverter);
        this.subCategoryRepository = subCategoryRepository;
        this.subCategoryConverter = subCategoryConverter;
    }

    @Override
    public List<UiSubCategory> getAllByCategory(UUID categoryId) {
        return subCategoryConverter.getBeansFromEntities(subCategoryRepository.getAllByCategory(categoryId), Constants.ResultType.SELECTION);
    }
}
