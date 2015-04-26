package com.rostering.model;

import java.util.HashMap;
import java.util.Map;

public enum Station {

    PUERTO("PU", "Puerto"), SARGENTO_ALDEA("SA", "Sargento Aldea"), LIMCACHE("LI", "Limache"), ESTACIONAMIENTO_BELLOTO("EB", "Belloto"), COCHERA("CO", "Cochera");

    private static Map<String, Station> STATION_BY_CODE_MAP = new HashMap<String, Station>(Station.values().length);

    static {

        for (Station station : Station.values()) {
            STATION_BY_CODE_MAP.put(station.getCode(), station);
        }

    }

    private final String code;
    private final String description;

    Station(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public static Station find(String code) {
        return STATION_BY_CODE_MAP.get(code);
    }
}
