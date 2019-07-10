package com.inmar.retailstore.bean;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class UiCategory extends UiAbstractBean {

    private String name;

    private String description;

    private UiDepartment department;

    private List<UiSubCategory> subCategories;

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

    public UiDepartment getDepartment() {
        return department;
    }

    public void setDepartment(UiDepartment department) {
        this.department = department;
    }

    public List<UiSubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<UiSubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
