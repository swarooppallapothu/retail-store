package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.converter.AbstractConverter;
import com.inmar.retailstore.entities.AbstractEntity;
import com.inmar.retailstore.service.AbstractService;
import com.inmar.retailstore.util.Constants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class AbstractServiceImpl<E, B> implements AbstractService<E, B> {

    private final JpaRepository<E, UUID> repository;
    private final AbstractConverter<E, B> converter;

    public AbstractServiceImpl(JpaRepository repository, AbstractConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public B get(UUID id) {
        Optional<E> entity = repository.findById(id);
        return entity.isPresent() ? converter.getBeanFromEntity(entity.get(), Constants.ResultType.LISTING) : null;
    }

    @Override
    public List<B> getAll() {
        return converter.getBeansFromEntities(repository.findAll(), Constants.ResultType.LISTING);
    }

    public List<B> get(List<UUID> ids) {
        return converter.getBeansFromEntities(repository.findAllById(ids), Constants.ResultType.LISTING);
    }

    public B saveOrUpdate(B bean) {
        if (bean instanceof AbstractEntity && !Objects.isNull(((AbstractEntity) bean).getId())) {
            ((AbstractEntity) bean).setUpdatedOn(ZonedDateTime.now());
        }
        E entity = converter.getEntityFromBean(bean);
        repository.save(entity);
        bean = converter.getBeanFromEntity(entity, Constants.ResultType.LISTING);
        return bean;
    }

    public List<B> saveOrUpdate(List<B> beans) {
        List<E> entities = converter.getEntitiesFromBeans(beans);
        if (!CollectionUtils.isEmpty(beans)) {
            beans.forEach((bean) -> {
                if (bean instanceof AbstractEntity && !Objects.isNull(((AbstractEntity) bean).getId())) {
                    ((AbstractEntity) bean).setUpdatedOn(ZonedDateTime.now());
                }
            });
        }
        repository.saveAll(entities);
        beans = converter.getBeansFromEntities(entities, Constants.ResultType.LISTING);
        return beans;
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public void delete(List<UUID> ids) {
        ids.stream().forEach((id) -> {
            delete(id);
        });
    }
}
