package com.inmar.retailstore.controller;

import com.inmar.retailstore.bean.UiDepartment;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.Department;
import com.inmar.retailstore.service.DepartmentService;
import com.inmar.retailstore.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@RestController
@RequestMapping(value = "/api/department")
public class DepartmentResource extends AbstractResource<Department, UiDepartment> {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentResource(DepartmentService departmentService) {
        super(departmentService);
        this.departmentService = departmentService;
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<ResponseDto> getAllByLocation(@PathVariable(name = "locationId") UUID locationId) {
        try {
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, departmentService.getAllByLocation(locationId)));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method getAllByLocation", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

}
