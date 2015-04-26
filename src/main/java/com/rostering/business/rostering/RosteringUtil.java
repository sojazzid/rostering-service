package com.rostering.business.rostering;

import com.rostering.model.Allocation;
import com.rostering.model.Driver;
import com.rostering.model.Preference;
import com.rostering.model.Shift;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RosteringUtil {

    public static List<Preference> toPreference(List<Driver> driverList, List<Shift> shiftList) {

        List<Preference> preferenceList = new ArrayList<Preference>(driverList.size() * shiftList.size());

        for (Driver driver : driverList) {

            for (Shift shift : shiftList) {

                Preference preference = new Preference();
                preference.setDriver(driver);
                preference.setShift(shift);

                preferenceList.add(preference);

            }

        }

        return preferenceList;

    }

    public static List<Allocation> justAllocated(List<Allocation> allocationList) {

        Iterator<Allocation> allocationIterator = allocationList.iterator();

        while (allocationIterator.hasNext()) {
            if (!allocationIterator.next().isAllocated()) {
                allocationIterator.remove();
            }

        }

        return allocationList;
    }

}
