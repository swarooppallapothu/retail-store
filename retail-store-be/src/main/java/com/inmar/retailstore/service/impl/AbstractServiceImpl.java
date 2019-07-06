package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.entities.AbstractEntity;
import com.inmar.retailstore.service.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class AbstractServiceImpl<T> implements AbstractService<T> {

    JpaRepository<T, UUID> repository;

    public AbstractServiceImpl(JpaRepository repository) {
        this.repository = repository;
    }

    public T get(UUID id) {
        Optional<T> entity = repository.findById(id);
        return entity.isPresent() ? entity.get() : null;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    public List<T> get(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    public void saveOrUpdate(T entity) {
        if (entity instanceof AbstractEntity) {
            ((AbstractEntity) entity).setUpdatedOn(ZonedDateTime.now());
        }
        repository.save(entity);
    }

    public void saveOrUpdate(List<T> entities) {
        repository.saveAll(entities);
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
