package com.rostering.business.rostering.impl;

import com.rostering.business.rostering.RosteringService;
import com.rostering.business.rostering.exception.RosteringException;
import com.rostering.model.Allocation;
import com.rostering.model.Driver;
import com.rostering.model.Preference;
import com.rostering.model.Shift;
import net.sf.javailp.*;
import org.springframework.beans.factory.annotation.Required;

import java.util.*;

public class RosteringServiceImpl implements RosteringService {

    private SolverFactory solverFactory;
    private int timeout = 0;
    private int verbose = 1;
    private int postSolve = 2;


    @Override
    public List<Allocation> doRoster(List<Preference> preferenceList) throws RosteringException {

        Problem problem = new Problem();

        setObjectiveFunction(preferenceList, problem);

        setConstraints(preferenceList, problem);

        Solver solver = solverFactory.get(); // you should use this solver only once for one problem
        Result result = solver.solve(problem);
        System.out.println(result);

        if (null == result) {
            throw new RosteringException("No existe una solución factible para el problema modelado");
        }

        List<Allocation> allocationList = new ArrayList<Allocation>(preferenceList.size());

        for (Preference preference : preferenceList) {

            Allocation allocation = new Allocation();
            allocation.setDriver(preference.getDriver());
            allocation.setShift(preference.getShift());
            allocation.setAllocated(result.getBoolean("X" + preference.getDriver().getId() + "," + preference.getShift().getId()));
            allocationList.add(allocation);
        }

        System.out.println(problem);
        return allocationList;

    }

    private void setConstraints(List<Preference> preferenceList, Problem problem) {

        eachShiftCanBeAllocatedOnlyToOneDriver(preferenceList, problem);

        eachDriverCanBeAllocatedOnlyToOneShift(preferenceList, problem);
    }

    private void setObjectiveFunction(List<Preference> preferenceList, Problem problem) {

        Linear objectiveFunction = new Linear();

        for (Preference preference : preferenceList) {

            problem.setVarType("X" + preference.getDriver().getId() + "," + preference.getShift().getId(), Boolean.class);
            objectiveFunction.add(preference.getValue(), "X" + preference.getDriver().getId() + "," + preference.getShift().getId());

        }

        problem.setObjective(objectiveFunction, OptType.MAX);
    }

    private static void eachShiftCanBeAllocatedOnlyToOneDriver(List<Preference> preferenceList, Problem problem) {

        Map<Driver, List<Preference>> map = groupPreferencesByDriver(preferenceList);

        Iterator<Map.Entry<Driver, List<Preference>>> it = map.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry<Driver, List<Preference>> pairs;
            pairs = it.next();

            addConstraint(problem, "driver[" + pairs.getKey().getId() + "]", pairs.getValue());

            it.remove(); // avoids a ConcurrentModificationException
        }

    }

    private static void eachDriverCanBeAllocatedOnlyToOneShift(List<Preference> preferenceList, Problem problem) {

        Map<Shift, List<Preference>> map = groupPreferencesByShift(preferenceList);

        Iterator<Map.Entry<Shift, List<Preference>>> it = map.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry<Shift, List<Preference>> pairs;
            pairs = it.next();

            addConstraint(problem, "shift[" + pairs.getKey().getId() + "]", pairs.getValue());

            it.remove(); // avoids a ConcurrentModificationException
        }

    }

    private static void eachDriverCanBeAllocatedOnlyToOneShift2(List<Preference> preferenceList, Problem problem) {

        Map<Shift, List<Preference>> map = groupPreferencesByShift(preferenceList);

        for (List<Preference> groupedPreferenceList : map.values()) {

            addConstraint(problem, "driver[" + groupedPreferenceList.get(0).getShift() + "]", groupedPreferenceList);
        }

    }

    private static void addConstraint(Problem problem, String name, List<Preference> preferenceList) {

        Linear linear = new Linear();

        for (Preference preference : preferenceList) {

            linear.add(1, "X" + preference.getDriver().getId() + "," + preference.getShift().getId());
        }

        problem.add(new Constraint(name, linear, "=", 1));
    }

        /*
    private static Collection<List<Preference>> groupPreferencesByDriver(List<Preference> preferenceList) {

        Map<Driver, List<Preference>> map = new HashMap<Driver, List<Preference>>();

        for (Preference preference : preferenceList) {
            Driver key = preference.getDriver();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<Preference>());
            }
            map.get(key).add(preference);
        }

        return map.values();
    } */

    private static Map<Driver, List<Preference>> groupPreferencesByDriver(List<Preference> preferenceList) {

        Map<Driver, List<Preference>> map = new HashMap<Driver, List<Preference>>();

        for (Preference preference : preferenceList) {
            Driver key = preference.getDriver();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<Preference>());
            }
            map.get(key).add(preference);
        }

        return map;
    }

    /*
    private static Collection<List<Preference>> groupPreferencesByShift(List<Preference> preferenceList) {

        Map<Shift, List<Preference>> map = new HashMap<Shift, List<Preference>>();

        for (Preference preference : preferenceList) {
            Shift key = preference.getShift();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<Preference>());
            }
            map.get(key).add(preference);
        }

        return map.values();
    }       */

    private static Map<Shift, List<Preference>> groupPreferencesByShift(List<Preference> preferenceList) {

        Map<Shift, List<Preference>> map = new HashMap<Shift, List<Preference>>();

        for (Preference preference : preferenceList) {
            Shift key = preference.getShift();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<Preference>());
            }
            map.get(key).add(preference);
        }

        return map;
    }


    @Required
    public void setSolverFactory(SolverFactory solverFactory) {
        this.solverFactory = solverFactory;
    }

    @Required
    public void setVerbose(int verbose) {
        this.verbose = verbose;
    }

    @Required
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Required
    public void setPostSolve(int postSolve) {
        this.postSolve = postSolve;
    }

    public void init() {

        solverFactory.setParameter(Solver.TIMEOUT, timeout);
        solverFactory.setParameter(Solver.VERBOSE, verbose);
        solverFactory.setParameter(Solver.POSTSOLVE, postSolve);

    }
}
