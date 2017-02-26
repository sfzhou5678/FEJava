package com.zsf.core;

import com.zsf.expression.Expression;
import com.zsf.model.Region;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by zsf on 2017/2/26.
 */
public class CoreMap extends CoreAlgebra{
    @Override
    public List<Expression> learn(List<Pair<Region, Region>> positiveExamplePairs) {
        List<Expression> witnesses=new ArrayList<Expression>();
        for (Pair<Region, Region> example:positiveExamplePairs){
            // TODO: 2017/2/26 decompose() ??
//            witnesses.add(decompose(example));
        }
        // TODO: 2017/2/26 Q1 & F.learn()??

        // TODO: 2017/2/26 Q2 & S.learn()??

        // TODO: 2017/2/26 map(q1,q2)
        List<Expression> expressions=new ArrayList<Expression>();
        return expressions;
    }

    public Expression decompose(Pair<Region, Region> example){
        return null;
    }

}
