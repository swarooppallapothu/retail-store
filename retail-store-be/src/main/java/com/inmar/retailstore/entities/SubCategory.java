package com.inmar.retailstore.entities;

import javax.persistence.*;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */

@Entity
@Table(name = "sub_category", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sub_category", columnNames = {"name", "category_id"})
})
public class SubCategory extends AbstractEntity {

    private String name;

    private String description;

    public Category category;

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
    @JoinColumn(name = "category_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_sub_category_category"), nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
