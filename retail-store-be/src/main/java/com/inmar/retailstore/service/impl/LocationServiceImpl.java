package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.bean.UiLocation;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.Location;
import com.inmar.retailstore.repository.LocationRepository;
import com.inmar.retailstore.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Service
public class LocationServiceImpl extends AbstractServiceImpl<Location> implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        super(locationRepository);
        this.locationRepository = locationRepository;
    }

    @Override
    public ResponseDto<List<UiLocation>> search(RequestDto request) {
        return null;
    }
}
