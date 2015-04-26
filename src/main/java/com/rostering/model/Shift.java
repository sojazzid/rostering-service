package com.rostering.model;

import java.io.Serializable;
import java.sql.Time;

public class Shift implements Serializable {

    private int id;
    private String description;
    private ShiftType type;
    private Time restingHours;
    private Time workingHours;
    private Time startTime;
    private Time endTime;
    private Station startStation;
    private Station endStation;
    private DayTime dayTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ShiftType getType() {
        return type;
    }

    public void setType(ShiftType type) {
        this.type = type;
    }

    public Time getRestingHours() {
        return restingHours;
    }

    public void setRestingHours(Time restingHours) {
        this.restingHours = restingHours;
    }

    public Time getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Time workingHours) {
        this.workingHours = workingHours;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shift shift = (Shift) o;

        if (id != shift.id) return false;
        if (dayTime != shift.dayTime) return false;
        if (description != null ? !description.equals(shift.description) : shift.description != null) return false;
        if (endStation != shift.endStation) return false;
        if (endTime != null ? !endTime.equals(shift.endTime) : shift.endTime != null) return false;
        if (restingHours != null ? !restingHours.equals(shift.restingHours) : shift.restingHours != null) return false;
        if (startStation != shift.startStation) return false;
        if (startTime != null ? !startTime.equals(shift.startTime) : shift.startTime != null) return false;
        if (type != shift.type) return false;
        if (workingHours != null ? !workingHours.equals(shift.workingHours) : shift.workingHours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (restingHours != null ? restingHours.hashCode() : 0);
        result = 31 * result + (workingHours != null ? workingHours.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (startStation != null ? startStation.hashCode() : 0);
        result = 31 * result + (endStation != null ? endStation.hashCode() : 0);
        result = 31 * result + (dayTime != null ? dayTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shift{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", type=").append(type);
        sb.append(", restingHours=").append(restingHours);
        sb.append(", workingHours=").append(workingHours);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", startStation=").append(startStation);
        sb.append(", endStation=").append(endStation);
        sb.append(", dayTime=").append(dayTime);
        sb.append('}');
        return sb.toString();
    }
}
