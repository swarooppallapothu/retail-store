package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiDepartment;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.Department;
import com.inmar.retailstore.service.AbstractService;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface DepartmentService extends AbstractService<Department> {

    ResponseDto<List<UiDepartment>> search(RequestDto request);

}
