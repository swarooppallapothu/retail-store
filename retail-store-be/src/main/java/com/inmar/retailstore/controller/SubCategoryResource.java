package com.inmar.retailstore.controller;

import com.inmar.retailstore.bean.UiSubCategory;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.SubCategory;
import com.inmar.retailstore.service.SubCategoryService;
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
@RequestMapping(value = "/api/sub-category")
public class SubCategoryResource extends AbstractResource<SubCategory, UiSubCategory> {

    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryResource(SubCategoryService subCategoryService) {
        super(subCategoryService);
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ResponseDto> getAllByCategory(@PathVariable(name = "categoryId") UUID categoryId) {
        try {
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, subCategoryService.getAllByCategory(categoryId)));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method getAllByCategory", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

}
