package com.rostering.business.rostering;

import com.rostering.business.rostering.exception.RosteringException;
import com.rostering.model.Allocation;
import com.rostering.model.Preference;

import java.util.List;

public interface RosteringService {

    List<Allocation> doRoster(List<Preference> preferenceList) throws RosteringException;

}
