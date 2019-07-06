package com.inmar.retailstore.entities;

import javax.persistence.*;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Entity
@Table(name = "department", uniqueConstraints = {
        @UniqueConstraint(name = "uk_department", columnNames = {"name", "location_id"})
})
public class Department extends AbstractEntity {

    private String name;

    private String description;

    private Location location;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_department_location"))
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
