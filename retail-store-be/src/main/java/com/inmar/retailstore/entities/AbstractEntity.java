package com.inmar.retailstore.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@MappedSuperclass
public class AbstractEntity {

    private static final long serialVersionUID = 6486192088436426369L;

    private UUID id;

    private ZonedDateTime createdOn = ZonedDateTime.now();

    private ZonedDateTime updatedOn;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "uuid-v1")
    @GenericGenerator(
            name = "uuid-v1",
            strategy = "uuid2",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", length = 16)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "created_on")
    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "updated_on")
    public ZonedDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(ZonedDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
