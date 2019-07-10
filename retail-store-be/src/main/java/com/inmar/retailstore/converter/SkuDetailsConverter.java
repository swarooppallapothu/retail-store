package com.inmar.retailstore.converter;

import com.inmar.retailstore.bean.UiSkuDetails;
import com.inmar.retailstore.entities.SkuDetails;
import com.inmar.retailstore.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class SkuDetailsConverter extends AbstractConverter<SkuDetails, UiSkuDetails> {

    private final SubCategoryConverter subCategoryConverter;

    @Autowired
    public SkuDetailsConverter(@Lazy SubCategoryConverter subCategoryConverter) {
        this.subCategoryConverter = subCategoryConverter;
    }

    @Override
    public SkuDetails getEntityFromBean(UiSkuDetails bean) {
        SkuDetails entity = null;
        if (Objects.isNull(bean)) {
            return entity;
        }
        entity = new SkuDetails();
        entity.setName(bean.getName());
        entity.setDescription(bean.getDescription());
        entity.setSubCategory(subCategoryConverter.getEntityFromBean(bean.getSubCategory()));
        mapCommonFields(bean, entity);
        return entity;
    }

    @Override
    public UiSkuDetails getBeanFromEntity(SkuDetails entity, Constants.ResultType resultType) {
        UiSkuDetails bean = null;
        if (Objects.isNull(entity)) {
            return bean;
        }
        bean = new UiSkuDetails();
        bean.setName(entity.getName());
        bean.setDescription(entity.getDescription());
        bean.setSubCategory(subCategoryConverter.getBeanFromEntity(entity.getSubCategory(), resultType));
        mapCommonFields(entity, bean);

        return bean;
    }

}
