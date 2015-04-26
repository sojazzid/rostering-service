package com.rostering.dao;

import com.rostering.dao.exception.PersistenceException;
import com.rostering.model.Driver;
import com.rostering.model.ShiftType;

import java.util.List;

public interface DriverDao {

    List<Driver> getByType(ShiftType shiftType) throws PersistenceException;
}
