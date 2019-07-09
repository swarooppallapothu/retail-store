package com.inmar.retailstore.repository;

import com.inmar.retailstore.entities.SkuDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Repository
public interface SkuDetailsRepository extends JpaRepository<SkuDetails, UUID>, JpaSpecificationExecutor<SkuDetails> {
}
