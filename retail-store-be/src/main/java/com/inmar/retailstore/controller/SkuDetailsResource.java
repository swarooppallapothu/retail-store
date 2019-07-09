package com.inmar.retailstore.controller;

import com.inmar.retailstore.bean.UiSkuDetails;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.SkuDetails;
import com.inmar.retailstore.service.SkuDetailsService;
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
@RequestMapping(value = "/api/sku-details")
public class SkuDetailsResource extends AbstractResource<SkuDetails, UiSkuDetails> {

    private final SkuDetailsService skuDetailsService;

    @Autowired
    public SkuDetailsResource(SkuDetailsService skuDetailsService) {
        super(skuDetailsService);
        this.skuDetailsService = skuDetailsService;
    }

    @GetMapping("/sub-category/{subCategoryId}")
    public ResponseEntity<ResponseDto> getAllBySubCategory(@PathVariable(name = "subCategoryId") UUID subCategoryId) {
        try {
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, skuDetailsService.getAllBySubCategory(subCategoryId)));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method getAllBySubCategory", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

}
