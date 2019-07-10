package com.inmar.retailstore.service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface AbstractService<E, B> {

    B get(UUID id);

    List<B> getAll();

    List<B> get(List<UUID> ids);

    B saveOrUpdate(B bean);

    List<B> saveOrUpdate(List<B> beans);

    void delete(UUID id);

    void delete(List<UUID> ids);

}
