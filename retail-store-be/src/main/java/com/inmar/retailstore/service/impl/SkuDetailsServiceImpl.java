package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.bean.UiSkuDetails;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.converter.SkuDetailsConverter;
import com.inmar.retailstore.entities.SkuDetails;
import com.inmar.retailstore.repository.SkuDetailsRepository;
import com.inmar.retailstore.service.SkuDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class SkuDetailsServiceImpl extends AbstractServiceImpl<SkuDetails, UiSkuDetails> implements SkuDetailsService {

    private final SkuDetailsRepository skuDetailsRepository;
    private final SkuDetailsConverter skuDetailsConverter;

    @Autowired
    public SkuDetailsServiceImpl(SkuDetailsRepository skuDetailsRepository, SkuDetailsConverter skuDetailsConverter) {
        super(skuDetailsRepository, skuDetailsConverter);
        this.skuDetailsRepository = skuDetailsRepository;
        this.skuDetailsConverter = skuDetailsConverter;
    }

    @Override
    public ResponseDto<List<UiSkuDetails>> search(RequestDto request) {
        return null;
    }
}
