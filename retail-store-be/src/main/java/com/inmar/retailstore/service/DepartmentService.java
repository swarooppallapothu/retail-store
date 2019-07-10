package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiDepartment;
import com.inmar.retailstore.entities.Department;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface DepartmentService extends AbstractService<Department, UiDepartment> {

    List<UiDepartment> getAllByLocation(UUID locationId);

}
