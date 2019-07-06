package com.inmar.retailstore.service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface AbstractService<T> {

    T get(UUID id);

    List<T> getAll();

    List<T> get(List<UUID> ids);

    void saveOrUpdate(T entity);

    void saveOrUpdate(List<T> entities);

    void delete(UUID id);

    void delete(List<UUID> ids);

}
