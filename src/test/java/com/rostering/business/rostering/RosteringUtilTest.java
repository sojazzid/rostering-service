package com.rostering.business.rostering;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/util-test-context.xml")
public class RosteringUtilTest {

    @Resource
    private List<Allocation> allocationList;

    @Resource
    private List<Driver> driverList;

    @Resource
    private List<Shift> shiftList;

    @Test
    public void testToPreference() throws Exception {

        List<Preference> preferenceList = RosteringUtil.toPreference(driverList, shiftList);
        assertEquals(driverList.size() * shiftList.size(), preferenceList.size());
        System.out.println(driverList);
        System.out.println(shiftList);
        System.out.println(preferenceList);
    }

    @Test
    public void testJustAllocated() throws Exception {

        List<Allocation> justAllocated = RosteringUtil.justAllocated(this.allocationList);
        assertNotNull(justAllocated);
        assertEquals(2, justAllocated.size());
        assertEquals(0, justAllocated.get(0).getDriver().getId());
        assertEquals(1000, justAllocated.get(1).getDriver().getId());

    }
}