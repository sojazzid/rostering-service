package com.rostering.dao.rowmapper;

import com.rostering.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PreferenceRowMapper implements RowMapper<Preference> {

    @Override
    public Preference mapRow(ResultSet resultSet, int i) throws SQLException {

        Preference preference = new Preference();
        preference.setId(resultSet.getInt("preferenceId"));

        Driver driver = new Driver();
        driver.setId(resultSet.getInt("driverId"));
        driver.setName(resultSet.getString("driverName"));

        String driverTypeName = resultSet.getString("driverType");
        driver.setType(ShiftType.valueOf(driverTypeName));

        preference.setDriver(driver);

        Shift shift = new Shift();
        shift.setId(resultSet.getInt("shiftId"));
        shift.setDescription(resultSet.getString("shiftDescription"));

        String shiftTypeName = resultSet.getString("shiftType");
        shift.setType(ShiftType.valueOf(shiftTypeName));

        shift.setRestingHours(resultSet.getTime("restingHours"));
        shift.setWorkingHours(resultSet.getTime("workingHours"));
        shift.setStartTime(resultSet.getTime("startTime"));
        shift.setEndTime(resultSet.getTime("endTime"));

        String startStationName = resultSet.getString("startStation");
        shift.setStartStation(Station.find(startStationName));

        String endStationName = resultSet.getString("endStation");
        shift.setEndStation(Station.find(endStationName));

        String dayTimeName = resultSet.getString("dayTime");
        shift.setDayTime(DayTime.find(dayTimeName));

        preference.setShift(shift);

        preference.setValue(resultSet.getInt("preferenceValue"));
        preference.setId(resultSet.getInt("preferenceId"));

        return preference;
    }
}
