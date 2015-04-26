package com.rostering.dao;

import com.rostering.dao.exception.PersistenceException;
import com.rostering.model.Shift;
import com.rostering.model.ShiftType;

import java.util.List;

public interface ShiftDao {

    List<Shift> getByType(ShiftType shiftType) throws PersistenceException;
}
