package com.rostering.model;

import java.io.Serializable;

public class Preference implements Serializable {

    private int id;
    private Driver driver;
    private Shift shift;
    private int value;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Preference{");
        sb.append("id=").append(id);
        sb.append(", driver=").append(driver);
        sb.append(", shift=").append(shift);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
