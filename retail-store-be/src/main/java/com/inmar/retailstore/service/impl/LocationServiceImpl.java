package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.bean.UiLocation;
import com.inmar.retailstore.converter.LocationConverter;
import com.inmar.retailstore.entities.Location;
import com.inmar.retailstore.repository.LocationRepository;
import com.inmar.retailstore.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class LocationServiceImpl extends AbstractServiceImpl<Location, UiLocation> implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationConverter locationConverter;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, LocationConverter locationConverter) {
        super(locationRepository, locationConverter);
        this.locationRepository = locationRepository;
        this.locationConverter = locationConverter;
    }

}
