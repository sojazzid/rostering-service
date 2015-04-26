package com.rostering.dao.impl;

import com.rostering.dao.rowmapper.DriverRowMapper;
import com.rostering.dao.AbstractJdbcTemplateDao;
import com.rostering.dao.DriverDao;
import com.rostering.dao.exception.PersistenceException;
import com.rostering.model.Driver;
import com.rostering.model.ShiftType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class DriverDaoImpl extends AbstractJdbcTemplateDao implements DriverDao {

    @Override
    public List<Driver> getByType(ShiftType shiftType) throws PersistenceException {

        try {

            return namedParameterJdbcTemplate.query("SELECT driver.id, driver.name, driver.type FROM driver where driver.type = :shiftType",
                    new MapSqlParameterSource("shiftType", shiftType.name()),
                    new DriverRowMapper());

        } catch (DataAccessException e) {
            throw new PersistenceException("Error al intentar obtener Maquinistas de tipo: " + shiftType, e);

        }
    }


}
