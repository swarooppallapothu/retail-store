package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiSubCategory;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.SubCategory;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface SubCategoryService extends AbstractService<SubCategory, UiSubCategory> {

    ResponseDto<List<UiSubCategory>> search(RequestDto request);

}
