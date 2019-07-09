package com.inmar.retailstore.controller;

import com.inmar.retailstore.bean.UiSkuDetails;
import com.inmar.retailstore.entities.SkuDetails;
import com.inmar.retailstore.service.SkuDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
