package com.zsf.core;

import com.zsf.expression.Expression;
import com.zsf.model.Region;
import javafx.util.Pair;

import java.util.List;
import java.util.Set;

/**
 * Created by zsf on 2017/2/26.
 */
public abstract class CoreAlgebra {
    public abstract List<Expression> learn(List<Pair<Region, Region>> positiveExamplePairs);

    /**
     * performance and ranking optimization
     * <p>
     * 1. removes each of those (lower-ranked) programs from an ordered set of programs
     * that is subsumed by some unremoved program
     * <p>
     * 2. it implements an important ranking criterion that assigns higher likelihood to the scenario
     *
     * @param expressions
     * @param positiveExamplePairs
     */
    public void cleanUp(List<Expression> expressions, List<Pair<Region, Region>> positiveExamplePairs) {

    }
}
