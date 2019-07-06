package com.inmar.retailstore.bean;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class UiAbstractBean {

    private UUID id;

    private ZonedDateTime createdOn = ZonedDateTime.now();

    private ZonedDateTime updatedOn;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public ZonedDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(ZonedDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
