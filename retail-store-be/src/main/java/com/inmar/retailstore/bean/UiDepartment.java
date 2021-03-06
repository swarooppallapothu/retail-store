package com.inmar.retailstore.bean;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class UiDepartment extends UiAbstractBean {

    private String name;

    private String description;

    private UiLocation location;

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

    public UiLocation getLocation() {
        return location;
    }

    public void setLocation(UiLocation location) {
        this.location = location;
    }
}
