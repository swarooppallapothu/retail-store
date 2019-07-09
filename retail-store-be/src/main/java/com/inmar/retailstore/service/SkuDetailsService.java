package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiSkuDetails;
import com.inmar.retailstore.entities.SkuDetails;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface SkuDetailsService extends AbstractService<SkuDetails, UiSkuDetails> {

    List<UiSkuDetails> getAllBySubCategory(UUID subCategoryId);

}
