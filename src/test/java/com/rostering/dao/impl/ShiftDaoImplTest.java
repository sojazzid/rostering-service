package com.rostering.dao.impl;

import com.rostering.dao.ShiftDao;
import com.rostering.model.Shift;
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
@ContextConfiguration("classpath:META-INF/shift-dao-impl-test.xml")
@Transactional()
@TransactionConfiguration(transactionManager="txManager")

public class ShiftDaoImplTest {

    @Resource
    private ShiftDao shiftDao;

    @Test
    public void testGetFullTime() throws Exception {

        List<Shift> shiftList = shiftDao.getByType(ShiftType.FULL_TIME);
        assertNotNull(shiftList);
        System.out.println("# de turnos de planta " + shiftList.size());
        System.out.println(shiftList);

    }

    @Test
    public void testGetPartTimeWeekdays() throws Exception {

        List<Shift> shiftList = shiftDao.getByType(ShiftType.PART_TIME_WEEKDAY);
        assertNotNull(shiftList);
        System.out.println("# de turnos parttime de semana " + shiftList.size());
        System.out.println(shiftList);

    }

    @Test
    public void testGetPartTimeWeekend() throws Exception {

        List<Shift> shiftList = shiftDao.getByType(ShiftType.PART_TIME_WEEKEND);
        assertNotNull(shiftList);
        System.out.println("# de maquinistas parttime de fin de semana " + shiftList.size());
        System.out.println(shiftList);

    }

}
