package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiSkuDetails;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.SkuDetails;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface SkuDetailsService extends AbstractService<SkuDetails, UiSkuDetails> {

    ResponseDto<List<UiSkuDetails>> search(RequestDto request);

}
