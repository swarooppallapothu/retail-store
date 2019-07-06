package com.inmar.retailstore.controller;

import com.inmar.retailstore.entities.Department;
import com.inmar.retailstore.entities.Location;
import com.inmar.retailstore.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@RestController
@RequestMapping(value = "/api/department")
public class DepartmentResource extends AbstractResource<Department> {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentResource(DepartmentService departmentService) {
        super(departmentService);
        this.departmentService = departmentService;
    }

}
