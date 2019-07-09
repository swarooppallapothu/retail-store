package com.inmar.retailstore.repository;

import com.inmar.retailstore.entities.Category;
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
public interface CategoryRepository extends JpaRepository<Category, UUID>, JpaSpecificationExecutor<Category> {

    @Query(value = "FROM Category WHERE department.id = ?1")
    public List<Category> getAllByDepartment(UUID departmentId);
}
