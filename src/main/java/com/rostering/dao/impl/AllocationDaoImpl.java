package com.rostering.dao.impl;

import com.rostering.dao.AbstractJdbcTemplateDao;
import com.rostering.dao.AllocationDao;
import com.rostering.dao.exception.PersistenceException;
import com.rostering.model.Allocation;
import com.rostering.model.Driver;
import com.rostering.model.Preference;
import com.rostering.model.Shift;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AllocationDaoImpl extends AbstractJdbcTemplateDao implements AllocationDao {

    @Override
    public void save(final List<Allocation> allocationList) throws PersistenceException {

        try {
            jdbcTemplate.batchUpdate("insert into allocation (driver_id,shift_id,name,allocation,created_on) " +
                            " values (?,?,?,?,NOW()) ",
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {

                            Allocation allocation = allocationList.get(i);
                            ps.setInt(1, allocation.getDriver().getId());
                            ps.setInt(2, allocation.getShift().getId());
                            ps.setString(3, allocation.getName());
                            ps.setBoolean(4, allocation.isAllocated());
                        }

                        @Override
                        public int getBatchSize() {
                            return allocationList.size();
                        }
                    }
            );
        } catch (DataAccessException e) {
            throw new PersistenceException("Error al intentar guardar Asignaciones", e);

        }

    }

    private List<Preference> getAll() {
        return namedParameterJdbcTemplate.query("SELECT driver_id, shift_id, preference FROM allocation",
                new RowMapper<Preference>() {
                    @Override
                    public Preference mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Preference preference = new Preference();

                        Driver driver = new Driver();
                        driver.setId(rs.getInt("driver_id"));

                        Shift shift = new Shift();
                        shift.setId(rs.getInt("shift_id"));

                        preference.setDriver(driver);
                        preference.setShift(shift);
                        preference.setValue(rs.getInt("preference"));

                        return preference;
                    }
                }
        );
    }
}
