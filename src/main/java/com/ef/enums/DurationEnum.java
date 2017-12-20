package com.ef.enums;

public enum DurationEnum {

    HOURLY("hourly"),
    DAILY("daily");

    private final String label;

    DurationEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
