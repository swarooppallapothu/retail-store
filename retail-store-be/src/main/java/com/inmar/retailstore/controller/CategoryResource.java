package com.inmar.retailstore.controller;

import com.inmar.retailstore.bean.UiCategory;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.Category;
import com.inmar.retailstore.service.CategoryService;
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
@RequestMapping(value = "/api/category")
public class CategoryResource extends AbstractResource<Category, UiCategory> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryResource(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<ResponseDto> getAllByDepartment(@PathVariable(name = "departmentId") UUID departmentId) {
        try {
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, categoryService.getAllByDepartment(departmentId)));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method getAllByDepartment", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }


}
