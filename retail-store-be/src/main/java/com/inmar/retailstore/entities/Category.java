package com.inmar.retailstore.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */

@Entity
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(name = "uk_category", columnNames = {"name", "departmant_id"})
})
public class Category extends AbstractEntity {

    private String name;

    private String description;

    private Department department;

    public List<SubCategory> subCategories;

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
    @JoinColumn(name = "departmant_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_category_department"))
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
