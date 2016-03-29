package com.rostering.business.rostering.impl;

import com.rostering.business.rostering.RosteringService;
import com.rostering.model.Allocation;
import com.rostering.model.Driver;
import com.rostering.model.Preference;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RosteringServiceMock implements RosteringService {

    private List<Allocation> allocationList;

    @Override
    public List<Allocation> doRoster(List<Preference> preferenceList) {

        return allocationList;
    }

    @Required
    public void setAllocationList(List<Allocation> allocationList) {
        this.allocationList = allocationList;
    }
}
