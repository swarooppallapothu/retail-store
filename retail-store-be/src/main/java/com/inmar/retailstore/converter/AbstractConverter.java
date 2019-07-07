package com.inmar.retailstore.converter;

import com.inmar.retailstore.bean.UiAbstractBean;
import com.inmar.retailstore.entities.AbstractEntity;
import com.inmar.retailstore.util.Constants;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public abstract class AbstractConverter<E, B> {

    public abstract E getEntityFromBean(B bean);

    public List<E> getEntitiesFromBeans(List<B> beans) {
        List<E> entities = new ArrayList();
        if (CollectionUtils.isEmpty(beans)) {
            return entities;
        }
        entities = beans.stream()
                .map(el -> getEntityFromBean(el))
                .filter(el -> !Objects.isNull(el))
                .collect(Collectors.toList());
        return entities;
    }

    public abstract List<B> getBeansFromEntities(List<E> entities, Constants.ResultType resultType);

    public abstract B getBeanFromEntity(E entity, Constants.ResultType resultType);

    public void mapCommonFields(AbstractEntity entity, UiAbstractBean bean) {
        bean.setId(entity.getId());
        bean.setCreatedOn(entity.getCreatedOn());
        bean.setUpdatedOn(entity.getUpdatedOn());
    }

    public void mapCommonFields(UiAbstractBean bean, AbstractEntity entity) {
        entity.setId(bean.getId());
        entity.setCreatedOn(bean.getCreatedOn());
        entity.setUpdatedOn(bean.getUpdatedOn());
    }
}
