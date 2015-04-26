package com.rostering.dao;

import com.rostering.model.Driver;
import com.rostering.model.ShiftType;

import java.util.List;


public class DriverDaoMock implements DriverDao {



    @Override
    public List<Driver> getByType(ShiftType shiftType) {
        return null;
    }

}
