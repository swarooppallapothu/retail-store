package com.inmar.retailstore.converter;

import com.inmar.retailstore.bean.UiDepartment;
import com.inmar.retailstore.entities.Department;
import com.inmar.retailstore.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DepartmentConverter extends AbstractConverter<Department, UiDepartment> {

    private final LocationConverter locationConverter;

    @Autowired
    public DepartmentConverter(LocationConverter locationConverter) {
        this.locationConverter = locationConverter;
    }

    @Override
    public Department getEntityFromBean(UiDepartment bean) {
        Department entity = null;
        if (Objects.isNull(bean)) {
            return entity;
        }
        entity = new Department();
        entity.setName(bean.getName());
        entity.setDescription(bean.getDescription());
        entity.setLocation(locationConverter.getEntityFromBean(bean.getLocation()));
        mapCommonFields(bean, entity);
        return entity;
    }

    @Override
    public UiDepartment getBeanFromEntity(Department entity, Constants.ResultType resultType) {
        UiDepartment bean = null;
        if (Objects.isNull(entity)) {
            return bean;
        }
        bean = new UiDepartment();
        bean.setName(entity.getName());
        bean.setDescription(entity.getDescription());
        bean.setLocation(locationConverter.getBeanFromEntity(entity.getLocation(), resultType));

        mapCommonFields(entity, bean);

        return bean;
    }

}
