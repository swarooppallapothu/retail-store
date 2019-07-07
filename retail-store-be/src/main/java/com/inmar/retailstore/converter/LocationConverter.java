package com.inmar.retailstore.converter;

import com.inmar.retailstore.bean.UiLocation;
import com.inmar.retailstore.entities.Location;
import com.inmar.retailstore.util.Constants;
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
public class LocationConverter extends AbstractConverter<Location, UiLocation> {

    @Override
    public Location getEntityFromBean(UiLocation bean) {
        Location entity = null;
        if (Objects.isNull(bean)) {
            return entity;
        }
        entity = new Location();
        entity.setName(bean.getName());
        entity.setDescription(bean.getDescription());
        mapCommonFields(bean, entity);
        return entity;
    }

    @Override
    public List<UiLocation> getBeansFromEntities(List<Location> entities, Constants.ResultType resultType) {
        List<UiLocation> beans = new ArrayList();
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
    public UiLocation getBeanFromEntity(Location entity, Constants.ResultType resultType) {
        UiLocation bean = null;
        if (Objects.isNull(entity)) {
            return bean;
        }
        bean = new UiLocation();
        bean.setName(entity.getName());
        bean.setDescription(entity.getDescription());

        mapCommonFields(entity, bean);

        return bean;
    }

}
