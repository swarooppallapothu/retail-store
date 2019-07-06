package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.bean.UiSubCategory;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.SubCategory;
import com.inmar.retailstore.repository.SubCategoryRepository;
import com.inmar.retailstore.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class SubCategoryServiceImpl extends AbstractServiceImpl<SubCategory> implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        super(subCategoryRepository);
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public ResponseDto<List<UiSubCategory>> search(RequestDto request) {
        return null;
    }
}
