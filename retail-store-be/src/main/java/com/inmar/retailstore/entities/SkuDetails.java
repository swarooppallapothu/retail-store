package com.inmar.retailstore.entities;

import javax.persistence.*;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Entity
@Table(name = "sku_details", uniqueConstraints = {@UniqueConstraint(name = "uk_sku_details", columnNames = {"name", "sub_catagory_id"})})
public class SkuDetails extends AbstractEntity {

    private String name;

    private String description;

    private SubCategory subCategory;

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
    @JoinColumn(name = "sub_catagory_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_sku_details_sub_catagory_id"), nullable = false)
    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
