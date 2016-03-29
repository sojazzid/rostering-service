package com.rostering.business.rostering.impl;

import com.rostering.dao.BaseDao;
import com.rostering.dao.PreferenceDao;
import com.rostering.model.Driver;
import com.rostering.model.Shift;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/rostering-service-impl-int-test.xml")

public class RosteringServiceIT {

    @Resource
    private RosteringServiceImpl rosteringService;

    @Resource
    private PreferenceDao preferenceDao;

    @Resource
    private BaseDao<Shift, Integer> shiftDao;

    @Resource
    private BaseDao<Driver, Integer> driverDao;


    @Test
    public void testDoRoster() throws Exception {

        // TODO: Implement test

        // List<Preference> preferenceList = preferenceDao.getAll();


       /* for (Preference preference : preferenceList) {

            Shift shift = shiftDao.find(preference.getShift().getId());
            Driver driver = driverDao.find(preference.getDriver().getId());

            preference.setShift(shift);
            preference.setDriver(driver);

        }


        System.out.println(rosteringService.doRoster(preferenceList));
        */
    }
}
