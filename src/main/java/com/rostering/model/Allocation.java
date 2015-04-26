package com.rostering.model;

import java.io.Serializable;

public class Allocation implements Serializable {

    private int id;
    private Driver driver;
    private Shift shift;
    private boolean allocated;
    private String name;

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

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Allocation{");
        sb.append("id=").append(id);
        sb.append(", driver=").append(driver);
        sb.append(", shift=").append(shift);
        sb.append(", allocated=").append(allocated);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
