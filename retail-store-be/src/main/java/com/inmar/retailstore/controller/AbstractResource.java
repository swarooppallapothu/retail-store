package com.inmar.retailstore.controller;

import com.inmar.retailstore.bean.dto.ResponseDto;
import com.inmar.retailstore.service.AbstractService;
import com.inmar.retailstore.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public abstract class AbstractResource<E, B> {

    public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final AbstractService abstractService;

    public AbstractResource(AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<B>> get(@PathVariable(name = "id") UUID id) {
        try {
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, (B) abstractService.get(id)));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method get with id:" + id, e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<B>>> getAll() {
        try {
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, abstractService.getAll()));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method getAll", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDto<B>> insert(@RequestBody B bean) {
        try {
            bean = (B) abstractService.saveOrUpdate(bean);
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, bean));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method insert", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseDto<B>> update(@RequestBody B bean) {
        try {
            bean = (B) abstractService.saveOrUpdate(bean);
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS, bean));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method update", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable(name = "id") UUID id) {
        try {
            abstractService.delete(id);
            return ResponseEntity.ok(CommonUtils.buildResponse(ResponseDto.ResponseCode.SUCCESS));
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method delete", e);
            return new ResponseEntity<>(CommonUtils.buildResponse(ResponseDto.ResponseCode.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

}
