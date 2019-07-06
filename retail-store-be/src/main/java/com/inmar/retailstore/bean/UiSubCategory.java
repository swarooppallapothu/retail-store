package com.inmar.retailstore.bean;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class UiSubCategory extends UiAbstractBean {

    private String name;

    private String description;

    private UiCategory uiCategory;

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

    public UiCategory getUiCategory() {
        return uiCategory;
    }

    public void setUiCategory(UiCategory uiCategory) {
        this.uiCategory = uiCategory;
    }
}
