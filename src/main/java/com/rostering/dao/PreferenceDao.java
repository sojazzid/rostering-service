package com.rostering.dao;


import com.rostering.dao.exception.PersistenceException;
import com.rostering.model.Driver;
import com.rostering.model.Preference;
import com.rostering.model.Shift;

import java.util.List;

public interface PreferenceDao {

    int getPreferenceValue(Driver driver, Shift shift) throws PersistenceException;

    int getPreferenceValue(int driver, int shift) throws PersistenceException;

    List<Preference> getPreferences() throws PersistenceException;

    List<Preference> getPreferences(Driver driver) throws PersistenceException;

    List<Preference> getPreferences(Shift shift) throws PersistenceException;

    Preference find(Driver driver, Shift shift) throws PersistenceException;

    void update(Preference preference) throws PersistenceException;


}



