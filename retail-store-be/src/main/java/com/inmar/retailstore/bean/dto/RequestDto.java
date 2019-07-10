package com.inmar.retailstore.bean.dto;

import com.inmar.retailstore.util.Constants;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class RequestDto {

    private UUID selectedId;

    private List<UUID> selectedIds = new ArrayList<>();

    private String searchText;

    private String searchAttribute;

    private ZonedDateTime fromDate;

    private ZonedDateTime toDate;

    private Constants.ResultType resultType = Constants.ResultType.LISTING;

    private long pageSize;

    private long currentPage;

    private String sortColumn;

    private Constants.SortDirection sortDirection;

    public UUID getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(UUID selectedId) {
        this.selectedId = selectedId;
    }

    public List<UUID> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(List<UUID> selectedIds) {
        this.selectedIds = selectedIds;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchAttribute() {
        return searchAttribute;
    }

    public void setSearchAttribute(String searchAttribute) {
        this.searchAttribute = searchAttribute;
    }

    public ZonedDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(ZonedDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public ZonedDateTime getToDate() {
        return toDate;
    }

    public void setToDate(ZonedDateTime toDate) {
        this.toDate = toDate;
    }

    public Constants.ResultType getResultType() {
        return resultType;
    }

    public void setResultType(Constants.ResultType resultType) {
        this.resultType = resultType;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public Constants.SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Constants.SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }
}
