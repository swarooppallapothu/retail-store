package com.inmar.retailstore.service;

import com.inmar.retailstore.bean.UiLocation;
import com.inmar.retailstore.bean.dto.RequestDto;
import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.entities.Location;

import java.util.List;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface LocationService extends AbstractService<Location> {

    ResponseDto<List<UiLocation>> search(RequestDto request);

}
