package com.rostering.business.rostering.impl;

import net.sf.javailp.*;
import org.junit.Test;

public class ILPTestTaha {

    @Test
    public void testILP() {

        SolverFactory factory = new SolverFactoryGLPK(); // use glpk
        factory.setParameter(Solver.VERBOSE, 0);
        factory.setParameter(Solver.TIMEOUT, 100); // set timeout to 100 seconds

/**
 * Constructing a Problem:
 * Maximize z = 5x + 4y
 * Subject to:
 * 10x+60y <= 45
 * x+y <= 5
 *
 * With x,y being integers
 *
 */
        Problem problem = new Problem();

        Linear linear = new Linear();
        linear.add(5, "x");
        linear.add(4, "y");

        problem.setObjective(linear, OptType.MAX);

        linear = new Linear();
        linear.add(1, "x");
        linear.add(1, "y");

        problem.add(linear, "<=", 5);

        linear = new Linear();
        linear.add(10, "x");
        linear.add(6, "y");

        problem.add(linear, "<=", 45);


        problem.setVarType("x", Integer.class);
        problem.setVarType("y", Integer.class);

        //problem.setVarType("x", VarType.REAL);
        //problem.setVarType("y", VarType.REAL);

        Solver solver = factory.get(); // you should use this solver only once for one problem
        Result result = solver.solve(problem);

        System.out.println(problem);
        System.out.println(result);


    }


}
