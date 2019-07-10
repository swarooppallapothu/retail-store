package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiSubCategory;
import com.inmar.retailstore.entities.SubCategory;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface SubCategoryService extends AbstractService<SubCategory, UiSubCategory> {

    List<UiSubCategory> getAllByCategory(UUID categoryId);

}
