package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiCategory;
import com.inmar.retailstore.entities.Category;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface CategoryService extends AbstractService<Category, UiCategory> {

    List<UiCategory> getAllByDepartment(UUID departmentId);

}
