package com.inmar.retailstore.converter;

import com.inmar.retailstore.bean.UiCategory;
import com.inmar.retailstore.entities.Category;
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
public class CategoryConverter extends AbstractConverter<Category, UiCategory> {

    private final DepartmentConverter departmentConverter;
    private final SubCategoryConverter subCategoryConverter;

    @Autowired
    public CategoryConverter(DepartmentConverter departmentConverter,
                             @Lazy SubCategoryConverter subCategoryConverter) {
        this.departmentConverter = departmentConverter;
        this.subCategoryConverter = subCategoryConverter;
    }

    @Override
    public Category getEntityFromBean(UiCategory bean) {
        Category entity = null;
        if (Objects.isNull(bean)) {
            return entity;
        }
        entity = new Category();
        entity.setName(bean.getName());
        entity.setDescription(bean.getDescription());
        entity.setDepartment(departmentConverter.getEntityFromBean(bean.getDepartment()));
        entity.setSubCategories(subCategoryConverter.getEntitiesFromBeans(bean.getSubCategories()));
        mapCommonFields(bean, entity);
        return entity;
    }

    @Override
    public List<UiCategory> getBeansFromEntities(List<Category> entities, Constants.ResultType resultType) {
        List<UiCategory> beans = new ArrayList();
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
    public UiCategory getBeanFromEntity(Category entity, Constants.ResultType resultType) {
        UiCategory bean = null;
        if (Objects.isNull(entity)) {
            return bean;
        }
        bean = new UiCategory();
        bean.setName(entity.getName());
        bean.setDescription(entity.getDescription());
        bean.setDepartment(departmentConverter.getBeanFromEntity(entity.getDepartment(), resultType));

        if (!CollectionUtils.isEmpty(entity.getSubCategories())) {
            entity.getSubCategories().forEach((e) -> {
                e.setCategory(null);
            });
            bean.setSubCategories(subCategoryConverter.getBeansFromEntities(entity.getSubCategories(), resultType));
        }

        mapCommonFields(entity, bean);
        return bean;
    }

}
