package com.rostering.business.rostering.impl;

import com.rostering.business.rostering.RosteringService;
import com.rostering.model.Preference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/rostering-service-impl-test.xml")
//@ContextConfiguration("classpath:transport-model-impl-test.xml")

public class RosteringServiceImplTest {

    @Resource
    private RosteringService rosteringService;

    @Resource
    private List<Preference> preferenceList;


    @Test
    public void testDoRoster() throws Exception {

        System.out.println(rosteringService.doRoster(preferenceList));

    }
}
