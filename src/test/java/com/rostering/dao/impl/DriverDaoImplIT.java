package com.rostering.dao.impl;

import com.rostering.dao.DriverDao;
import com.rostering.model.Driver;
import com.rostering.model.ShiftType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/driver-dao-impl-test.xml")
@Transactional()
@TransactionConfiguration(transactionManager="txManager")

public class DriverDaoImplIT {

    @Resource
    private DriverDao driverDao;


    @Test
    public void testGetFullTime() throws Exception {

        List<Driver> driverList = driverDao.getByType(ShiftType.FULL_TIME);
        assertNotNull(driverList);
        System.out.println("# de maquinistas de planta " + driverList.size());
        System.out.println(driverList);

    }

    @Test
    public void testGetPartTimeWeekdays() throws Exception {

        List<Driver> driverList = driverDao.getByType(ShiftType.PART_TIME_WEEKDAY);
        assertNotNull(driverList);
        System.out.println("# de maquinistas parttime de semana " + driverList.size());
        System.out.println(driverList);

    }

    @Test
    public void testGetPartTimeWeekend() throws Exception {

        List<Driver> driverList = driverDao.getByType(ShiftType.PART_TIME_WEEKEND);
        assertNotNull(driverList);
        System.out.println("# de maquinistas parttime de fin de semana " + driverList.size());
        System.out.println(driverList);

    }


}
