package com.rostering.dao.impl;

import com.rostering.dao.rowmapper.ShiftRowMapper;
import com.rostering.dao.AbstractJdbcTemplateDao;
import com.rostering.dao.ShiftDao;
import com.rostering.dao.exception.PersistenceException;
import com.rostering.model.Shift;
import com.rostering.model.ShiftType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class ShiftDaoImpl extends AbstractJdbcTemplateDao implements ShiftDao {

    @Override
    public List<Shift> getByType(ShiftType shiftType) throws PersistenceException {

        try {

            return namedParameterJdbcTemplate.query("SELECT shift.id, shift.description, shift.type FROM shift where shift.type = :shiftType",
                    new MapSqlParameterSource("shiftType", shiftType.name()),
                    new ShiftRowMapper());

        } catch (DataAccessException e) {
            throw new PersistenceException("Error al intentar obtener Turnos de tipo: " + shiftType, e);

        }
    }


}
