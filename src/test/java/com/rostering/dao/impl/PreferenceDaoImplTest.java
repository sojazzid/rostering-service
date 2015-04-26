package com.rostering.dao.impl;

import com.rostering.dao.PreferenceDao;
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
@ContextConfiguration("classpath:META-INF/preference-dao-impl-test.xml")
public class PreferenceDaoImplTest {

    @Resource
    private PreferenceDao preferenceDao;

    @Resource
    private Shift shift;

    @Resource
    private Driver driver;

    @Test
    public void testGetPreferenceValue() throws Exception {

        assertEquals(3, preferenceDao.getPreferenceValue(driver, shift));

    }

    @Test
    public void testGetAllPreferences() throws Exception {
        List<Preference> preferences = preferenceDao.getPreferences();
        System.out.println(preferences);
        assertNotNull(preferences);
        assertEquals(2500, preferences.size());
    }

    @Test
    public void testGetPreferencesByDriver() throws Exception {
        List<Preference> preferences = preferenceDao.getPreferences(driver);
        System.out.println(preferences);
        assertNotNull(preferences);
        assertEquals(50, preferences.size());
    }

    @Test
    public void testGetPreferencesByShift() throws Exception {
        List<Preference> preferences = preferenceDao.getPreferences(shift);
        System.out.println(preferences);
        assertNotNull(preferences);
        assertEquals(50, preferences.size());
    }

    @Test
    public void testFind() throws Exception {
        Preference preference = preferenceDao.find(driver, shift);
        System.out.println(preference);
        assertNotNull(preference);
    }

    @Test
    public void testUpdate() throws Exception {


        Preference preference = preferenceDao.find(driver, shift);
        System.out.println(preference);

        preference.setValue(generateValue(1, 10));

        preferenceDao.update(preference);
        System.out.println(preference);
    }

    private static int generateValue(int min, int max) {

        return min + (int) (Math.random() * ((max - min) + 1));

    }


}