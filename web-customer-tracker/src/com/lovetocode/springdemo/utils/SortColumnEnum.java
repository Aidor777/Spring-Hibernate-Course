package com.lovetocode.springdemo.utils;

public enum SortColumnEnum {

    FIRST_NAME("firstName"), LAST_NAME("lastName"), EMAIL("email");

    private String columnName;

    private SortColumnEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
