package com.rostering.dao.impl;

import com.rostering.dao.AllocationDao;
import com.rostering.model.Allocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/allocation-dao-test.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class AllocationDaoImplTest {

    @Resource
    private AllocationDao allocationDao;

    @Resource
    private List<Allocation> allocationList;


    @Test
    public void testSave() throws Exception {

        allocationDao.save(allocationList);

    }

}