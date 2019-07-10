package com.inmar.retailstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Entity
@Table(name = "location", uniqueConstraints = {@UniqueConstraint(name = "uk_location", columnNames = {"name"})})
public class Location extends AbstractEntity {

    private String name;

    private String description;

    @Column(name = "name", length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", length = 1023)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
