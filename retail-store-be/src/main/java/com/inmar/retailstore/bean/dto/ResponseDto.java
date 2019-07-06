package com.inmar.retailstore.bean.dto;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class ResponseDto<T> {

    public enum ResponseCode {
        SUCCESS, ERROR, INVALID_STATUS, NO_MORE_DATA;

        ResponseCode() {
        }
    }

    private final ResponseCode responseCode;
    private final T data;
    private final long recordsCount;
    private final int pageSize;
    private final int currentPage;
    private final String message;

    private ResponseDto(ResponseDtoBuilder<T> builder) {
        this.responseCode = builder.responseCode;
        this.data = builder.data;
        this.recordsCount = builder.recordsCount;
        this.pageSize = builder.pageSize;
        this.currentPage = builder.currentPage;
        this.message = builder.message;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public T getData() {
        return data;
    }

    public long getRecordsCount() {
        return recordsCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String getMessage() {
        return message;
    }

    public static class ResponseDtoBuilder<T> {

        private ResponseCode responseCode;
        private T data;
        private long recordsCount;
        private int pageSize;
        private int currentPage;
        private String message;

        public ResponseDtoBuilder(ResponseCode responseCode) {
            this.responseCode = responseCode;
        }

        public ResponseDtoBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseDtoBuilder<T> recordsCount(long recordsCount) {
            this.recordsCount = recordsCount;
            return this;
        }

        public ResponseDtoBuilder<T> pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ResponseDtoBuilder<T> currentPage(int currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public ResponseDtoBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResponseDto<T> build() {
            ResponseDto user = new ResponseDto(this);
            return user;
        }
    }
}
