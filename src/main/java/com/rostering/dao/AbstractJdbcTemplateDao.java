package com.rostering.dao;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.Resource;

public abstract class AbstractJdbcTemplateDao {

    protected String sql;

    @Resource
    protected JdbcTemplate jdbcTemplate;

    @Resource
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Required
    protected String getSql() {
        return this.sql;
    }




}
