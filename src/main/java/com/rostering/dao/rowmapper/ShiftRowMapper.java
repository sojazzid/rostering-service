package com.rostering.dao.rowmapper;

import com.rostering.model.Shift;
import com.rostering.model.ShiftType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ShiftRowMapper implements RowMapper<Shift> {

    @Override
    public Shift mapRow(ResultSet resultSet, int i) throws SQLException {

        Shift shift = new Shift();
        shift.setId(resultSet.getInt("id"));
        shift.setDescription(resultSet.getString("description"));

        String shiftType = null;

        try {
            shiftType = resultSet.getString("type");
            shift.setType(ShiftType.valueOf(shiftType));
            return shift;

        } catch (IllegalArgumentException e) {
            throw new SQLException("Invalid type od Shift:[" + shiftType + "]", e);
        }
    }
}
