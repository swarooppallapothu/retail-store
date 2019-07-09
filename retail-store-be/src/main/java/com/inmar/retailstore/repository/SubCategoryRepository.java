package com.inmar.retailstore.repository;

import com.inmar.retailstore.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID>, JpaSpecificationExecutor<SubCategory> {

    @Query(value = "FROM SubCategory WHERE category.id = ?1")
    public List<SubCategory> getAllByCategory(UUID categoryId);
}
