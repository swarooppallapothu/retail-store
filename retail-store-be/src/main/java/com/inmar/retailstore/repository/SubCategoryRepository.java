package com.inmar.retailstore.repository;

import com.inmar.retailstore.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID>, JpaSpecificationExecutor<SubCategory> {
}
