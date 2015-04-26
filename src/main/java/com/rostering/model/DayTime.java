package com.rostering.model;

import java.util.HashMap;
import java.util.Map;

public enum DayTime {

    MANANA("M", "Mañana"), TARDE("T", "Tarde");

    private static Map<String, DayTime> DAY_TIME_BY_CODE_MAP = new HashMap<String, DayTime>(DayTime.values().length);

    static {

        for (DayTime dayTime : DayTime.values()) {
            DAY_TIME_BY_CODE_MAP.put(dayTime.getCode(), dayTime);
        }
    }

    private String code;
    private String description;

    DayTime(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public static DayTime find(String code) {
        return DAY_TIME_BY_CODE_MAP.get(code);
    }
}
