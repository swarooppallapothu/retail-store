package com.inmar.retailstore.util;

import com.inmar.retailstore.bean.dto.ResponseDto;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class CommonUtils {

    public static ResponseDto buildResponse(ResponseDto.ResponseCode responseCode) {
        return new ResponseDto.ResponseDtoBuilder(responseCode).build();
    }

    public static <T> ResponseDto<T> buildResponse(ResponseDto.ResponseCode responseCode, T data) {
        return new ResponseDto.ResponseDtoBuilder(responseCode)
                .data(data)
                .build();
    }
}
