package com.rostering.business.rostering.impl;

import com.rostering.business.rostering.RosteringService;
import com.rostering.model.Allocation;
import com.rostering.model.Driver;
import com.rostering.model.Preference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RosteringServiceMockImpl implements RosteringService {

    @Override
    public List<Allocation> doRoster(List<Preference> preferenceList) {

        List<Allocation> allocationList = new ArrayList<Allocation>(preferenceList.size());

        Set<Driver> allocatedDrivers = new HashSet<Driver>();

        for (Preference preference : preferenceList) {

            Allocation allocation = new Allocation();
            allocation.setShift(preference.getShift());
            allocation.setDriver(preference.getDriver());

            if (!allocatedDrivers.contains(preference.getDriver())) {
                allocation.setAllocated(true);
                allocatedDrivers.add(preference.getDriver());
            }

            allocationList.add(allocation);
        }

        return allocationList;
    }
}
