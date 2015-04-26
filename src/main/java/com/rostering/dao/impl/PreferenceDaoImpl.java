package com.rostering.dao.impl;

import com.rostering.dao.AbstractJdbcTemplateDao;
import com.rostering.dao.PreferenceDao;
import com.rostering.dao.exception.PersistenceException;
import com.rostering.dao.rowmapper.PreferenceRowMapper;
import com.rostering.model.Driver;
import com.rostering.model.Preference;
import com.rostering.model.Shift;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferenceDaoImpl extends AbstractJdbcTemplateDao implements PreferenceDao {


    @Override
    public int getPreferenceValue(Driver driver, Shift shift) throws PersistenceException {
        return getPreferenceValue(driver.getId(), shift.getId());
    }

    @Override
    public int getPreferenceValue(int driverId, int shiftId) throws PersistenceException {
        Map<String, Integer> map = new HashMap<String, Integer>(2);
        map.put("driver", driverId);
        map.put("shift", shiftId);

        System.out.println("getPreferenceValue ");
        System.out.println("driverId " + driverId);
        System.out.println("shiftId " + shiftId);

        try {

            return namedParameterJdbcTemplate.queryForObject("" +
                            "SELECT preference.value " +
                            "FROM preference " +
                            "where preference.driver_id = :driver " +
                            "and preference.shift_id = :shift",
                    new MapSqlParameterSource(map),
                    Integer.class
            );
        } catch (EmptyResultDataAccessException e) {
            throw new PersistenceException("No hay preferencia del Maquinista[" + driverId + "] por el Turno[" + shiftId + "]", e);

        } catch (IncorrectResultSizeDataAccessException e) {
            throw new PersistenceException("Se ha encontrado más de una preferencia del Maquinista[" + driverId + "] por el Turno[" + shiftId + "]", e);

        } catch (DataAccessException e) {
            throw new PersistenceException("Error al intentar recuperar preferencia del Maquinista[" + driverId + "] por el Turno[" + shiftId + "]", e);

        }
    }

    @Override
    public List<Preference> getPreferences() throws PersistenceException {
        try {

            return namedParameterJdbcTemplate.query("" +
                            "SELECT\n" +
                            "  driver.id             AS driverId,\n" +
                            "  driver.name           AS driverName,\n" +
                            "  driver.type           AS driverType,\n" +
                            "  shift.id              AS shiftId,\n" +
                            "  shift.description     AS shiftDescription,\n" +
                            "  shift.type            AS shiftType,\n" +
                            "  shift.resting_hours   AS restingHours,\n" +
                            "  shift.working_hours   AS workingHours,\n" +
                            "  shift.start_time      AS startTime,\n" +
                            "  shift.end_time        AS endTime,\n" +
                            "  shift.initial_station AS startStation,\n" +
                            "  shift.final_station   AS endStation,\n" +
                            "  shift.day_time        AS dayTime,\n" +
                            "  preference.value      AS preferenceValue,\n" +
                            "  preference.id         AS preferenceId\n" +
                            "\n" +
                            "FROM driver, preference, shift\n" +
                            "\n" +
                            "WHERE preference.driver_id = driver.id\n" +
                            "      AND preference.shift_id = shift.id\n",

                    new PreferenceRowMapper()
            );

        } catch (DataAccessException e) {
            throw new PersistenceException(e);

        }
    }

    @Override
    public List<Preference> getPreferences(Driver driver) throws PersistenceException {

        try {

            return namedParameterJdbcTemplate.query("" +
                            "SELECT\n" +
                            "  driver.id             AS driverId,\n" +
                            "  driver.name           AS driverName,\n" +
                            "  driver.type           AS driverType,\n" +
                            "  shift.id              AS shiftId,\n" +
                            "  shift.description     AS shiftDescription,\n" +
                            "  shift.type            AS shiftType,\n" +
                            "  shift.resting_hours   AS restingHours,\n" +
                            "  shift.working_hours   AS workingHours,\n" +
                            "  shift.start_time      AS startTime,\n" +
                            "  shift.end_time        AS endTime,\n" +
                            "  shift.initial_station AS startStation,\n" +
                            "  shift.final_station   AS endStation,\n" +
                            "  shift.day_time        AS dayTime,\n" +
                            "  preference.value      AS preferenceValue,\n" +
                            "  preference.id         AS preferenceId\n" +
                            "\n" +
                            "FROM driver, preference, shift\n" +
                            "\n" +
                            "WHERE driver.id = :driverId\n" +
                            "      AND preference.driver_id = :driverId\n" +
                            "      AND preference.driver_id = driver.id\n" +
                            "      AND preference.shift_id = shift.id",

                    new MapSqlParameterSource("driverId", driver.getId()),
                    new PreferenceRowMapper()
            );

        } catch (DataAccessException e) {
            throw new PersistenceException(e);

        }
    }

    @Override
    public List<Preference> getPreferences(Shift shift) throws PersistenceException {
        try {

            return namedParameterJdbcTemplate.query("" +
                            "SELECT\n" +
                            "  driver.id             AS driverId,\n" +
                            "  driver.name           AS driverName,\n" +
                            "  driver.type           AS driverType,\n" +
                            "  shift.id              AS shiftId,\n" +
                            "  shift.description     AS shiftDescription,\n" +
                            "  shift.type            AS shiftType,\n" +
                            "  shift.resting_hours   AS restingHours,\n" +
                            "  shift.working_hours   AS workingHours,\n" +
                            "  shift.start_time      AS startTime,\n" +
                            "  shift.end_time        AS endTime,\n" +
                            "  shift.initial_station AS startStation,\n" +
                            "  shift.final_station   AS endStation,\n" +
                            "  shift.day_time        AS dayTime,\n" +
                            "  preference.value      AS preferenceValue,\n" +
                            "  preference.id         AS preferenceId\n" +
                            "\n" +
                            "FROM driver, preference, shift\n" +
                            "\n" +
                            "WHERE shift.id = :shiftId\n" +
                            "      AND preference.shift_id = :shiftId\n" +
                            "      AND preference.driver_id = driver.id\n" +
                            "      AND preference.shift_id = shift.id \n",

                    new MapSqlParameterSource("shiftId", shift.getId()),
                    new PreferenceRowMapper()
            );

        } catch (DataAccessException e) {
            throw new PersistenceException(e);

        }
    }

    @Override
    public Preference find(Driver driver, Shift shift) throws PersistenceException {
        try {

            return namedParameterJdbcTemplate.queryForObject("" +
                            "SELECT\n" +
                            "  driver.id             AS driverId,\n" +
                            "  driver.name           AS driverName,\n" +
                            "  driver.type           AS driverType,\n" +
                            "  shift.id              AS shiftId,\n" +
                            "  shift.description     AS shiftDescription,\n" +
                            "  shift.type            AS shiftType,\n" +
                            "  shift.resting_hours   AS restingHours,\n" +
                            "  shift.working_hours   AS workingHours,\n" +
                            "  shift.start_time      AS startTime,\n" +
                            "  shift.end_time        AS endTime,\n" +
                            "  shift.initial_station AS startStation,\n" +
                            "  shift.final_station   AS endStation,\n" +
                            "  shift.day_time        AS dayTime,\n" +
                            "  preference.value      AS preferenceValue,\n" +
                            "  preference.id         AS preferenceId\n" +
                            "FROM driver, preference, shift\n" +
                            "WHERE driver.id = :driverId\n" +
                            "      AND shift.id = :shiftId\n" +
                            "      AND preference.driver_id = :driverId\n" +
                            "      AND preference.shift_id = :shiftId\n" +
                            "      AND preference.driver_id = driver.id\n" +
                            "      AND preference.shift_id = shift.id",

                    new MapSqlParameterSource("shiftId", shift.getId()).addValue("driverId", driver.getId()),
                    new PreferenceRowMapper()
            );

        } catch (DataAccessException e) {
            throw new PersistenceException(e);

        }
    }

    @Override
    public void update(Preference preference) throws PersistenceException {
        try {
            namedParameterJdbcTemplate.update("" +
                    "UPDATE PREFERENCE\n" +
                    "SET value = :value\n" +
                    "WHERE id =:id", new BeanPropertySqlParameterSource(preference));

        } catch (DataAccessException e) {
            throw new PersistenceException("Error al intentar actualizar preferencia: " + preference, e);

        }
    }

    private int[] save(final List<Preference> preferenceList) throws PersistenceException {

        try {

            return jdbcTemplate.batchUpdate("insert into preference (driver_id,shift_id,value) " +
                            " values (?,?,?) ",
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {

                            Preference preference = preferenceList.get(i);
                            ps.setInt(1, preference.getDriver().getId());
                            ps.setInt(2, preference.getShift().getId());
                            ps.setInt(3, preference.getValue());
                        }

                        @Override
                        public int getBatchSize() {
                            return preferenceList.size();
                        }
                    }
            );

        } catch (DataAccessException e) {
            throw new PersistenceException("Error al intentar guardar preferencias", e);

        }

    }

}
