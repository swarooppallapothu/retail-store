package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.bean.UiDepartment;
import com.inmar.retailstore.converter.DepartmentConverter;
import com.inmar.retailstore.entities.Department;
import com.inmar.retailstore.repository.DepartmentRepository;
import com.inmar.retailstore.service.DepartmentService;
import com.inmar.retailstore.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class DepartmentServiceImpl extends AbstractServiceImpl<Department, UiDepartment> implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentConverter departmentConverter;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        super(departmentRepository, departmentConverter);
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    @Override
    public List<UiDepartment> getAllByLocation(UUID locationId) {
        return departmentConverter.getBeansFromEntities(departmentRepository.getAllByLocation(locationId), Constants.ResultType.SELECTION);
    }
}
