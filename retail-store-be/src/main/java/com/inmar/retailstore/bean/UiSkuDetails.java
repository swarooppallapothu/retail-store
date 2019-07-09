package com.inmar.retailstore.bean;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class UiSkuDetails extends UiAbstractBean {

    private String name;

    private String description;

    private UiSubCategory subCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UiSubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(UiSubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
