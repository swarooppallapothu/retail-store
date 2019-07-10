package com.inmar.retailstore.repository;

import com.inmar.retailstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

    @Query(value = "FROM User WHERE username = ?1")
    User getByUsername(String username);
}
