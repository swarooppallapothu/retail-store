package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.bean.UiCategory;
import com.inmar.retailstore.entities.Category;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface CategoryService extends AbstractService<Category> {

    ResponseDto<List<UiCategory>> search(RequestDto request);

}
