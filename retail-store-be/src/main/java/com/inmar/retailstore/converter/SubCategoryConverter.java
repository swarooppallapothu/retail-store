package com.inmar.retailstore.converter;

import com.inmar.retailstore.bean.UiSubCategory;
import com.inmar.retailstore.entities.SubCategory;
import com.inmar.retailstore.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class SubCategoryConverter extends AbstractConverter<SubCategory, UiSubCategory> {

    private final CategoryConverter categoryConverter;

    @Autowired
    public SubCategoryConverter(@Lazy CategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Override
    public SubCategory getEntityFromBean(UiSubCategory bean) {
        SubCategory entity = null;
        if (Objects.isNull(bean)) {
            return entity;
        }
        entity = new SubCategory();
        entity.setName(bean.getName());
        entity.setDescription(bean.getDescription());
        entity.setCategory(categoryConverter.getEntityFromBean(bean.getCategory()));
        mapCommonFields(bean, entity);
        return entity;
    }

    @Override
    public List<UiSubCategory> getBeansFromEntities(List<SubCategory> entities, Constants.ResultType resultType) {
        List<UiSubCategory> beans = new ArrayList();
        if (CollectionUtils.isEmpty(entities)) {
            return beans;
        }
        beans = entities.stream()
                .map(el -> getBeanFromEntity(el, resultType))
                .filter(el -> !Objects.isNull(el))
                .collect(Collectors.toList());
        return beans;
    }

    @Override
    public UiSubCategory getBeanFromEntity(SubCategory entity, Constants.ResultType resultType) {
        UiSubCategory bean = null;
        if (Objects.isNull(entity)) {
            return bean;
        }
        bean = new UiSubCategory();
        bean.setName(entity.getName());
        bean.setDescription(entity.getDescription());
        if (!Objects.isNull(entity.getCategory())) {
            entity.getCategory().setSubCategories(null);
            bean.setCategory(categoryConverter.getBeanFromEntity(entity.getCategory(), resultType));
        }

        mapCommonFields(entity, bean);

        return bean;
    }

}
