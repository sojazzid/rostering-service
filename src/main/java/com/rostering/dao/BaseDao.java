package com.rostering.dao;

import com.rostering.model.ShiftType;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public interface BaseDao<T,K> {

    List<T> getAll();

    List<T> getByType(ShiftType shiftType);

    T find(K key);

    SqlParameterSource getSqlParameterSource(K key);
}
