package com.rostering.business.rostering.impl;

import com.rostering.business.rostering.RosteringService;
import com.rostering.model.Allocation;
import com.rostering.model.Driver;
import com.rostering.model.Preference;
import com.rostering.model.Shift;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/rostering-service-impl-test.xml")
//@ContextConfiguration("classpath:transport-model-impl-test.xml")

public class RosteringServiceMockTest {

    @Resource
    private RosteringService rosteringService;

    @Resource
    private List<Preference> preferenceList;


    @Test
    public void testDoRoster() throws Exception {

        List<Allocation> allocationList = rosteringService.doRoster(preferenceList);
        assertNotNull(allocationList);

        for (Allocation allocation : allocationList) {

            assertNotNull(allocation);
            Driver driver = allocation.getDriver();
            Shift shift = allocation.getShift();
            boolean allocated = allocation.isAllocated();

            assertNotNull(driver);
            assertNotNull(shift);


            if ("Pedro".equalsIgnoreCase(driver.getName())) {

                if ("Turno-1".equalsIgnoreCase(shift.getDescription())) {

                    assertTrue(allocated);

                } else {

                    assertFalse(allocated);

                }
            }

            if ("Juan".equalsIgnoreCase(driver.getName())) {

                if ("Turno-2".equalsIgnoreCase(shift.getDescription())) {

                    assertTrue(allocated);

                } else {

                    assertFalse(allocated);

                }
            }

            if ("Diego".equalsIgnoreCase(driver.getName())) {

                if ("Turno-3".equalsIgnoreCase(shift.getDescription())) {

                    assertTrue(allocated);

                } else {

                    assertFalse(allocated);

                }
            }
        }
    }
}
