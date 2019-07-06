package com.inmar.retailstore.controller;

import com.inmar.retailstore.entities.Location;
import com.inmar.retailstore.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@RestController
@RequestMapping(value = "/api/location")
public class LocationResource extends AbstractResource<Location> {

    private final LocationService locationService;

    @Autowired
    public LocationResource(LocationService locationService) {
        super(locationService);
        this.locationService = locationService;
    }

}
