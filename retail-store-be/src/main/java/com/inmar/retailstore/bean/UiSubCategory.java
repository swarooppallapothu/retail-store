package com.inmar.retailstore.bean;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class UiSubCategory extends UiAbstractBean {

    private String name;

    private String description;

    private UiCategory category;

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

    public UiCategory getCategory() {
        return category;
    }

    public void setCategory(UiCategory category) {
        this.category = category;
    }
}
