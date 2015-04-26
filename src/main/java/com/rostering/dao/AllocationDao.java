package com.rostering.dao;


import com.rostering.dao.exception.PersistenceException;
import com.rostering.model.Allocation;

import java.util.List;

public interface AllocationDao {

    public void save(List<Allocation> allocationList) throws PersistenceException;


}



