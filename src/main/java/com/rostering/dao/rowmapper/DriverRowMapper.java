package com.rostering.dao.rowmapper;

import com.rostering.model.Driver;
import com.rostering.model.ShiftType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DriverRowMapper implements RowMapper<Driver> {

    @Override
    public Driver mapRow(ResultSet resultSet, int i) throws SQLException {

        Driver driver = new Driver();
        driver.setId(resultSet.getInt("id"));
        driver.setName(resultSet.getString("name"));

        String driverType = null;

        try {
            driverType = resultSet.getString("type");
            driver.setType(ShiftType.valueOf(driverType));
            return driver;

        } catch (IllegalArgumentException e) {
            throw new SQLException("Invalid type od Driver:[" + driverType + "]", e);
        }
    }
}
